package cn.naker.cloud.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2022/3/25
 * @Description
 */
@RestController
@RequestMapping(value = "/sys/rocketmq/producer")
public class ProducerController {

	@Resource
	private RocketMQTemplate rocketMQTemplate;

	@GetMapping(value = "/produce")
	public void produce() {
		rocketMQTemplate.convertAndSend("first-topic", "你好，旅行者！");
	}

}
