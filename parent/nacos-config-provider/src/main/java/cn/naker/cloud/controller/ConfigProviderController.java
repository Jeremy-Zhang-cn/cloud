package cn.naker.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang Dingjie
 * @date 2022/3/11
 * @Description
 */
@RestController
@RequestMapping(value = "/sys/nacos-config/provider")
public class ConfigProviderController {

	@Value("${configStr}")
	private String configStr;


	@GetMapping(value = "/getConfig")
	public String getConfig() {
		return "get nacos provider config: ---> " + configStr;
	}


}
