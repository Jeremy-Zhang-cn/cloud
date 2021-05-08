package cn.naker.cloud.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang Dingjie
 * @date 2021/5/8
 * @Description
 */

@RestController
@RequestMapping(value = "/sys/security/")
public class SecurityController {

	@GetMapping(value = "/getSecurity")
	public String getSecurity() {
		return "security";
	}

}
