package cn.naker.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhang Dingjie
 * @date 2022/3/11
 * @Description
 */
@FeignClient(value = "nacos-config-provider")
public interface NacosConfigProviderService {


	@GetMapping(value = "/sys/nacos-config/provider/getConfig")
	String getConfigStr();

}
