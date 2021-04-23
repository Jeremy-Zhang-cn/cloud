package cn.naker.cloud.controller;

import cn.naker.cloud.service.ProviderService;
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
@RequestMapping(value = "/sys/eureka/feignConsumer")
public class FeignConsumerController {

	@Resource
	private ProviderService providerService;

	/**
	* @Author Zhang Dingjie
	* @Date 2021/4/23
	* @Param []
	* @return java.lang.String
	* @description 利用feign通过接口调用微服务
	**/
	@GetMapping(value = "/consumeServices")
	public String consumeServices() {
		return providerService.feignConsumeServices();
	}


}
