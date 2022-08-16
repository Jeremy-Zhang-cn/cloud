package cn.naker.cloud;

import cn.naker.cloud.client.CanalClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhang Dingjie
 * @date 2022/8/16
 * @Description run方法只会在容器启动时执行一次，并且如果实现了CommandLineRunner接口的bean执行run方法出错 容器会停掉 @Order注解指定执行顺序
 */
@Component
@Order(value = 1)
public class CanalRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 1000,
				TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		threadPool.execute(new CanalClient());
	}

}
