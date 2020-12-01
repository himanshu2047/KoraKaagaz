package infrastructure.validation.logger;

public class LoggerManagerTest {

	public static void main(String[] args) {
		
		ILogger test = LoggerFactory.getLoggerInstance();
		
		test.log(ModuleID.PROCESSING, LogLevel.INFO, "test");

	}

}
