package scripts;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;
import io.selendroid.SelendroidLauncher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Delete_all_games {
	public SelendroidLauncher selendroidServer = null;
	  public WebDriver driver = null;
	  public String Basedir = System.getProperty("user.dir");
	  
	  //edited by ameer naveed
	  // edited second time
	  // edited third tim
	  
	  @Test(invocationCount = 2)
	  public void Delete_AllGames() throws Exception {
		if (selendroidServer != null) {
	      selendroidServer.stopSelendroid();
	    }
		SelendroidConfiguration config = new SelendroidConfiguration();
		selendroidServer = new SelendroidLauncher(config);
		selendroidServer.launchSelendroid();
		SelendroidCapabilities capa = new SelendroidCapabilities("com.nexii.treasurehunt:1.0");
//		capa.setBrowserName("android");
//		capa.setPlatform(Platform.ANDROID);
//		capa.setSerial("0123456789ABCDEF");
//		capa.setEmulator(false);
		driver = new SelendroidDriver(capa);
		Thread.sleep(5000);
		 //searching for signin button
		List<WebElement> signin = driver.findElements(By.id("btn_sign_in"));
//		signin.get(0).findElement(By.id("j")).getText();
		if(signin.size()!=0)
		  	//clicking on signin if exists
		    driver.findElement(By.id("btn_sign_in")).click();
		Thread.sleep(5000);
		 //Tapping on My Games
		driver.findElement(By.id("btn_view_activites")).click();
		 //getting all games
		List<WebElement> all_games = driver.findElements(By.id("tv_item_game_list")); 
			for (int i = 0; i < all_games.size(); i++) {
			List<WebElement> all_games_new = driver.findElements(By.id("tv_item_game_list")); 
			all_games_new.get(0).click();
			Thread.sleep(2000);
			driver.switchTo().window("NATIVE_APP");
		    new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Delete Game")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Yes")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
		driver.quit();
	  }
}
