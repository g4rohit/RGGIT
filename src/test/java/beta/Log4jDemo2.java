package beta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Academy.Log4JImplementation;

public class Log4jDemo2 {
	
	private static Logger Log= LogManager.getLogger(Log4JImplementation.class.getName());
	
@Test
public void Log4j2()
{
	Log.debug("I have clicked on button");
	Log.info("This is information");
	Log.error("This error belongs to package beta");
	Log.fatal("This fatal is from beta");
}

}
