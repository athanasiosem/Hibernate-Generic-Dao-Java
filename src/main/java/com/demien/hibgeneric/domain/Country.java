package com.demien.hibgeneric.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity(name = "COUNTRIES")
public class Country implements Serializable {

	private static final long serialVersionUID = 7566184847780781908L;
	
	@Id
	@Column(name = "COUNTRY_ID")
	private String countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REGION_ID")
	private Region region;

	public Country() {
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {

		return "[COUNTRY_ID=" + getCountryId().toString() + " COUNTRY_NAME="
				+ getCountryName() + " REGION=" + region.toString() + "]";
		// return "["+getCountryId()+"] "+getCountryName();
	}

}