package cn.naker.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhang Dingjie
 * @date 2021/4/23
 * @Description
 */
@FeignClient("eureka-provider")
public interface ProviderService {

	/**
	* @Author Zhang Dingjie
	* @Date 2021/4/23
	* @Param []
	* @return java.lang.String
	* @description 使用feign进行微服务调用, 通过服务名调用
	**/
	@GetMapping("/sys/eureka/provider/getServices")
	String feignConsumeServices();

}
