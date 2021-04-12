package cn.naker.cloud.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Jeremy
 * @date 2021/4/10
 * @description
 */

@RestController
@RequestMapping(value = "/sys/eureka/consumer")
public class ConsumerController {

	@Resource
	private LoadBalancerClient loadBalancerClient;
	@Resource
	private RestTemplate restTemplate;

	@GetMapping(value = "/consumeServices")
	public String consumeServices() {
		ServiceInstance instance = loadBalancerClient.choose("eureka-provider");
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/sys/eureka/provider/getServices";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}

}
