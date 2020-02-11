package UserPassword;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Authenticator {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Which action do you want to perform:"
				+ "1. Add User"
				+ "2. Remove User"
				+ "3. Sign In");
		
		String action = input.nextLine();
		
		if (action == "1") {
			addUser();
		}
		
		else if (action == "2") {
			removeUser();
		}
		
		else if (action == "3") {
			signIn();
		}
		
		else {
			System.exit(0);
		}
		input.close();
	}
	
	@SuppressWarnings({ "null", "resource" })
	public static boolean signIn() {
		Scanner keyboard = new Scanner(System.in);
		boolean valid = false;
		String password;
		String username;
		String[] SpecialCharacters = {"$", "!", "#", "%"};
		System.out.print("Enter a Username: ");
		username = keyboard.nextLine();
		System.out.print("Your username is: " + username);
		
		System.out.print("Enter a password: ");
		password = keyboard.nextLine();
		
		for (int i = 0; i < password.length(); i++) {
			if(password.length() < 8 && password.length() > 16) {
				valid = false;
				System.out.print("Password needs to be 8 to 16 characters long");
			}
			else {
				valid = true;
			}
			
			if(password != password.toUpperCase()) {
				valid = false;
				System.out.print("Password needs to include an uppercase character");
			}
			
			if(password != password.toLowerCase()) {
				valid = false;
				System.out.print("Password needs to include a lowercase character");
			}
			else {
				valid = true;
			}
		}
		
		for (int j = 0; j < SpecialCharacters.length; j++) {
			String[] commonPass = null;
			if(password.equalsIgnoreCase(commonPass[j])) {
				valid = false;
				System.out.print("Password needs a special character");
			}
		}
		return valid;
	}
	
	public static void arrayList() {
		ArrayList <String> credentials = new ArrayList<String>();
		
		credentials.add(0, "M0797063@");
		credentials.add(1, "Matt0515&");
		credentials.add(2, "Jon0064$");
		credentials.add(3, "Jon1999*");
	}
	
	@SuppressWarnings({ "null", "resource" })
	public static String addUser() throws Exception {
		@SuppressWarnings("resource")
		ArrayList <String> credentials = null;
		Scanner user = new Scanner(System.in);
		
		System.out.print("Enter a Username: ");
		String username = user.nextLine();
		System.out.print("Your username is: " + username);
		
		System.out.print("Enter a password: ");
		String password = user.nextLine();
		System.out.print("Your password is: " + password);
		
		credentials.add(username);
		credentials.add(password);
		
		return hash(password, null);
	}
	
	@SuppressWarnings("null")
	public static void removeUser() {
		ArrayList <String> credentials = null;
		
		Object username = null;
		credentials.remove(username);
	}
	
	private static String hash(String password) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        return password;
    }
	
	@SuppressWarnings("null")
	public static String salt() {
		{

	        MessageDigest md;
	        try
	        {
	            // Select the message digest for the hash computation -> SHA-256
	            md = MessageDigest.getInstance("SHA-256");

	            // Generate the random salt
	            SecureRandom random = new SecureRandom();
	            byte[] salt = new byte[16];
	            random.nextBytes(salt);

	            // Passing the salt to the digest for the computation
	            md.update(salt);

	            String password = null;
				// Generate the salted hash
	            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashedPassword)
	                sb.append(String.format("%02x", b));

	            System.out.println(sb);
	        } catch (NoSuchAlgorithmException e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	}
		return salt();

	
}
}
