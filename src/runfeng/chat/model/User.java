package runfeng.chat.model;

public class User {
	private int id;
	private String username;
	private String password;
	private int age;
	
	public User(){
		
	}
	
	public User(String username, String password, int age) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.setAge(age);
	}
	
	public boolean validPassword(String password) {
		return (this.password.equals(password));
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
