package sg.edu.nus.iss.day11_workshop;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11WorkshopApplication {

	private static final Logger logger = LoggerFactory.getLogger(Day11WorkshopApplication.class); 
	private static String portNumber = null;
	private static final String DEFAULT_PORT = "3000"; 

	public static void main(String[] args) {

		// option 1: mvn spring-boot:run -Dspring-boot.run.arguments=--port=3050
		for (String value : args) {
			logger.debug("value : " + value);
			if (value.contains("--port=")) {
				portNumber = value.substring(value.length() - 4, value.length()); 
				logger.debug("portNumber : " + portNumber);
			}
		}
		// option 2
		if (portNumber == null) {
			portNumber = System.getenv("PORT"); 
			logger.debug("System environment portNumber : " + portNumber); 
		}
		// default option
		if (portNumber == null) {
			portNumber = DEFAULT_PORT; 
		}

		SpringApplication app = new SpringApplication(Day11WorkshopApplication.class); 
		app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		app.run(args); 
	}
}
