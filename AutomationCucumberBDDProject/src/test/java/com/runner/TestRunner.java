package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Feature"},
        glue = {"com.stepdefination"},//,"com.base.Hooks"
        plugin = {"pretty", "json:target/json-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        monochrome = true,
        publish = true      
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
