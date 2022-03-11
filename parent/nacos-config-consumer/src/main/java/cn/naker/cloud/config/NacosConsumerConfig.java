package cn.naker.cloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author Zhang Dingjie
 * @date 2022/3/11
 * @Description
 */
@Component
@RefreshScope
@Data
public class NacosConsumerConfig {

	@Value("${configStr}")
	private String configStr;

}
