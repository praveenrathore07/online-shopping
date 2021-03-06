package net.kzn.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="addresss_line_one")
	private String addresssLineOne;
	@Column(name="addresss_line_two")
	private String addresssLineTwo;
	private String city;
	private String state;
	private String country;
	@Column(name="postal_code")
	private String postalCode;
	private boolean shipping;
	private boolean billing;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddresssLineOne() {
		return addresssLineOne;
	}
	public void setAddresssLineOne(String addresssLineOne) {
		this.addresssLineOne = addresssLineOne;
	}
	public String getAddresssLineTwo() {
		return addresssLineTwo;
	}
	public void setAddresssLineTwo(String addresssLineTwo) {
		this.addresssLineTwo = addresssLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", addresssLineOne=" + addresssLineOne
				+ ", addresssLineTwo=" + addresssLineTwo + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
}
