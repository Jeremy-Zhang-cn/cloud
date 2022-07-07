package cn.naker.cloud.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.alibaba.otter.canal.protocol.exception.CanalClientException;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author Zhang Dingjie
 * @date 2022/7/7
 * @Description
 */
public class CanalClient implements Runnable {

	private static final int BATCH_SIZE = 100;


	@Override
	public void run() {
		CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("172.16.30.33", 11111),
				"instance01", "", "");

		try {
			// 打开连接
			connector.connect();
			// 订阅指定数据库下的指定表
			connector.subscribe("cloud.t_canal");
			// 回滚至未进行ack的地方，下次fetch的时候可以从最后一个没有ack的地方开始拿
			connector.rollback();
			while (true) {
				// 获取定量数据
				Message message = connector.getWithoutAck(BATCH_SIZE);
				// 获取批量ID
				long batchId = message.getId();
				// 获取本批量数量
				int size = message.getEntries().size();
				if (batchId == -1 || size == 0) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					printEntry(message.getEntries());
				}
				// 进行batchId的确认， 确认之后 小于此batchId的Message都会被确认
				connector.ack(batchId);
			}
		} catch (CanalClientException e) {
			e.printStackTrace();
		} finally {
			connector.disconnect();
		}
	}

	private void printEntry(List<CanalEntry.Entry> entries) {
		for (CanalEntry.Entry entry : entries) {
			if (CanalEntry.EntryType.TRANSACTIONBEGIN.equals(entry.getEntryType()) ||
					CanalEntry.EntryType.TRANSACTIONEND.equals(entry.getEntryType())
			) {
				// 跳过事务操作
				continue;
			}

			// 包含了一行数据变化的所有特征
			//比如isDdl 是否是ddl变更操作 sql 具体的ddl sql beforeColumns afterColumns 变更前后的数据字段等等
			CanalEntry.RowChange rowChange;

			try {
				rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
			} catch (InvalidProtocolBufferException e) {
				throw new RuntimeException("ERROR ## parse row change, data: " + entry, e);
			}

			// 获取操作类型 INSERT/UPDATE/DELETE
			CanalEntry.EventType eventType = rowChange.getEventType();
			System.out.printf("================》; binlog[%s:%s] , name[%s,%s] , eventType : %s%n",
					entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
					entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
					eventType);

			//判断是否是DDL语句
			if (rowChange.getIsDdl()) {
				System.out.println("================》;isDdl: true,sql:" + rowChange.getSql());
			}

			//获取RowChange对象里的每一行数据，打印出来
			for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
				//如果是删除语句
				if (eventType == CanalEntry.EventType.DELETE) {
					printColumn(rowData.getBeforeColumnsList());
					//如果是新增语句
				} else if (eventType == CanalEntry.EventType.INSERT) {
					printColumn(rowData.getAfterColumnsList());
					//如果是更新的语句
				} else {
					//变更前的数据
					System.out.println("------->; before");
					printColumn(rowData.getBeforeColumnsList());
					//变更后的数据
					System.out.println("------->; after");
					printColumn(rowData.getAfterColumnsList());
				}
			}
		}
	}


	private void printColumn(List<CanalEntry.Column> columns) {
		for (CanalEntry.Column column : columns) {
			System.out.println(column.getName() + ":" + column.getValue() + "  update=" + column.getUpdated());
		}
	}


}
