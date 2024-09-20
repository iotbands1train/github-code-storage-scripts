package module04.oop.models;
 
import module04.oop.randompms.MyRandomPersonData;

public class Contact {
	
	private Long phone;

	public Contact() {
		super();
		this.phone = Math.abs( MyRandomPersonData.random(214_111_1111L, 214_999_9999L));
	}

	public Contact(Long phone) {
		super();
		this.phone = phone;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return " Contact [phone=" + phone + "]";
	}
	
	

}
