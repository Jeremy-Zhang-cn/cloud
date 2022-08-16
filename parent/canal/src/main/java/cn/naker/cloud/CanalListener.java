package cn.naker.cloud;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Zhang Dingjie
 * @date 2022/8/16
 * @Description 容器启动完毕 准备就绪之后的监听事件
 *              相较于ApplicationStartedEvent事件多执行了一步CommandLineRunner
 */
@Component
public class CanalListener implements ApplicationListener<ApplicationReadyEvent> {


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		ConfigurableApplicationContext context = event.getApplicationContext();
		System.out.println("application ready");
		System.out.println("active state" + context.isActive());
	}

}
