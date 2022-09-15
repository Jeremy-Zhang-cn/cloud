package cn.naker.cloud.service;

import java.util.Map;

/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
public interface RabbitMQService {

	String sendMsg(String msg);

	String sendMsgByFanout(String msg);

	String sendMsgByTopic(String msg, String routingKey);

	String sendMsgByHeaders(String msg, Map<String, Object> headers);

}
