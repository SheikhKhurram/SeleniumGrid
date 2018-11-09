package com.qa.crm.Utility;

import com.qa.crm.Base.Base;

public class Utility extends Base 
{
    public static long implicitTimeOut = 20;
	public static long pageLoadTimeOut = 40;
	
	public static void swithFrame_To_Mainpanel()
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
