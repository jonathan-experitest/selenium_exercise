package Selenium_Agent.Selenium_Agent;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class IE_Test {
	
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc = DesiredCapabilities.internetExplorer();
		
		dc.setCapability("user", "jonathan.aharon");
        dc.setCapability("password", "Sanford8");
        dc.setCapability("project", "Default");
        dc.setCapability("generateReport", true);
        dc.setCapability("testName", "IE test");
        dc.setCapability("newSessionWaitTimeout", 60);
        dc.setCapability("newCommandTimeout", 60);

        URL url = new URL("https://sales.experitest.com/wd/hub/");
        
        RemoteWebDriver driver = new RemoteWebDriver(url, dc);
        
        driver.get("https://www.google.com");
        Thread.sleep(8000);
        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.click();
        Thread.sleep(5000);
        searchBar.sendKeys("Jerusalem");

        driver.findElement(By.xpath("//*[@id=\"hplogo\"]/div")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(), 'History of Jerusalem')]")).click();
        Thread.sleep(5000);
        System.out.println("url of page is: " + driver.getCurrentUrl());
        System.out.println("title of page is: " + driver.getTitle());
       	
	}

}
