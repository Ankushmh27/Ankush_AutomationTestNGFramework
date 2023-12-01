package com.Utilities;

import java.io.IOException;
import com.BaseClass.baseSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtils extends baseSetup
{
	public static ExtentReports report;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest test;

	public static void reportInit() throws IOException
	{
		report = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("E:\\EclipseProject\\MyCucumberFramework\\Ankush_Automation_Test\\Report\\ExtentReport.html");
		report.attachReporter(htmlReporter);// connection between spark and report
		htmlReporter.config().setCss("css-string");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		report.setSystemInfo("Tester Name ", "Ankush");
		report.setSystemInfo( "Environment ",utility.configReader("environment"));
		report.setSystemInfo("Build No ", "1");
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJs("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
}

