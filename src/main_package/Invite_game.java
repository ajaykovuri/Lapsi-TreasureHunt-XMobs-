package main_package;

import java.util.List;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Invite_game {
	public SelendroidLauncher selendroidServer = null;
	  public WebDriver driver = null;
	  public String Basedir = System.getProperty("user.dir");
@Test
public void invite_game() throws Exception{
	if (selendroidServer != null) {
	    selendroidServer.stopSelendroid();
	    }
	    SelendroidConfiguration config = new SelendroidConfiguration();
	    selendroidServer = new SelendroidLauncher(config);
	    selendroidServer.launchSelendroid();
	    SelendroidCapabilities capa = new SelendroidCapabilities("com.nexii.treasurehunt:1.0");
	    capa.setBrowserName("selendroid");
		capa.setPlatform(Platform.ANDROID);
		capa.setSerial("0123456789ABCDEF");
		capa.setEmulator(false);
	    driver = new SelendroidDriver(capa);
	    Thread.sleep(5000);
	  //searching for signin button
	    List<WebElement> signin = driver.findElements(By.id("btn_sign_in"));
	    if(signin.size()!=0)
	    	//clicking on signin if exists
	    driver.findElement(By.id("btn_sign_in")).click();
	    Thread.sleep(3000);
}
}
