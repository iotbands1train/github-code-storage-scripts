package module04.oop.models;

public class Person {

	private Long id;
	private Name name;
	private Location location;
	private Contact contact;
	private Funds funds;

	public Person() {
		super();
		this.name = new Name();
		this.location = new Location();
		this.contact =  new Contact();
		this.funds =  new Funds();
		this.id = (long) Math.abs( (name + "" + location
				+ "" + contact + "" + funds + "").hashCode() );

	}

	public Person(Long id, Name name, Location location, Contact contact, Funds funds) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.funds = funds;
	}

	public Person(Person p) {
		super();
		this.id = p.getId();
		this.name = p.getName();
		this.location = p.getLocation();
		this.contact = p.getContact();
		this.funds = p.getFunds();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Funds getFunds() {
		return funds;
	}

	public void setFunds(Funds funds) {
		this.funds = funds;
	}
 

	public void display() {
		String print="Person [id=" + id + ", \n" +
	name + ", \n" + location + ", \n" + contact + ",\n"	+ funds + "]";
		System.out.println(print);
	}

	@Override
	public String toString() {
	 return "[ID=" + id + ", Name=" + name.getFname() + ", Phone=" + contact.getPhone() + ", CurrentBalance="+ funds.getCurrentBalance() + "]";
	}
}
