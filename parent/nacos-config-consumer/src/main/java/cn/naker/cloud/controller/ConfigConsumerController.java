package cn.naker.cloud.controller;

import cn.naker.cloud.config.NacosConsumerConfig;
import cn.naker.cloud.service.NacosConfigProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2022/3/11
 * @Description nacos配置中心
 */
@RestController
@RequestMapping(value = "/sys/nacos-config/consumer")
public class ConfigConsumerController {

	@Resource
	private NacosConfigProviderService nacosConfigProviderService;
	@Resource
	private NacosConsumerConfig config;

	@GetMapping(value = "/consumeConfig")
	public String consumeConfig() {
		System.out.println(nacosConfigProviderService.getConfigStr());
		return "get nacos consumer config(real time): ---->" + config.getConfigStr();
	}

}
