package br.com.rvz.hrpayroll.entities;

public class Payment {

	private String name;
	private Double dailyincome;
	private Integer days;

	public Payment() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyincome() {
		return dailyincome;
	}

	public void setDailyincome(Double dailyincome) {
		this.dailyincome = dailyincome;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	public double getTotal() {
		return 	this.days * this.dailyincome;
	}
}
