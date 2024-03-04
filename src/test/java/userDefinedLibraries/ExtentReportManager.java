package userDefinedLibraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/***********************************************************************************
*                                                                                  *
* Class Name     : ExtentReportManager                                             * 
* Description    : To Create the extent report file and store that as html file.   *
*                                                                                  *
************************************************************************************/

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