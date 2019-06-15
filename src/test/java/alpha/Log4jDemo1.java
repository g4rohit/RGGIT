package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Academy.Log4JImplementation;

public class Log4jDemo1 {

	private static Logger Log= LogManager.getLogger(Log4JImplementation.class.getName());
	
	@Test
	public void Log4j1()
	{
		Log.debug("I have clicked on button");
		Log.info("This is information");
		Log.error("This error belongs to package alpha");
		Log.fatal("This fatal is from Alpha");
	
		
	}
}
