package com.suresh.learning.testng.test;

import org.testng.annotations.*;

import static org.testng.Assert.fail;

public class DemoTest extends DataProviderTest{
    @BeforeMethod
    public void beforeMethod() {
        //System.out.println("beforeMethod");
    }
    @BeforeClass
    public void beforeClass() {
        //System.out.println("beforeClass");
    }
    @AfterMethod
    public void afterMethod() {
        //System.out.println("afterMethod");
    }
    @AfterClass
    public void afterClass() {
       // System.out.println("afterClass");
    }
    @BeforeTest
    public void beforeTest() {
        //System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest() {
        //System.out.println("afterTest");
            }

     @BeforeSuite
     public void beforeSuite() {
        //System.out.println("beforeSuite");
     }

     @AfterSuite
     public void afterSuite() {
        //System.out.println("afterSuite");
     }
    @Test(dependsOnMethods = {"Test2","Test4"}, alwaysRun = true)
    public void Test1(){
    System.out.println("Test1");
    }
    @Test
    public void Test2(){
        System.out.println("Test2");
    }
    @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderTest.class)
    public void test3(String p1, String p2, String p3) {
        System.out.println("Test3");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("--------------");
    }

    @Test
    public void Test4(){
        System.out.println("Test4");
        fail("test 4 failed purposely");
    }
    @Test @Ignore
    public void Test5(){
        System.out.println("Test5");
    }
}
