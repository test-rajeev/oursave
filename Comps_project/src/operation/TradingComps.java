package operation;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TradingComps extends Getobjectclass

{
	WebDriver driver;

	public TradingComps(WebDriver driver)
	{
		this.driver=driver;
	}

	public void perform(Properties p,String operation,String objectname,String objectType,String value) throws Exception
	{
	
	switch(operation.toUpperCase())
	{
	
	    case "WAIT":
		try{
		long time =(long)Double.parseDouble(value);
	    Thread.sleep(time*1000L);
	    System.out.println("wait worked");}
	    catch (NumberFormatException e){
	    System.out.println("not a number"); } 
		break;
		
		case "ROBOTwithKEYDOWN":
		try{
		Robot rob= new Robot();
		rob.delay(5000);
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.delay(1000);
		rob.keyRelease(KeyEvent.VK_DOWN);
		} catch(Exception e){System.out.println("could not call robot class");}
		break;
		
	case "ROTBOTwithENTER":
	Robot rob1= new Robot();
	rob1.delay(5000);
	rob1.keyPress(KeyEvent.VK_ENTER);
	rob1.delay(1000);
	rob1.keyRelease(KeyEvent.VK_ENTER);

	break;
	case "SELECTFROMDROPDOWN":
		WebElement element1=driver.findElement(this.getObject(p, objectname, objectType));
		Select se1=new Select(element1);
		se1.selectByValue(value);
		break;
		
	case "SELCTCONSUMER":
		WebElement element2=driver.findElement(this.getObject(p, objectname, objectType));
		Select se2=new Select(element2);
		se2.selectByVisibleText(value);;
		break;
		
	case"ASSERTPAGING":
		String actualpage=driver.findElement(this.getObject(p, objectname, objectType)).getText();
		Assert.assertEquals(actualpage, "1 - 2 of 2 items");
		break;
		
	case "DOUBLECLICK":
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(this.getObject(p, objectname, objectType))).build().perform();
		break;
		default:
			break;
	}
		}
	
	}
