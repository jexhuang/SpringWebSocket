package com.jexhuang.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jexhuang.model.Greeting;
import com.jexhuang.model.HelloMessage;

@Controller
public class IndexController {

	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage helloMessage) throws Exception{
		Thread.sleep(1000);
		return new Greeting("Hello ," + helloMessage.getName());
	}
}
