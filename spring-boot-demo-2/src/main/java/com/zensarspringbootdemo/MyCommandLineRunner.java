package com.zensarspringbootdemo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)

public class MyCommandLineRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		System.out.println("MyCommandLineRunner " + Arrays.toString(args));

	}
}
