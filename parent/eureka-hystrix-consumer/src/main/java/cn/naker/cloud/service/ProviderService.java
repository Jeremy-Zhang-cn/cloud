package cn.naker.cloud.service;

import cn.naker.cloud.service.impl.ProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */
@FeignClient(value = "eureka-provider", fallback = ProviderFallback.class)
public interface ProviderService {

	@GetMapping(value = "/sys/eureka/provider/getServices")
	String consumeServices();

}
