package Jsons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import Models.Customer;

public class DataProvider {

	public Customer getCustomer() {
		Customer customer = null;
		Gson gson = new Gson();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("./src/test/java/Jsons/Customer.json"));
			customer = gson.fromJson(br, Customer.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return customer;
	}
}