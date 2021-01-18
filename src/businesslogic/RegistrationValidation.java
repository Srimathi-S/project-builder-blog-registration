package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation
{
	public boolean checkUserDetails(String email, String password, String confirmPassword)
	{
		
			return ( validPassword(password,confirmPassword) && validEmail(email));
	}
	
	
	private boolean validPassword(String password, String confirmPassword)
	{

		//Checks if password is not null
		try
		{
		int length=password.length();
		//Checks if Password and confirm Password are equal
		boolean samePassword=password.equals(confirmPassword);
		
		//Checks if string is of rewquired length
		boolean requiredLength=(length>=8 && length<=20);
		
		//Checks if it contains lowercase letters
		String regex=".*[a-z].*";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(password);
		boolean containsLowerCase= matcher.matches();
		
		
		//Check if the string contain upper case letter
		regex=".*[A-Z].*";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(password);
		boolean containsUpperCase= matcher.matches();
		
		return ( samePassword && requiredLength && containsLowerCase && containsUpperCase);
		}
		catch(NullPointerException ex)
		{
			return false;
		}
		
	}
	
	
	private boolean validEmail(String email)
	{
		//Checks if email is not null
		if(email.equals(""))
			return false;
		
		
		//Checks if email is AlphaNumeric
		String regex="^[a-zA-Z0-9_.@]+$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(email);
		boolean isAlphaNumeric= matcher.matches();
		
		//Checks if email contains @
		regex=".*[@].*";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(email);
		boolean ContainsAt= matcher.matches();
		
		//Check if email contains .
		regex=".*[.].*";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(email);
		boolean ContainsDot= matcher.matches();
		
		return (isAlphaNumeric&& ContainsAt&& ContainsDot);
	}
}