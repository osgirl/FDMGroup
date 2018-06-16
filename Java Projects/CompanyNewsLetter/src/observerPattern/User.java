package observerPattern;

public class User implements Observer{
	public String firstname;
	public String lastname;
	
	public User(String fname, String lname){
		super();
		this.firstname = fname;
		this.lastname = lname;
	}
	
	public void notification(){
		System.out.println("Welcome back, you've got updates!");
	}
}
