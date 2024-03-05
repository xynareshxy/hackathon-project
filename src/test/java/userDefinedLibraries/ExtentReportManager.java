package userDefinedLibraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {

			// currentTimeMillis() to prevent overwriting of reports for pass and fail
			String reportName = System.currentTimeMillis() + ".html";
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./reports/extent" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			
		}

		return report;
	}

}