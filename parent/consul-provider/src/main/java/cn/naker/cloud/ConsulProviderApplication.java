package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhang Dingjie
 * @date 2021/4/17
 * @Description
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulProviderApplication.class, args);
	}



}
