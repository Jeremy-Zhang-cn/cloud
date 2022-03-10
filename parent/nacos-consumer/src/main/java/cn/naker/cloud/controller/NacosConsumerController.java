package cn.naker.cloud.controller;

import cn.naker.cloud.service.NacosProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2022/3/10
 * @Description
 */
@RestController
@RequestMapping(value = "/sys/nacos/consumer")
public class NacosConsumerController {

	@Resource
	NacosProviderService nacosProviderService;

	@GetMapping(value = "/consume/{str}")
	public String consume(@PathVariable String str) {
		return nacosProviderService.nacosFeignConsume(str);
	}

}
