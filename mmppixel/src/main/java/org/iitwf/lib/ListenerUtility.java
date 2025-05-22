package org.iitwf.lib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtility implements ITestListener{
	
	Long startTime,endTime,totalTime;
	public void onTestStart(ITestResult result) {
	    
		System.out.println("##################### Started the Test Case Execution:::: "+ result.getName()+"##################################");
		System.out.println("##################### Start Time:::: "+ result.getStartMillis()+"##################################");
		startTime= result.getStartMillis();
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("##################### Ending the Test Case Execution:::: "+ result.getName()+"##################################");
		System.out.println("##################### End Time:::: "+ result.getEndMillis()+"##################################");
		endTime=   result.getEndMillis();
		totalTime = endTime-startTime;
		System.out.println("##################### Total time in execution is:::: "+ result.getEndMillis()+"##################################");
	  }
	public void onTestFailed(ITestResult result) {
		System.out.println("##################### Ending the Test Case Execution:::: "+ result.getName()+"##################################");
		System.out.println("##################### End Time:::: "+ result.getEndMillis()+"##################################");
		endTime=   result.getEndMillis();
		totalTime = endTime-startTime;
		System.out.println("##################### Total time in execution is:::: "+ result.getEndMillis()+"##################################");
	  }
	public void onTestSkipped(ITestResult result) {
		System.out.println("##################### Ending the Test Case Execution:::: "+ result.getName()+"##################################");
		System.out.println("##################### End Time:::: "+ result.getEndMillis()+"##################################");
		endTime=   result.getEndMillis();
		totalTime = endTime-startTime;
		System.out.println("##################### Total time in execution is:::: "+ result.getEndMillis()+"##################################");
	  }

}





/*
interface I1
{
	default void a1() {
		
	}
	

}
class A implements I1{

	 public void a2()
	 {
		 System.out.println("");
	 }
	
}
*/