package module04.oop.models;
 

import module04.oop.randompms.MyRandomPersonData;

public class Funds {
	
	private Long bankID;
	private Float salary;
	private Float currentBalance;
	public Funds() {
		super();
		this.bankID =Math.abs( MyRandomPersonData.random(955_111_111, 956_999_999));
		this.salary = (float) Math.abs( MyRandomPersonData.random(55_000, 175_000));
		this.currentBalance =(float) Math.abs( MyRandomPersonData.random(0_001, 1_244));
	}
	public Funds(Long bankID, Float salary, Float currentBalance) {
		super();
		this.bankID = bankID;
		this.salary = salary;
		this.currentBalance = currentBalance;
	}
	public Long getBankID() {
		return bankID;
	}
	public void setBankID(Long bankID) {
		this.bankID = bankID;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Float getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Float currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String currencies(Float c) {
		String x="";
		x= String.format("$ %.2f", c);
		if(c>999)
		x= String.format("$%,.2f", Float.parseFloat(x)); 
		System.out.println(x);
		return x;
	}
	
	public String showCurrentBalance() {
		String x="";
		x = String.format("$ %.2f", currentBalance);
		if(currentBalance>999) 
			x = String.format("$ %,.2f", currentBalance);
		return x;
	}
	
	private String showSalary() { 
		return String.format("$ %,.2f", salary);
	}
	
	@Override
	public String toString() {
		return " Funds [bankID = (" + bankID + "), salary = (" +showSalary()+ "), currentBalance = (" + showCurrentBalance()   + ") ] ";
	}
	
	

}
