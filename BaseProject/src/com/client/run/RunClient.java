package com.client.run;

import com.client.Client;

public class RunClient {
	public static void main(String[] args) {
		System.out.println("".length());
		Client client = new Client();
		client.splashScreen();
		client.mainMenu();
	}
	
}
