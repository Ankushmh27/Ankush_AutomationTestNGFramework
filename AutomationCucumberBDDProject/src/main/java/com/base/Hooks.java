package com.base;

import io.cucumber.java.Scenario;
import java.io.IOException;

import com.utils.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks extends BaseSetup {
	
	@Before
	public void beforeScenario(Scenario scenario) throws IOException
	{
			startBrowser() ;// run by config property
//			startBrowser("browser");  //run parallel by xml
	}
	@After
	public void afterScenario(Scenario scenario) throws Exception
	{
		if(scenario.isFailed()) {
			scenario.attach(Utility.takeScreenShot(driver), ".png", scenario.getName());
		}
		closeBrowser();
	}
}


