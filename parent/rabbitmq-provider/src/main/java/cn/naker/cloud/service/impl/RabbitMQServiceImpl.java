package cn.naker.cloud.service.impl;

import cn.naker.cloud.service.RabbitMQService;
import cn.naker.cloud.config.RabbitMQConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
@Service
public class RabbitMQServiceImpl implements RabbitMQService {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Resource
	private RabbitTemplate rabbitTemplate;

	@Override
	public String sendMsg(String msg) {
		try {
			HashMap<String, Object> map = getMessage(msg);
			rabbitTemplate.convertAndSend(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE,
					RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING, map);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public String sendMsgByFanout(String msg) {
		try {
			HashMap<String, Object> message = getMessage(msg);
			rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_DEMO_NAME,
					"", message);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public String sendMsgByTopic(String msg, String routingKey) {
		try {
			HashMap<String, Object> message = getMessage(msg);
			rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_DEMO_NAME,
					routingKey, message);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	private HashMap<String, Object> getMessage(String msg) {
		String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
		String sendTime = sdf.format(new Date());
		HashMap<String, Object> map = new HashMap<>();
		map.put("msgId", msgId);
		map.put("sendTime", sendTime);
		map.put("msg", msg);
		return map;
	}

	@Override
	public String sendMsgByHeaders(String msg, Map<String, Object> headers) {
		try {
			MessageProperties messageProperties = new MessageProperties();
			messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
			messageProperties.setContentType("UTF-8");
			messageProperties.getHeaders().putAll(headers);
			Message message = new Message(msg.getBytes(StandardCharsets.UTF_8), messageProperties);
			rabbitTemplate.convertAndSend(RabbitMQConfig.HEADERS_EXCHANGE_DEMO_NAME, null, message);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
