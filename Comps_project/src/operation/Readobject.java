package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readobject 
{
	Properties p=new Properties();
	
public Properties getobjectrepository() throws IOException
{

// original path by sweta
//	File src=new File("C:\\Comps_workspace\\Comps_project\\src\\objects\\object.properties");

	File src=new File("./src/objects/object.properties");
	
	FileInputStream fs=new FileInputStream(src);
	p.load(fs);
	p.setProperty("managecomps", "MANAGE COMPS");
//	p.setProperty("drpclickedvalue_retail_subsector", "//div[@class='k-list-scroller']//ul[@id='MulSel_SubSector_listbox']//li[text()='Retail']");
//	p.setProperty("drpclickedvalue_portfolio_airline", "//div[@class='k-list-scroller']//ul[@id='MulSel_Portfolio_listbox']//li[text()='Airlines']");
	
	//System.out.println(p.getProperty("menu_TradingComps"));
	return p;
	}
}
