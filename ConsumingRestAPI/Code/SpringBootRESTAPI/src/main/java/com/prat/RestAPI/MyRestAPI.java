package com.prat.RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPid;

@SpringBootApplication
public class MyRestAPI
{
	public static void main(String[] args)
	{	
		SpringApplication springApp = new SpringApplication(MyRestAPI.class);
		springApp.run(args);
	}
}
