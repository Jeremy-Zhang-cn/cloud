package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaRibbonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonConsumerApplication.class, args);
	}

	/**
	* @Author Zhang Dingjie
	* @Date 2021/4/23
	* @Param []
	* @return org.springframework.web.client.RestTemplate
	* @description 提供restTemplate, 加上@LoadBalanced注解之后只能通过服务名调用而不能使用ip地址调用服务
	**/
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}

}
