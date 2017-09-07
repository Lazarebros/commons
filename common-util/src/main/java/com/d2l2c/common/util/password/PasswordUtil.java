/**
 * 
 */
package com.d2l2c.common.util.password;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * @author dayanlazare
 *
 */
public class PasswordUtil {

	private static final int iterations = 20 * 1000;
	private static final int saltLen = 8;
	private static final int desiredKeyLen = 256;

	private static final String PASS_PHRASE = "@";
	private static final String SECRET_KEY = "PBKDF2WithHmacSHA1";
	private static final String SHA1PRNG = "SHA1PRNG";

	/**
	 * Computes a salted PBKDF2 hash of given plaintext password suitable for
	 * storing in a database. Empty passwords are not supported.
	 */
	public static String getSaltedHash(String password) throws Exception {
		byte[] salt = SecureRandom.getInstance(SHA1PRNG).generateSeed(saltLen);
		// store the salt with the password
		return Base64.getEncoder().encodeToString(salt) + PASS_PHRASE + hash(password, salt);
	}

	/**
	 * Checks whether given plaintext password corresponds to a stored salted
	 * hash of the password.
	 */
	public static boolean check(String password, String stored) throws Exception {
		String[] saltAndPass = stored.split("\\" + PASS_PHRASE);
		if (saltAndPass.length != 2) {
			throw new IllegalStateException("The stored password is malformed!!!");
		}
		String hashOfInput = hash(password, Base64.getDecoder().decode(saltAndPass[0]));
		return hashOfInput.equals(saltAndPass[1]);
	}

	private static String hash(String password, byte[] salt) throws Exception {
		if (password == null || password.length() == 0) {
			throw new IllegalArgumentException("Empty passwords are not supported.");
		}
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY);
		SecretKey key = secretKeyFactory.generateSecret(new PBEKeySpec(password.toCharArray(), salt, iterations, desiredKeyLen));
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}

}
