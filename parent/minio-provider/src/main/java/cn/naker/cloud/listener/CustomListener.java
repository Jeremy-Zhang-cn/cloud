package cn.naker.cloud.listener;


import cn.naker.cloud.util.MinioUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Zhang Dingjie
 * @date 2021/6/24
 * @Description 自定义SpringApplication中的监听器，
 * 在上下文刷新后，SpringApplication.run()方法执行完成之前执行，进行某些参数的初始化
 */
public class CustomListener implements ApplicationListener<ApplicationReadyEvent> {


	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		System.out.println("------------------环境准备完毕，监听器被调用------------------");
		MinioUtils.init();
	}


}
