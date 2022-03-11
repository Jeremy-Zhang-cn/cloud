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
// @RefreshScope注解会实时更新value（需要getter/setter） P.S. 不可以加到Controller上
@Component
@RefreshScope
@Data
public class NacosConfig {

	@Value("${configStr}")
	private String configStr;

}
