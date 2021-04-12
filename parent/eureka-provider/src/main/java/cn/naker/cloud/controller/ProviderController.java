package cn.naker.cloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jeremy
 * @date 2021/4/10
 * @description
 */

@RestController
@RequestMapping(value = "/sys/eureka/provider")
public class ProviderController {

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping(value = "/getServices")
	public String getServices() {
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}

}
