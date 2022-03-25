package cn.naker.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Zhang Dingjie
 * @date 2022/3/25
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "first-topic", consumerGroup = "my-consumer-group")
@Slf4j
public class ConsumerService implements RocketMQListener<String> {

	@Override
	public void onMessage(String msg) {
		log.info("consumer接收到消息为:" + msg);
	}
}
