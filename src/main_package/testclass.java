package main_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class testclass {
  @Test
  public void f() {
	  DateFormat dateFormat = new SimpleDateFormat("yymmddHHmmss");
	  Date date = new Date();
	  System.out.println(dateFormat.format(date));
	  
  }
}
