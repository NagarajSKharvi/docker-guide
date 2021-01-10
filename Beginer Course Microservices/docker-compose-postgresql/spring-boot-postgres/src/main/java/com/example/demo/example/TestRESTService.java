package com.example.demo.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestRESTService {
	
	protected String logPrefix  = "{} : {}";
	
	@GetMapping("/db")
	public String connectDB() throws UnknownHostException, InterruptedException {
		log.debug(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		String ipAddr = InetAddress.getLocalHost().getHostName();
		System.out.println("Printing IP address of the host " + ipAddr);
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}
		Thread.sleep(10000);
		boolean connected = false;
		while (!connected) {
			try {
				// Note the way the postgres container is used here. (db - database host/service name)
				String url = "jdbc:postgresql://web:5432/test?autoReconnect=false&useSSL=false";
				String user = "postgres";
				String password = "123";
				System.out.println("Connecting to URL " + url);
				// Load the Connector/J driver
				Class.forName("org.postgresql.Driver").newInstance();
				// Establish connection to PostgreSQL
				Connection conn = DriverManager.getConnection(url, user, password);
				if (conn != null) {
					System.out.println("Connection was successful");
					connected = true;
				}
			} catch (Exception e) {
				System.err.println("Error connecting to database");
				e.printStackTrace();
				Thread.sleep(5000);
			}
		}
		return "REST Call Ping, Database connection : " + connected;
	}
	
	@GetMapping("/rest")
	public String rest() throws UnknownHostException, InterruptedException {
		log.debug(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		String ipAddr = InetAddress.getLocalHost().getHostName();
		System.out.println("Printing IP address of the host " + ipAddr);
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}
		return "REST Call Ping";
	}
}