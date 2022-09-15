package cn.naker.cloud.listener;

import cn.naker.cloud.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author Zhang Dingjie
 * @date 2022/9/15
 * @Description
 */
@Component
public class RabbitHeadersConsumer {

	@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A))
	public void processA(Message message) throws UnsupportedEncodingException {
		MessageProperties messageProperties = message.getMessageProperties();
		String contentType = messageProperties.getContentType();
		System.out.println("队列[" + RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A + "]收到消息: " + new String(message.getBody(), contentType));
	}

	@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_B))
	public void processB(Message message) throws UnsupportedEncodingException {
		MessageProperties messageProperties = message.getMessageProperties();
		String contentType = messageProperties.getContentType();
		System.out.println("队列[" + RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_B + "]收到消息: " + new String(message.getBody(), contentType));
	}

}
