package cn.naker.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */

@RestController
@RequestMapping(value = "/sys/eureka/ribbonConsumer")
public class RibbonConsumerController {

	@Resource
	private RestTemplate restTemplate;

	/**
	* @Author Zhang Dingjie
	* @Date 2021/4/23
	* @Param []
	* @return java.lang.String
	* @description 调用服务提供者的服务, 由于restTemplate使用的负载均衡注解，
	 * 				只可通过服务名(eureka-provider)的方式调用，不能再通过ip地址(127.0.0.1)的方式调用微服务
	**/
	@GetMapping(value = "/consumeServices")
	public String consumeServices() {
		return restTemplate.getForObject("http://eureka-provider/sys/eureka/provider/getServices", String.class);
	}

}
