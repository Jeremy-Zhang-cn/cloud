package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhang Dingjie
 * @date 2022/3/25
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RocketMQConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketMQConsumerApplication.class, args);
	}

}
