package com.trello.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	@BeforeSuite
	public void beforesuite() {
		 System.out.println("before suite is executing"); 
	  }
	@BeforeTest
	public void beforetest() {
		 System.out.println("before test is executing"); 
	  }
	@BeforeClass
	public void beforeclass() {
		 System.out.println("before class is executing"); 
	  }
	@BeforeMethod
	public void beforemethod() {
		 System.out.println("before method is executing"); 
	  }
	@Test
	  public void test() {
		 System.out.println("method is executing"); 
	  }
	@AfterTest
	public void aftertest() {
		 System.out.println("after test is executing"); 
	  }
	@AfterClass
	public void afterclass() {
		 System.out.println("after class is executing"); 
	  }
	@AfterSuite
	public void aftersuite() {
		 System.out.println("after suite is executing"); 
	  }
	@AfterMethod
	public void aftermethod() {
		 System.out.println("after method is executing"); 
	  }
}
