package com.suresh.learning.testng.test;

import com.suresh.learning.testng.lib.ReadExcelLib;
import org.testng.annotations.DataProvider;



public class DataProviderTest {
 

  @DataProvider
  public Object[][] dataProvider1() {
	  
	  ReadExcelLib excel = new ReadExcelLib();
	  String file = "C:/Users/sures/IdeaProjects/TestNG_Tutorial/TestData/TestData.xlsx";
	  return excel.Get_Excel_Data(file, "Sheet1", 3);
   
  }
  
  
}
