package module04.oop.models;

import module04.oop.randompms.MyRandomPersonData;

public class Name {
	
	private String title;
	private String fname;
	private String mi;
	private String lname; 
	public Name() {
		super();
		this.title = MyRandomPersonData.randomTitle();
		this.fname = MyRandomPersonData.randomFname();
		this.mi = MyRandomPersonData.randomFname();
		this.lname = MyRandomPersonData.randomLname(); 
	}
	public Name(String title, String fname, String mi, String lname, String other) {
		super();
		this.title = title;
		this.fname = fname;
		this.mi = mi;
		this.lname = lname; 
	} 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMi() {
		return mi;
	}
	public void setMi(String mi) {
		this.mi = mi;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	} 
	@Override
	public String toString() {
		return " Name [title=" + title + ", fname=" + fname + ", mi=" + mi + ", lname=" + lname  + "]";
	}
	
	

}
