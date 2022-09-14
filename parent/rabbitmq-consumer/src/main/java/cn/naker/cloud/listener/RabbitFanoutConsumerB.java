package cn.naker.cloud.listener;

import cn.naker.cloud.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B))
public class RabbitFanoutConsumerB {

	@RabbitHandler
	public void process(Map<String, Object> map) {
		System.out.println("exchange topic b: " + map.toString());
	}

}
