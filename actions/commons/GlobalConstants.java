package commons;

import java.io.File;
import java.time.Duration;

public class GlobalConstants {

	public static final String DEV_APP_URL = "";
	public static final String STAING_APP_URL = "";
	public static final String TESTING_APP_URL = " ";

//	public static final long SHORT_TIMEOUT = 5;
//	public static final long LONG_TIMEOUT = 10;

	public static final Duration SHORT_TIMEOUT = Duration.ofSeconds(5);
	public static final Duration LONG_TIMEOUT = Duration.ofSeconds(20);
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "dowloadFiles";

	public static final String DEV_DB_URL = "";
	public static final String DEV_DB_USER = "";
	public static final String DEV_DB_PASS = "";

	public static final String TEST_DB_URL = "";
	public static final String TEST_DB_USER = "";
	public static final String TEST_DB_PASS = "";
}
