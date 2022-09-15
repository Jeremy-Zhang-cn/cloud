package cn.naker.cloud.config;

/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
public class RabbitMQConfig {

	public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";
	public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";
	public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";

	public static final String FANOUT_EXCHANGE_QUEUE_TOPIC_A = "fanout.A";
	public static final String FANOUT_EXCHANGE_QUEUE_TOPIC_B = "fanout.B";
	public static final String FANOUT_EXCHANGE_DEMO_NAME = "fanout.exchange.demo.name";

	public static final String TOPIC_EXCHANGE_DEMO_NAME = "topic.exchange.demo.name";
	public static final String TOPIC_EXCHANGE_QUEUE_A = "topic.queue.a";
	public static final String TOPIC_EXCHANGE_QUEUE_B = "topic.queue.b";
	public static final String TOPIC_EXCHANGE_QUEUE_C = "topic.queue.c";

	public static final String HEADERS_EXCHANGE_DEMO_NAME = "headers.exchange.demo.name";
	public static final String HEADERS_EXCHANGE_QUEUE_A = "headers.queue.a";
	public static final String HEADERS_EXCHANGE_QUEUE_B = "headers.queue.b";

}
