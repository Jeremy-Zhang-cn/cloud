package cn.naker.cloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2021/4/17
 * @Description
 */

@RestController
@RequestMapping(value = "/sys/consul/provider")
public class ProviderController {

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping(value = "/getServices")
	public String getServices() {
		String services = "services:" + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}

}
