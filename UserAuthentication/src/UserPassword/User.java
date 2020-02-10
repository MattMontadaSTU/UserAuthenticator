package UserPassword;

public class User {
	String username;
	String passwordHash;
	String salt;
	String userID;
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public void setPasswordHash(String newHash) {
		this.passwordHash = newHash;
	}
	
	public void setSalt(String newSalt) {
		this.salt = newSalt;
	}
	
	public void setID (String newID) {
		this.userID = newID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return passwordHash;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public String getID() {
		return userID;
	}
}
