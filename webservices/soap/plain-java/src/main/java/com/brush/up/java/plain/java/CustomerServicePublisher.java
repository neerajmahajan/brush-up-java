package com.brush.up.java.plain.java;

import javax.xml.ws.Endpoint;

public class CustomerServicePublisher {
	public static void main(String[] args) {
		final String url = "http://localhost:9999/customerServ";
		System.out.println("Publishing CustomerService at endpoint " + url);
		Endpoint.publish(url, new CustomerService());
	}
}
