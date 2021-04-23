package cn.naker.cloud.service.impl;

import cn.naker.cloud.service.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author Jeremy
 * @date 2021/4/23
 * @description
 */

@Component
public class ProviderFallback  implements ProviderService {

	@Override
	public String consumeServices() {
		return "fallback";
	}

}
