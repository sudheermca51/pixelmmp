package org.iitwf.healthcare.mmppixel;
import java.util.Random;

public class NewRandomUtils {

		public int generateRandomInteger(int min,int max)
		{
			Random rand = new Random();
			//LB+rand.nextInt(UB-LB+1)
			int value = min+rand.nextInt(max-min+1);
		//	System.out.println(value);
			return value;
		}

		public String generateRandomString(int n)
		{
			String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			//System.out.println("Length of the string"+ str.length());
			 
			StringBuilder randomString=new StringBuilder(n);
			int min=0,max=str.length()-1;
		 
			for(int i=0;i<10;i++)
			{
				int randomIndex= generateRandomInteger(min,max);
				char ch = str.charAt(randomIndex);
				randomString.append(ch+"");
				
			}
		//	System.out.println("Random String::" + randomString);
			return randomString.toString();
		}
		public static int generateRandom9DigitNumber() {
		    Random rand = new Random();
		   return 100000000 + rand.nextInt(900000000);  // Ensures an 9-digit number 
		}
		public int generateRandom8DigitNumber() {
		    Random rand = new Random();
		   return 10000000 + rand.nextInt(90000000);
		 //  System.out.println(value1);
		   // Ensures an 8-digit number (10000000 to 99999999)
		}
		public void main(String[] args) {
			
			 String randomEmailID="AUT_"+generateRandomString(5)+generateRandomInteger(50,100)+"@gmail.com";
		//	 System.out.println(randomEmailID);
			 int value1=generateRandom8DigitNumber();
			 System.out.println(value1);
			 
		}
	}


