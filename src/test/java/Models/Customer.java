package Models;

public class Customer {
	
	private String Name;
	private String LastName;
	private String ContactFirstName;
	private String Phone;
	private String AddressLine1;
	private String AddressLine2;
	private String City;
	private String State;
	private String PostalCode;
	private String Country;
	private String FromEmployeer;
	private String CreditLimit;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getContactFirstName() {
		return ContactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		ContactFirstName = contactFirstName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getFromEmployeer() {
		return FromEmployeer;
	}
	public void setFromEmployeer(String fromEmployeer) {
		FromEmployeer = fromEmployeer;
	}
	public String getCreditLimit() {
		return CreditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		CreditLimit = creditLimit;
	}
}