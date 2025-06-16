package org.iitwf.healthcare.mmppixel;

import java.util.Random;

public class RandomUtils {
	
	public static String generateRandomString(int n)
	{
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		System.out.println("Length of the string"+ str.length());
		 
		StringBuilder randomString=new StringBuilder(n);
		int min=0,max=str.length()-1;
	 
		for(int i=0;i<10;i++)
		{
			int randomIndex= generateRandomInteger(min,max);
			char ch = str.charAt(randomIndex);
			randomString.append(ch+"");
			
		}
		System.out.println("Random String::" + randomString);
		return randomString.toString();
	}
	public static int generateRandomInteger(int min,int max)
	{
		Random rand = new Random();
		//LB+rand.nextInt(UB-LB+1)
		int value = min+rand.nextInt(max-min+1);
		//System.out.println(value);
		return value;
	}
	
	 public static int generateRandomEightDigitNumber() {
	        Random random = new Random();
	        int lowerBound = 10000000;
	        int range = 90000000; // 99999999 - 10000000 + 1 = 90000000
	        return lowerBound + random.nextInt(range);
	    }
	
	public static void main(String[] args) {

		//ASCII Table
		//65-A to  90-Z
		//97-a to 122-z
		
 String randomEmail = "AUTQA_"+generateRandomChars(65,90)+generateRandomChars(97,122)+generateRandomNumber(100,200)+"@gmail.com";
//		
 System.out.println(randomEmail);
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

	public static int generateRandomNumber(int bound)
	{
		Random rand = new Random();
		int i = rand.nextInt(bound);//0 inclusive , bound exclusive
		System.out.println(i);
		return i ;
	}
	public static int generateRandomNumber(int lBound,int uBound)
	{
		Random rand = new Random();
		//LB+rand.nextInt(UB-LB)
		int i = lBound + rand.nextInt(uBound-lBound);
		System.out.println(i);
		return i;
	}
	public static char generateRandomChars(int lBound,int uBound)
	{
		Random rand = new Random();
		//LB+rand.nextInt(UB-LB)
		int i = lBound + rand.nextInt(uBound-lBound);
		char ch = (char) i ;
		System.out.println(ch);
		return ch;
	}
}
