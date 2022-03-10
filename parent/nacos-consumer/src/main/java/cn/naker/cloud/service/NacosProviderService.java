package cn.naker.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Zhang Dingjie
 * @date 2022/3/10
 * @Description
 */
@FeignClient(value = "nacos-provider")
public interface NacosProviderService {

	@GetMapping(value = "/sys/nacos/provider/echoStr/{str}")
	String nacosFeignConsume(@PathVariable String str);

}
