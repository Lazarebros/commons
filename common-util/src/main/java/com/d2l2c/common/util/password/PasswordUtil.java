/**
 * 
 */
package com.d2l2c.common.util.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dayanlazare
 *
 */
public class PasswordUtil {

	public static String encode(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
	}
	
//	public static void main(String[] args) {
//		String password = "";
//		System.out.println(encode(password));
//	}

}
