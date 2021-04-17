package cn.naker.cloud.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2021/4/17
 * @Description
 */

@RestController
@RequestMapping(value = "/sys/consul/consumer")
public class ConsumerController {

	@Resource
	private LoadBalancerClient loadBalancerClient;
	@Resource
	private RestTemplate restTemplate;

	@GetMapping(value = "consumeServices")
	public String consumeServices() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("consul-provider");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/sys/consul/provider/getServices";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}

}
