package in.dibya.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class PwdUtils {
	
    // static taken using class name i can call this method from userserviceimpl
	public static String generateRandomPwd() {
		
	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	String pwd = RandomStringUtils.random( 6, characters );
	System.out.println( pwd );
	return pwd;
	}
}
