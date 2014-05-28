package com.demien.hibgeneric.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "REGIONS")
public class Region implements Serializable {

	private static final long serialVersionUID = 8268800253932817168L;
	@Id
	@Column(name = "REGION_ID")
	private Integer regionId;
	@Column(name = "REGION_NAME")
	private String regionName;

	public Region() {
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "[REGION_ID=" + getRegionId().toString() + " REGION_NAME="
				+ getRegionName() + "]";
		// return "["+getRegionId().toString()+"] "+getRegionName();
	}

}
