package com.epic.ib.bean.loancalculator;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:9:20:48 AM
 * @Class :LoanCalculatorInputBean.java
 **/
public class LoanCalculatorInputBean {
	double amount;
	int duration;
	double interestRate;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
