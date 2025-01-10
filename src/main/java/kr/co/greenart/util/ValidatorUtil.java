package kr.co.greenart.util;

public class ValidatorUtil {
	public static boolean isNullOrEmpty(String str) {
		if (str == null) {
			return true;
		}
		
		if (str.isBlank()) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isPasswordMatch(String password, String passwordCheck) {
		if (password.equals(passwordCheck)) {
			return true;
		}
		
		return false;
	}
}
