package CharterReporter;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cognizant.framework.core.EnvParameters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class TestNGReporter implements IReporter {
	private final Logger L = Logger.getLogger(TestNGReporter.class);
	private PrintWriter m_out;
	private int m_row;
	private Integer m_testIndex;
	Date date = new Date();
	String reportFileName = "CharterNet_SeleniumTestReport.html";
	SimpleDateFormat FileNameDateFormat = new SimpleDateFormat("ddMMyy_HHmm");
	String destFileName = "CharterNet_SeleniumTestReport_" + FileNameDateFormat.format(date) + ".html";
	String xmlFile;
	String reportSource;
	String gSetting = "Maven";
	
	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
		try {
			m_out = createWriter(outdir);
		}
	    catch (IOException e) {
	    	L.error("output file", e);
	    	return;
	    }
	    startHtml(m_out);
	    generateSuiteSummaryReport(suites);
	    generateMethodSummaryReport(suites);
	    endHtml(m_out);
	    m_out.flush();
	    m_out.close();
	    copyResultFile(reportFileName, destFileName);
	}

	private void copyResultFile(String reportFileName, String destFileName) {
		File file = new File(reportFileName);
		String projectPath = file.getAbsolutePath().toString();
		projectPath = projectPath.replace(reportFileName, "");
		if(gSetting=="Maven"){
			reportSource = "\\target\\surefire-reports\\";
		}else {
			reportSource = "\\test-output\\";
		}
		//reportSource = "\\test-output\\";
		String NewReportFileName = projectPath + reportSource + reportFileName;
		String NewDestFileName = projectPath + "\\src\\main\\java\\CharterReporter\\ResultsArchive\\" + destFileName;
		Path FROM = Paths.get(NewReportFileName);
		Path TO = Paths.get(NewDestFileName);
		try {
			if (Files.exists(FROM)){Files.copy(FROM, TO);
			System.out.println("TestNGReporter: ****Report generated and copied*****");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	protected PrintWriter createWriter(String outdir) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, reportFileName))));
	}

	protected void generateMethodSummaryReport(List<ISuite> suites) {
		startResultSummaryTable("methodOverview");
	    int testIndex = 1;
	    for (ISuite suite : suites) {
	    	if(suites.size()>1) {
	    		titleRow(suite.getName(), 5, null);
	    	}
	    	Map<String, ISuiteResult> r = suite.getResults();
	    	for (ISuiteResult r2 : r.values()) {
	    		ITestContext testContext = r2.getTestContext();
	    		String testName = testContext.getName();
	    		m_testIndex = testIndex;
	    		resultSummary(suite, testContext.getFailedTests(), testName, "Failed", "");
	            resultSummary(suite, testContext.getPassedTests(), testName, "Passed", "");
	            resultSummary(suite, testContext.getSkippedTests(), testName, "Skipped", "");
	            testIndex++;
	    	}
	    }
	    m_out.println("</table>");
	}

	private void startResultSummaryTable(String style) {
		tableStart(style, "summary");
	    m_out.println("<tr><th>Sl No.</th><th>Module</th><th>Scenario</th><th>Test Result</th><th>Validation Remarks</th>"
	    		+ "<th>Date/Time</th><th>Time (Sec)</th></tr>");
	    m_row = 0;
	}

	private void resultSummary(ISuite suite, IResultMap tests, String testname, String style, String details) {
		if (tests.getAllResults().size() > 0) {
			int mq = 0;
			for (ITestNGMethod method : getMethodSet(tests, suite)) {
				m_row += 1;
				ITestClass testClass = method.getTestClass();
				String className = testClass.getName();
				if (mq == 0) {
					String id = (m_testIndex == null ? null : "t" + Integer.toString(m_testIndex));
					titleRow(testname + ": " + style + details, 7, id);
					m_testIndex = null;
				}
				long end = Long.MIN_VALUE;
				long start = Long.MAX_VALUE;
				for (ITestResult testResult : tests.getResults(method)) {
					if (testResult.getEndMillis() > end) {
						end = testResult.getEndMillis();
					}
					if (testResult.getStartMillis() < start) {
						start = testResult.getStartMillis();
					}
				}
				//Date date = new Date(method.getDate());
				//Calendar cal = Calendar.getInstance();
				SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss");
		        int serialNo = mq + 1;
		        String newClassName = className.substring(className.lastIndexOf(".") + 1);
				String valMsg = "";
		        m_out.println("<tr><td>" + serialNo + "</td><td>" + newClassName + "</td><td>" + qualifiedName(method) + "</td>");
		        if (style == "Failed"){
		        	valMsg = getExceptionValue(qualifiedName(method));
		        	if(valMsg.indexOf("expected")!= -1){
		        		valMsg = valMsg.substring(0, valMsg.indexOf("expected"));
		        	}
		    		if(!(valMsg.indexOf("Build info")==-1)){
		    			valMsg = valMsg.substring(0, valMsg.indexOf("Build info"));
		    		}
		    		if(!(valMsg.indexOf("For documentation")==-1)){
		    			valMsg = valMsg.substring(0, valMsg.indexOf("For documentation"));
		    		}
		        	m_out.print("<td bgcolor='red', align='center'>Fail</td>");
		        } else if (style == "Passed"){
		        	m_out.print("<td bgcolor='green', align='center'>Pass</td>");
		        } else {
		        	m_out.print("<td bgcolor='yellow', align='center'>Skip</td>");
		        }
		        m_out.print("<td>" + valMsg + "</td>");
		        m_out.print("<td align='center'>" + df2.format(start) + "</td>");
		        m_out.print("<td align='center'>" + (end - start)/1000 + "</td></tr>");
				mq += 1;
	      }
	   }
	}

	private String getExceptionValue(String strMethod){
		String projectPath = System.getProperty("user.dir");
		java.net.URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
		String retMsg = "";
		try {
			if(gSetting=="Maven"){
				xmlFile = projectPath + "\\target\\surefire-reports\\testng-results.xml";
			}else {
				xmlFile = projectPath + "\\test-output\\testng-results.xml";
			}
			File fXmlFile = new File(xmlFile);
			if(!fXmlFile.exists()){
				System.out.println("***** getExceptionValue function error - XML file not present" + xmlFile);
				Thread.sleep(60000);
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("test-method");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = (Node) nList.item(temp);
				Element eElement = (Element) nNode;
				if (eElement.getAttributeNode("signature").getTextContent().contains(strMethod)){
					retMsg = eElement.getElementsByTagName("exception").item(0).getTextContent().trim();
					retMsg = retMsg.substring(0, retMsg.indexOf("java")).trim();
				}
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return retMsg;
	}	
	
	private String qualifiedName(ITestNGMethod method) {
		StringBuilder addon = new StringBuilder();
	    String[] groups = method.getGroups();
	    int length = groups.length;
	    if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
	    	addon.append("(");
	    	for (int i = 0; i < length; i++) {
	    		if (i > 0) {
	    			addon.append(", ");
	    		}
	    		addon.append(groups[i]);
	        }
	    	addon.append(")");
	    }
	    return method.getMethodName() + addon;
	}

	private Collection<ITestNGMethod> getMethodSet(IResultMap tests, ISuite suite) {
		List<IInvokedMethod> r = Lists.newArrayList();
		List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
		for (IInvokedMethod im : invokedMethods) {
			if (tests.getAllMethods().contains(im.getTestMethod())) {
				r.add(im);
			}
		}
		Arrays.sort(r.toArray(new IInvokedMethod[r.size()]), new TestSorter());
	    List<ITestNGMethod> result = Lists.newArrayList();
	    for (IInvokedMethod m : r) {
	    	result.add(m.getTestMethod());
	    }
	    for (ITestNGMethod m : tests.getAllMethods()) {
	    	if (!result.contains(m)) {
	    		result.add(m);
	    	}
	    }
	    return result;
	}

	public void generateSuiteSummaryReport(List<ISuite> suites) {
	    tableStart("testOverview", null);
	    m_out.print("<tr><th>Module</th><th>Total</th><th>Pass</th><th>Fail</th><th>Skipped</th><th>Total Time(Mins)</th></tr>");
	    NumberFormat formatter = new DecimalFormat("#,##0.0");
	    int qty_tests = 0;
	    int qty_all = 0;
	    int qty_pass = 0;
	    int qty_skip = 0;
	    int qty_fail = 0;
	    long time_start = Long.MAX_VALUE;
	    long time_end = Long.MIN_VALUE;
	    m_testIndex = 1;
	    for (ISuite suite : suites) {
	    	if (suites.size() > 1) {
	    		titleRow(suite.getName(), 6, null);
	    	}
	    	Map<String, ISuiteResult> tests = suite.getResults();
	    	for (ISuiteResult r : tests.values()) {
	    		qty_tests += 1;
	    		ITestContext overview = r.getTestContext();
	    		startSummaryRow(overview.getName());
	    		int q = overview.getAllTestMethods().length;
	    		qty_all += q;
				summaryCell(q,Integer.MAX_VALUE);
				q = getMethodSet(overview.getPassedTests(), suite).size();
				qty_pass += q;
				summaryCell(q,Integer.MAX_VALUE);
				q = getMethodSet(overview.getFailedTests(), suite).size();
				qty_fail += q;
				summaryCell(q,0);
				q = getMethodSet(overview.getSkippedTests(), suite).size();
				qty_fail += q;
				summaryCell(q,0);
				time_start = Math.min(overview.getStartDate().getTime(), time_start);
				time_end = Math.max(overview.getEndDate().getTime(), time_end);
				summaryCell(formatter.format((overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000/60.), true);
				m_testIndex++;
			}
	    }
	    if (qty_tests > 1) {
			m_out.println("<tr><td>Total</td>");
			summaryCell(qty_all,Integer.MAX_VALUE);
			summaryCell(qty_pass,Integer.MAX_VALUE);
			summaryCell(qty_skip,0);
			summaryCell(qty_fail,0);
			summaryCell(formatter.format((time_end - time_start) / 1000.) + " seconds", true);
	    }
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy");
		String strBrowser = EnvParameters.WEB_BROWSER_TYPE;
		String strBrowserNew = "Default";
		if(strBrowser.equalsIgnoreCase("*firefox")){
			strBrowserNew = "Mozilla Firefox";
		}else if (strBrowser.equalsIgnoreCase("*chrome")){
			strBrowserNew = "Google Chrome";
		}else if (strBrowser.equalsIgnoreCase("*iexplore")){
			strBrowserNew = "MS Internet Explorer";
		}
		m_out.println("</tr>");
		m_out.println("<script type='text/javascript' src='https://www.google.com/jsapi'></script><script type='text/javascript'>");
		m_out.println("google.load('visualization', '1', {packages:['corechart']});google.setOnLoadCallback(drawChart);");
		m_out.println("function drawChart() {");
		m_out.println("var data = google.visualization.arrayToDataTable([['Result', 'Count'],['Pass',"+ qty_pass +"],['Fail',"+ qty_fail +"],['Skip'," + qty_skip +"]]);");
		m_out.println("var options = {title: 'Test Results Graph', is3D: true, backgroundColor: '#CEF6CE', chartArea: {width:'80%',height:'80%'}, colors: ['green', 'red', 'yellow']};");
		m_out.println("var chart = new google.visualization.PieChart(document.getElementById('piechart'));");
		m_out.println("chart.draw(data, options);}</script>");
		m_out.println("<tr><td colspan='6' id='piechart' style='width: 200px; height: 200px'></td></tr>");
		m_out.println("<tr><td>Browser</td><td colspan='5'>" + strBrowserNew + "</td></tr>");
		m_out.println("<tr><td>Date</td><td colspan='5'>" + df1.format(cal.getTime()) + "</td></tr>");
		m_out.println("<tr><td>Timezone</td><td colspan='5'>" + cal.getTimeZone().getDisplayName() + "</td></tr>");
		m_out.println("<tr><td colspan='6' align='right'><a href='FAQ.txt'>FAQ</a> and <a href='readme.txt'>Readme.txt</a></td></tr></table>");
	}

	private void summaryCell(String v,boolean isgood) {
		m_out.print("<td class=\"numi"+(isgood?"":"_attn")+"\">" + v + "</td>");
	}

	private void startSummaryRow(String label) {
		m_row += 1;
	    m_out.print("<tr" + (m_row % 2 == 0 ? " class=\"stripe\"" : "")
	    		+ "><td style=\"text-align:left;padding-right:2em\">" + label + "</td>");
	}

	  private void summaryCell(int v,int maxexpected) {
	    summaryCell(String.valueOf(v),v<=maxexpected);
	  }

	private void tableStart(String cssclass, String id) {
		m_out.println("<table cellspacing=\"0\" cellpadding=\"0\""
	        + (cssclass != null ? " class=\"" + cssclass + "\""
	            : " style=\"padding-bottom:2em\"")
	        + (id != null ? " id=\"" + id + "\"" : "")
	        + ">");
	    m_row = 0;
	}
	  
	private void titleRow(String label, int cq, String id) {
		m_out.print("<tr");
	    if (id != null) {
	    	m_out.print(" id=\"" + id + "\"");
	    }
	    m_out.println( "><th colspan=\"" + cq + "\">" + label + "</th></tr>");
	    m_row = 0;
	}

	protected void startHtml(PrintWriter out) {
	    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
	    out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	    out.println("<head>");
	    out.println("<title>Chater.Net Test Report</title>");
	    out.println("<style type=\"text/css\">");
	    out.println("table {background-color: #CEF6CE; margin-bottom:10px; border: 1px solid black; border-collapse:collapse; font-family: 'Arial'; font-size: 14px}");
	    out.println("td,th {border:1px solid #009;padding:.25em .5em}");
	    out.println(".result th {vertical-align:bottom}");
	    out.println(".param th {padding-left:1em;padding-right:1em}");
	    out.println(".param td {padding-left:.5em;padding-right:2em}");
	    out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
	    out.println(".numi,.numi_attn {text-align:right}");
	    out.println(".total td {font-weight:bold}");
	    out.println(".stacktrace {white-space:pre;font-family:monospace}");
	    out.println(".totop {font-size:65%;text-align:center;border-bottom:2px solid #000}");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body bgcolor=#E0F8E0><h2 align='center'>Charter.Net Selenium Test Report</h2></br>");
	}

	protected void endHtml(PrintWriter out) {
		out.println("</body></html>");
	}

	private class TestSorter implements Comparator<IInvokedMethod> {
		public int compare(IInvokedMethod o1, IInvokedMethod o2) {
			return (int) (o1.getDate() - o2.getDate());
		}
	}

	public void onTestStart(ITestResult tr) {
		System.out.println("Test Started....");
	}

}
