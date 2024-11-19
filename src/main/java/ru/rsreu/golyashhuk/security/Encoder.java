package ru.rsreu.golyashhuk.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encoder {
	private Encoder() {
	};

	public static String getHash(String data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hash = md.digest(data.getBytes());
		String encodedHash = Base64.getEncoder().encodeToString(hash);

		return encodedHash;
	}
}
