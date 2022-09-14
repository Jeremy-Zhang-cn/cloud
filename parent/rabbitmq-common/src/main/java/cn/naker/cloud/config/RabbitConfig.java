package cn.naker.cloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
@Configuration
public class RabbitConfig implements BeanPostProcessor {

	@Resource
	private RabbitAdmin rabbitAdmin;

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		rabbitAdmin.setAutoStartup(true);
		return rabbitAdmin;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		rabbitAdmin.declareExchange(rabbitmqDemoDirectExchange());
		rabbitAdmin.declareQueue(rabbitmqDemoDirectQueue());

		rabbitAdmin.declareExchange(rabbitmqDemoFanoutExchange());
		rabbitAdmin.declareQueue(fanoutExchangeQueueA());
		rabbitAdmin.declareQueue(fanoutExchangeQueueB());

		rabbitAdmin.declareExchange(rabbitmqDemoTopicExchange());
		rabbitAdmin.declareQueue(topicExchangeQueueA());
		rabbitAdmin.declareQueue(topicExchangeQueueB());
		rabbitAdmin.declareQueue(topicExchangeQueueC());

		return null;
	}

	@Bean
	public Queue rabbitmqDemoDirectQueue() {
		return new Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC, true, false, false);
	}

	@Bean
	public DirectExchange rabbitmqDemoDirectExchange() {
		return new DirectExchange(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, true, false);
	}

	@Bean
	public Binding bindDirect() {
		return BindingBuilder
				.bind(rabbitmqDemoDirectQueue())
				.to(rabbitmqDemoDirectExchange())
				.with(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING);
	}

	@Bean
	public Queue fanoutExchangeQueueA() {
		return new Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_A, true, false, false);
	}

	@Bean
	public Queue fanoutExchangeQueueB() {
		return new Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B, true, false, false);
	}

	@Bean
	public FanoutExchange rabbitmqDemoFanoutExchange() {
		return new FanoutExchange(RabbitMQConfig.FANOUT_EXCHANGE_DEMO_NAME, true, false);
	}

	@Bean
	public Binding bindFanoutA() {
		return BindingBuilder
				.bind(fanoutExchangeQueueA())
				.to(rabbitmqDemoFanoutExchange());
	}

	@Bean
	public Binding bindFanoutB() {
		return BindingBuilder
				.bind(fanoutExchangeQueueB())
				.to(rabbitmqDemoFanoutExchange());
	}

	@Bean
	public TopicExchange rabbitmqDemoTopicExchange() {
		return new TopicExchange(RabbitMQConfig.TOPIC_EXCHANGE_DEMO_NAME, true, false);
	}

	@Bean
	public Queue topicExchangeQueueA() {
		return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_A, true, false, false);
	}

	@Bean
	public Queue topicExchangeQueueB() {
		return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_B, true, false, false);
	}

	@Bean
	public Queue topicExchangeQueueC() {
		return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_C, true, false, false);
	}

	@Bean
	public Binding bindTopicA() {
		return BindingBuilder
				.bind(topicExchangeQueueA())
				.to(rabbitmqDemoTopicExchange())
				.with("a.*");
	}

	@Bean
	public Binding bindTopicB() {
		return BindingBuilder
				.bind(topicExchangeQueueB())
				.to(rabbitmqDemoTopicExchange())
				.with("a.*");
	}

	@Bean
	public Binding bindTopicC() {
		return BindingBuilder
				.bind(topicExchangeQueueC())
				.to(rabbitmqDemoTopicExchange())
				.with("rabbit.#");
	}

}
