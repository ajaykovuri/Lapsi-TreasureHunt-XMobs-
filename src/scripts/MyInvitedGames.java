package scripts;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;
import io.selendroid.SelendroidLauncher;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import testUtils.Helper;


//changes2 

public class MyInvitedGames extends Helper{
  @Test
  public void CurrentGames() throws Exception {
		 /* ------ Current
		 Games-----------------------------------------------------------------
		 */
		 driver.findElement(By.linkText("Current Games")).click();
		 List<WebElement> currentgames =
		 driver.findElements(By.id("tv_item_joined_game_name"));
		 if (currentgames.isEmpty()) {
		 System.out.println("There are no current games");
		 }
		 System.out.println("There are"+" "+currentgames.size()+" "+"current games");
		 for (int i = 0; i < currentgames.size(); i++) {
		 Thread.sleep(15000);
		 System.out.println(currentgames.get(i).getText());
		 currentgames.get(i).click();
		 Thread.sleep(15000);
		 driver.navigate().back();
		 driver.navigate().back();
		 }
		 }
	@Test
	public void WaitingGames() throws Exception{
		 /*
		 * ------- Waiting
		 Games--------------------------------------------------------------
		 */
		 System.out.println(driver.getPageSource());
		 driver.findElement(By.linkText("Waiting Games")).click();
		 List<WebElement> waitinggames =
		 driver.findElements(By.id("tv_item_joined_game_name"));
		
		 if (waitinggames.isEmpty()) {
		 System.out.println("There are no waiting games");
		 }
		 System.out.println("There are"+" "+waitinggames.size()+" "+"waiting games in your list");
		
		 for (int j = 0; j < waitinggames.size(); j++) {
		 Thread.sleep(15000);
		 System.out.println(waitinggames.get(j).getText());
		 waitinggames.get(j).click();
		 Thread.sleep(15000);
		 if (driver.findElements(By.linkText("Waiting Games")).size() == 0) {
		 driver.navigate().back();
		 driver.navigate().back();
		 }
		
		 }
	}
	@Test
	public void CompletedGames(){
		
		 /*
		 * -------- completed
		 Games---------------------------------------------------------
		 */
		
		 driver.findElement(By.linkText("Completed Games")).click();
		 List<WebElement> completedgames =
		 driver.findElements(By.id("tv_item_joined_game_name"));
		 if (completedgames.isEmpty()) {
		 System.out.println("There are no completed games");
		 }
		 System.out.println("There are"+" "+completedgames.size()+" "+"completed games");
		 for (int k = 0; k < completedgames.size(); k++) {
		 System.out.println(completedgames.get(k).getText());
		 driver.navigate().back();
		
		 }
 
  }
}
