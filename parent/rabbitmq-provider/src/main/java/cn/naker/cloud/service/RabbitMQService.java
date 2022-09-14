package cn.naker.cloud.service;

/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
public interface RabbitMQService {

	String sendMsg(String msg);

	String sendMsgByFanout(String msg);

	String sendMsgByTopic(String msg, String routingKey);

}
