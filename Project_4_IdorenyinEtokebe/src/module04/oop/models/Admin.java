package module04.oop.models;

import module04.oop.randompms.MyRandomAdminData;

public class Admin {

    private Long id;
    private String user;
    private String pass;

    public Admin(Long id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public Admin(Admin admin) {
        this.id = admin.getId();
        this.user = admin.getUser();
        this.pass = admin.getPass();
    }

    public Admin() {
        Admin generatedAdmin = MyRandomAdminData.generateRandomAdmin();
        this.id = generatedAdmin.getId();
        this.user = generatedAdmin.getUser();
        this.pass = generatedAdmin.getPass();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", user=" + user + ", pass=" + pass + "]";
	}
    
    
}