package cn.naker.cloud.controller;

import cn.naker.cloud.service.RabbitMQService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zhang Dingjie
 * @date 2022/9/14
 * @Description
 */
@RestController
@RequestMapping(value = "/sys/rabbitmq/provider")
public class RabbitMQProviderController {

	@Resource
	private RabbitMQService rabbitMQService;

	@GetMapping(value = "/sendMsg")
	public String sendMsg(@RequestParam(name = "msg") String msg) {
		return rabbitMQService.sendMsg(msg);
	}

	@GetMapping(value = "/sendFanoutMsg")
	public String sendFanoutMsg(@RequestParam(name = "msg") String msg) {
		return rabbitMQService.sendMsgByFanout(msg);
	}

	@GetMapping(value = "/sendTopicMsg")
	public String sendTopicMsg(@RequestParam(name = "msg") String msg,
							   @RequestParam(name = "routingKey") String routingKey) {
		return rabbitMQService.sendMsgByTopic(msg, routingKey);
	}

}
