package cn.naker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zhang Dingjie
 * @date 2022/7/7
 * @Description
 */
@SpringBootApplication
public class CanalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanalApplication.class, args);
		System.out.println("------准备启动canal------");
	}

}
