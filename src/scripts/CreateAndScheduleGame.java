package scripts;
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
//ajay after gitignore again2 commit2
//commit-3
public class CreateAndScheduleGame extends Helper {
	  DateFormat dateFormat = new SimpleDateFormat("yymmddHHmmss");
	  Date date = new Date();
	  String app_name = "Ajay test "+dateFormat.format(date);
	  @Test(invocationCount =1)
	public void  Create_Game() throws Exception {
	//clicking on create a game
    driver.findElement(By.id("btn_create_game")).click();
    //entering game name
    driver.findElement(By.id("et_game_name")).sendKeys(app_name);
    driver.navigate().back();
    //entering game description
    driver.findElement(By.id("et_game_desc")).sendKeys(" Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890  Ajay game description 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890");
     //entering the first note name
//  driver.findElement(By.id("et_first_note")).sendKeys("First note hint");
    //hiding the keypad
    driver.navigate().back();    
    Thread.sleep(2000);
    //clicking on Next button
    driver.findElement(By.id("bt_newgame_next")).click();
    Thread.sleep(4000);
	FileInputStream fi = new FileInputStream(Basedir+"\\src\\TestData\\OR.xls");
    Workbook wb = Workbook.getWorkbook(fi);
	Sheet s = wb.getSheet(0);
	for(int i=1;i<s.getRows();i++){
    Thread.sleep(6000);
    //giving the first note address in map
    driver.findElement(By.id("atoText")).sendKeys(s.getCell(0, i).getContents());
    //selecting Abids from the suggestions 
//    driver.findElement(By.partialLinkText("Abids")).click();
    //clicking on go button in map
//    driver.findElement(By.linkText("GO")).click();
    //navigating and clicking on device options icon
    driver.switchTo().window("NATIVE_APP"); 
       new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
       Thread.sleep(2000);
    //clicking on "New Note Here" from options menu
    driver.findElement(By.linkText("New Note Here")).click();   
    Thread.sleep(5000);
    //Entering first description after reached
    driver.findElement(By.id("et_note_name")).sendKeys(s.getCell(1, i).getContents());
    //entering second note clue
    driver.findElement(By.id("et_note_desc")).sendKeys(s.getCell(2, i).getContents());
    //giving the radius for first note
    driver.findElement(By.id("et_note_radius")).sendKeys(s.getCell(3, i).getContents());
    //hiding the keypad
    driver.navigate().back();
    Thread.sleep(2000);
    //clicking on "Save Note" button
    driver.findElement(By.id("bt_note_save")).click();
    }
    Thread.sleep(4000);
    //navigating and clicking on device options icon
    driver.switchTo().window("NATIVE_APP");
       new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
    Thread.sleep(2000);   
    //clicking on view game   
    driver.findElement(By.linkText("View Game")).click();
    Thread.sleep(3000);
    //navigating and clicking on device options icon
    driver.switchTo().window("NATIVE_APP");
    new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
    Thread.sleep(3000);
    //Clicking on publish game
    driver.findElement(By.linkText("Publish Game")).click();
    Thread.sleep(5000);
    //getting all games
	List<WebElement> allCreatedGames = driver.findElements(By.id("tv_item_game_list")); 
	for (int i = 0; i < allCreatedGames.size(); i++) {
	if(allCreatedGames.get(i).getText().equalsIgnoreCase(app_name)){	
		allCreatedGames.get(i).click();
		break;
	}
	}
	Thread.sleep(5000);
	driver.switchTo().window("NATIVE_APP");
    new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
    Thread.sleep(2000);   
     //clicking on view game   
    driver.findElement(By.linkText("Schedule Game")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("ib_date")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Done")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("ib_time")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Done")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Schedule This Game")).click();
    System.out.println("scheduled");
    Thread.sleep(5000);
    //Tapping on Scheduled Games
    WebElement list = driver.findElement(By.id("tv_item_game_list"));
    TouchActions flick = new TouchActions(driver).flick(list, -500, 0, 100);
    flick.perform();
     //Tapping on Scheduled Games
//    driver.findElement(By.linkText("SCHEDULED GAMES")).click();
    List<WebElement> allScheduledGames = driver.findElements(By.id("tv_item_game_name"));
//    System.out.println("scheduled games: " +allScheduledGames.size());
	for (int i = 0; i < allScheduledGames.size(); i++) {
	if(allScheduledGames.get(i).getText().equalsIgnoreCase(app_name)){	
		allScheduledGames.get(i).click();
		break;
	}
	}
	Thread.sleep(5000);
	driver.switchTo().window("NATIVE_APP");
    new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
    Thread.sleep(2000);
     //Tapping on Invite
    driver.findElement(By.linkText("Invite Game")).click();
    Thread.sleep(3000);
    List<WebElement> listOfAppsToInvite = driver.findElements(By.id("text1"));
    System.out.println("list of apps: "+ listOfAppsToInvite.size());
    for (int i = 0; i < listOfAppsToInvite.size(); i++) {
    	System.out.println(i+": "+listOfAppsToInvite.get(i).getText());
		if(listOfAppsToInvite.get(i).getText().toLowerCase().contentEquals("gmail")){
			listOfAppsToInvite.get(i).click();
			break;
		}
	}
    driver.findElement(By.linkText("To")).sendKeys("akajaykovuri@gmail.com");
    Thread.sleep(15000);
    driver.quit();
	  }  
}