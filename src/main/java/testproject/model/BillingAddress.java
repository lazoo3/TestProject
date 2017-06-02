package testproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billing_address")
public class BillingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billing_id")
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="street_name")
	private String streetName;
	
	@Column(name="street_number")
	private String streetNumber;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="country_id")
	private int countryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	
}
