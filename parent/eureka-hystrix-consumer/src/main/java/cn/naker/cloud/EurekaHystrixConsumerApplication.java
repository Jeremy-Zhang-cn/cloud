package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */

// 可以使用@SpringCloudApplication替换下边除@EnableFeignClients外的三个注解
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class EurekaHystrixConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHystrixConsumerApplication.class, args);
	}

}
