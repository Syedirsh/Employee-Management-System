package com.example.irshad.irshad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// System.out.println("Hello Wold");
		System.out.println(mycontroller.mymethod());
		SpringApplication.run(DemoApplication.class, args);
	}

}
