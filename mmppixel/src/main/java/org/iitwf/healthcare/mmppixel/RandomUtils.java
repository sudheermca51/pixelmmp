package org.iitwf.healthcare.mmppixel;

import java.util.Random;

public class RandomUtils {

	public static String generateRandomString(int n) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		System.out.println("Length of the string" + str.length());

		StringBuilder randomString = new StringBuilder(n);
		int min = 0, max = str.length() - 1;

		for (int i = 0; i < 10; i++) {
			int randomIndex = generateRandomInteger(min, max);
			char ch = str.charAt(randomIndex);
			randomString.append(ch + "");

		}
		System.out.println("Random String::" + randomString);
		return randomString.toString();
	}

	public static int generateRandomInteger(int min, int max) {
		Random rand = new Random();
		// LB+rand.nextInt(UB-LB+1)
		int value = min + rand.nextInt(max - min + 1);
		// System.out.println(value);
		return value;
	}

	public static void main(String[] args) {
		
		System.out.println(generateRandomNumber(2));

		// ASCII Table
		// 65-A to 90-Z
		// 97-a to 122-z

	//	String randomEmail = "AUTQA_" + generateRandomChars(65, 90) + generateRandomChars(97, 122)
	//			+ generateRandomNumber(100, 200) + "@gmail.com";
//		
	//	System.out.println(randomEmail);
//		 

//		Random rand = new Random();
//		int i = rand.nextInt(1000);//0 inclusive , bound exclusive- 0 to 999
//		System.out.println(i);
//	 
//		 int lBound=65;
//		 int uBound=90;
//		 
//
//		 int j = lBound+rand.nextInt(uBound-lBound);
//		 char ch =(char) j;
//		 System.out.println("Character:::"+ ch);
//	 
	}

	/*
	 * public static int generateRandomNumber(int bound) { Random rand = new
	 * Random(); int i = rand.nextInt(bound);//0 inclusive , bound exclusive
	 * System.out.println(i); return i ; }
	 */

	public static String generateRandomNumber(int n) {
		StringBuilder randomChar = new StringBuilder(n);
		int min = 0, max = 9;
		for (int i = 0; i < n; i++) {
			int randomIndex = generateRandomInteger(min, max);
			randomChar.append(randomIndex);
		}
		return randomChar.toString();
	}

	public static int generateRandomNumber(int lBound, int uBound) {
		Random rand = new Random();
		// LB+rand.nextInt(UB-LB)
		int i = lBound + rand.nextInt(uBound - lBound);
		System.out.println(i);
		return i;
	}

	public static char generateRandomChars(int lBound, int uBound) {
		Random rand = new Random();
		// LB+rand.nextInt(UB-LB)
		int i = lBound + rand.nextInt(uBound - lBound);
		char ch = (char) i;
		System.out.println(ch);
		return ch;
	}
	public static String generateRandomPwd(int n) {
		String strUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder randomPwd = new StringBuilder(n);
		int min = 0, max = strUpperCase.length() - 1;
		int randomIndex = generateRandomInteger(min, max);
		char ch = strUpperCase.charAt(randomIndex);
		randomPwd.append(ch + generateRandomString(n - 4) + generateRandomSpecialChar(2)
				+ generateRandomInteger(10, 99));
		return randomPwd.toString();
	}

	public static String generateRandomSpecialChar(int n) {
		String specialChar = "!@#$%^&*+_-";
		StringBuilder randomChar = new StringBuilder(n);
		int min = 0, max = specialChar.length() - 1;
		for (int i = 0; i < n; i++) {
			int randomIndex = generateRandomInteger(min, max);
			char ch = specialChar.charAt(randomIndex);
			randomChar.append(ch + "");
		}
		return randomChar.toString();
	}
	public static String generateRandomEmailID() {
		String randomEmailID = RandomUtils.generateRandomString(7) + RandomUtils.generateRandomNumber(2)
				+ "@gmail.com";
		return randomEmailID;
	}

}
