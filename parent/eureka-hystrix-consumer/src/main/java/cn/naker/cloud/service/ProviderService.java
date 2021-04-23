package cn.naker.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */
@FeignClient(value = "eureka-provider")
public interface ProviderService {

	@GetMapping(value = "/sys/eureka/provider/getServices")
	String consumeServices();

}
