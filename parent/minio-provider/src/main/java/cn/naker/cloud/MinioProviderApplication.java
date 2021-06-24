package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description
 */

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.naker.cloud"}, exclude = {SecurityAutoConfiguration.class})
public class MinioProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinioProviderApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}

}
