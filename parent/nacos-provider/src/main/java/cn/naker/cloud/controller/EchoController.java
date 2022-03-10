package cn.naker.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang Dingjie
 * @date 2022/3/10
 * @Description
 */
@RestController
@RequestMapping(value = "/sys/nacos/provider")
public class EchoController {

	@GetMapping(value = "/echoStr/{str}")
	public String echo(@PathVariable String str) {
		return "Nacos Provider accessed: " + str;
	}

}
