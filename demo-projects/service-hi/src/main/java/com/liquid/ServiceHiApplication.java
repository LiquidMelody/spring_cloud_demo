package com.liquid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	
	@Value("${family}")
	String family;
	
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Welcome Home ");
		buffer.append(name);
		buffer.append(", ");
		buffer.append(family);
		buffer.append(" is in. ");
		buffer.append("Home position is at port ");
		buffer.append(port);
		buffer.append(".");
		return buffer.toString();
	}

}
