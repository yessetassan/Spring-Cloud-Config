package com.program.employeeclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RequestMapping
public class EmployeeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeClientApplication.class, args);
	}

	@Value("${emp.service.url}")
	private String url;
	@Value("${emp.client.msg}")
	private String msg;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping
	public List all() {
		return restTemplate().getForObject(
				url,
				List.class
		);
	}

	@GetMapping("/msg")
	public String msg() {
		return msg;
	}

}
