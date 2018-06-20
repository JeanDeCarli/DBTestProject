package Jsons;

import com.google.gson.Gson;
import Models.Customer;

public class DataProvider {
	
	public Customer getCustomer() {
		Customer customer = new Gson().fromJson(json, Customer.class);
	}
}