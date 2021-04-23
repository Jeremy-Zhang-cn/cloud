package cn.naker.cloud.controller;

import cn.naker.cloud.service.ProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */

@RestController
@RequestMapping(value = "/sys/eureka/hystrixConsumer")
public class HystrixConsumerController {

	@Resource
	private ProviderService providerService;

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/consumeServices")
	public String consumeServices() {
		return providerService.consumeServices();
	}

	public String fallback() {
		return "fallback";
	}

	@GetMapping(value = "fallbackConsume")
	public String fallbackConsume() {
		return providerService.consumeServices();
	}

}
