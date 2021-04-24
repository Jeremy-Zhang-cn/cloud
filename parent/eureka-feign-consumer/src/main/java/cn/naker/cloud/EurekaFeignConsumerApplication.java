package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaFeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignConsumerApplication.class, args);
	}

}
