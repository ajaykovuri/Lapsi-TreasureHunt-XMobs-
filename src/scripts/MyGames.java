package scripts;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

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
//changes1
public class MyGames extends Helper {
	
	@Test
	public void MyGamesTest() throws Exception{
	driver.findElement(By.id("btn_view_activites")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Games")).click();
	List<WebElement> createdgames =	driver.findElements(By.id("tv_item_game_list"));
	System.out.println(createdgames.size());
	for (int i = 0; i < createdgames.size(); i++) {
		System.out.println(createdgames.get(i).getText());
	}
	createdgames.get(0).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//ActionMenuView")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Manage Notes")).click();
	//Thread.sleep(5000);
	if (!driver.findElements(By.id("alertTitle")).isEmpty()) {
		driver.navigate().back();
	}
	Thread.sleep(5000);
	driver.findElement(By.id("atoText")).sendKeys("pune");
	Thread.sleep(5000);
// // System.out.println(dr.getPageSource());
	driver.findElement(By.xpath("//ActionMenuView")).click();
	driver.findElement(By.linkText("New Note Here")).click();
	Thread.sleep(5000);
	Date d3 = new Date();
	driver.findElement(By.id("et_note_name")).sendKeys("Note "+d3.toString());
	driver.findElement(By.id("et_note_desc")).sendKeys("Desc "+d3.toString());
	driver.findElement(By.id("et_note_radius")).sendKeys("10");
	driver.navigate().back();
	driver.findElement(By.id("bt_note_save")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//ActionMenuView")).click();
	driver.findElement(By.linkText("View Game")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("iv_update_note")).click();
//	List<WebElement> notescount = dr.findElements(By.id("iv_update_note"));
//	System.out.println(notescount.size());
//	Random r = new Random();
//	int editnote = r.nextInt(notescount.size());
////	//((JavascriptExecutor)dr).executeScript("arguments[0].click();", notescount.get(editnote));
////	System.out.println(notescount.size());
//	Thread.sleep(5000);
//	int attempts = 0;
//	while (attempts < 10) {
//		try {
//			notescount.get(editnote).click();
//			break;
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("the this");
//			attempts++;
//		}
//	}
	
	Thread.sleep(5000);
	driver.findElement(By.id("et_note_name")).sendKeys("edited ");
	driver.findElement(By.id("et_note_desc")).sendKeys("edited ");
	driver.findElement(By.id("et_note_radius")).sendKeys("0");
	driver.navigate().back();
	driver.findElement(By.id("bt_note_save")).click();

	  // Deleting Note
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ActionMenuView")).click();
	driver.findElement(By.linkText("View Game")).click();
	Thread.sleep(7000);
//	List<WebElement> notesCountOfNewNote = dr.findElements(By.id("iv_delete_note"));
//	int deletingnote = r.nextInt(notesCountOfNewNote.size());
	//((JavascriptExecutor)dr).executeScript("arguments[0].click();", notesCountOfNewNote.get(deletingnote));
	driver.findElementById("iv_delete_note").click();
	driver.findElement(By.linkText("OK")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//ActionMenuView")).click();
	driver.findElement(By.linkText("Edit Game")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("et_game_name")).sendKeys("+updated");
	driver.findElement(By.id("et_game_desc")).sendKeys("+updated");
	driver.navigate().back();
	driver.findElement(By.id("bt_newgame_next")).click();
	Thread.sleep(4000);
	List<WebElement> editedcreatedgame = driver.findElements(By.id("tv_item_game_list"));
	editedcreatedgame.get(0).click();
	driver.findElement(By.xpath("//ActionMenuView")).click();
	if (!driver.findElementsByLinkText("Publish Game").isEmpty()) {
		driver.findElement(By.linkText("Publish Game")).click();
	}
	Thread.sleep(6000);
	//dr.findElement(By.xpath("//ActionMenuView")).click();
	driver.findElement(By.linkText("Schedule Game")).click();
	driver.findElement(By.id("ib_date")).click();
	driver.findElement(By.linkText("Done")).click();
	driver.findElement(By.id("ib_time")).click();
	List<WebElement> time = driver.findElements(By.id("numberpicker_input"));
	System.out.println(time.size());
	String timing = (time.get(1).getText()+":"+time.get(2).getText());
	System.out.println(timing);
	driver.findElement(By.linkText("Done")).click();
	driver.findElement(By.id("bt_invite_game")).click();
	Thread.sleep(15000);
//	dr.navigate().back();
//	dr.navigate().back();
	Thread.sleep(10000);
//
driver.findElement(By.linkText("Game Schedules")).click();
TouchActions flick = new TouchActions(driver).flick(driver.findElement(By.id("content")), 0, -2000,100);
flick.perform();
 List<WebElement> scheduledgamestime = driver.findElements(By.id("tv_item_schedule_time"));
//
for (int j = 0; j < scheduledgamestime.size(); j++) {
	if (scheduledgamestime.get(j).getText().contains(timing)) {
		scheduledgamestime.get(j).click();
		driver.findElement(By.xpath("//ActionMenuView")).click();
		driver.findElement(By.linkText("Invite Game")).click();
		break;
	}
}
//
TouchActions flick1 = new TouchActions(driver).flick(driver.findElement(By.id("customPanel")), 0,-1000, 100);
flick1.perform();
driver.findElement(By.linkText("WhatsApp")).click();


}
}