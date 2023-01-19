package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Auto discovery (container)
//@ComponentScan("com")
public class BootCorev1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(BootCorev1Application.class, args);
	}

}
