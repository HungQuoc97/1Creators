package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v141.page.Page;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver driver;
	// khoi tao log
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getWebDriver() {
		return driver;
	}


	private String projectLocation = System.getProperty("user.dir");

	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}

	private enum OS {
		WINDOWNS, MAC_OXS, LINUX;
	}

	private enum PLATFORM {
		ANDROID, IOS, WINDOWN_PHONE;
	}

	protected WebDriver getBrowserDriver(String browserName) {

		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
       
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please check brower name!");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		//driver.get(GlobalConstants.STAING_APP_URL);
		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			String profilePath = "/Users/hungdq/Library/Application Support/Firefox/Profiles/dqidx4mt.default-release";

			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
			options.addArguments("-profile", profilePath);

			driver = new FirefoxDriver(options);

		} else if (browser == BROWSER.CHROME) {
//			WebDriverManager.chromedriver().setup();

			
			ChromeOptions options = new ChromeOptions();
			// Thay đường dẫn bằng folder profile bạn tạo ở bước trước
			 String userDataDir = "/Users/hungdq/Library/Application Support/Google/Chrome/TestProfile";

		    options.addArguments("--user-data-dir=" + userDataDir);
			
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);

			driver = new ChromeDriver(options);

			DevTools devTools = ((ChromeDriver) driver).getDevTools();
			devTools.createSession();

			String js = "" + "Object.defineProperty(navigator, 'webdriver', {get: () => undefined});"
					+ "window.navigator.chrome = window.navigator.chrome || {runtime: {}};"
					+ "Object.defineProperty(navigator, 'languages', {get: () => ['en-US','en']});"
					+ "Object.defineProperty(navigator, 'vendor', {get: () => 'Google Inc.'});";

			try {
				devTools.send(Page.addScriptToEvaluateOnNewDocument(js, java.util.Optional.empty(),
						java.util.Optional.empty(), java.util.Optional.empty()));
			} catch (Throwable t) {

				try {
					devTools.send(Page.addScriptToEvaluateOnNewDocument(js, java.util.Optional.empty(),
							java.util.Optional.empty(), java.util.Optional.empty()));
				} catch (Throwable t2) {
					// final fallback: evaluate at runtime (less ideal)
					devTools.send(org.openqa.selenium.devtools.v85.runtime.Runtime.evaluate(js,
							java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(),
							java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(),
							java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(),
							java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(),
							java.util.Optional.empty())); // adjust import/version as needed
				}
			}

		} else if (browser == BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please check brower name!");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(appUrl);
		return driver;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private void deleteRecursively(Path path) throws IOException {
	    if (path == null || !Files.exists(path)) return;
	    Files.walk(path)
	         .sorted(Comparator.reverseOrder())
	         .forEach(p -> {
	             try { Files.deleteIfExists(p); }
	             catch (IOException ex) { /* log if needed */ }
	         });
	}
	//verify true 2 tham so
	protected void verifyTrue(boolean condition, String message) {
	    try {
	        Assert.assertTrue(condition, message);
	        System.out.println("✅ " + message);
	    } catch (AssertionError e) {
	        System.out.println("❌ " + message);
	        throw e; // ⚠️ Quan trọng: ném lại lỗi để TestNG đánh dấu FAIL
	    }
	}

	
	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;

			// add loi vao reportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		log.info("---------- START delete file in folder ----------");

		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "\\screenshotReportNG";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		log.info("---------- END delete file in folder ----------");
	}

	private String getSlash(String folderName) {
		String separator = java.io.File.separator;
		return separator + folderName + separator;
	}

	public String generateEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(9999) + "@qa.team";
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + osName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}
			System.out.print("Driver instance = " + driver.toString());

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				System.out.println("Close driver instance");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}   if (!cmd.isEmpty()) {
            try {
                Process process;

                // ✅ Use bash on Mac/Linux, exec directly on Windows
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    process = Runtime.getRuntime().exec(cmd);
                } else {
                    process = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", cmd});
                }

                process.waitFor();
                System.out.println("Executed command: " + cmd);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

}
