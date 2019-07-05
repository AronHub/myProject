package com.fjt.util;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyJobA {
	public void work() {
		System.out.println("date: " + new Date().getTime());
	}

}
