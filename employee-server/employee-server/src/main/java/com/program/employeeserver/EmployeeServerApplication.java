package com.program.employeeserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EmployeeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServerApplication.class, args);
	}

	@GetMapping("/all")
	public List<String> all() {
		return List.of("Java","Py","C++");
	}

}
