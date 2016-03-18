package com.epic.springhelloworld.helloworld.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("driver")
public class Driver {

	@Autowired
	private License license;

	
	public void setLicense(License license) {
		this.license = license;
	}

	public License getLicense() {
		return license;
	}

	@Override
	public String toString() {
		return "Driver [license=" + license + "]";
	}
}
