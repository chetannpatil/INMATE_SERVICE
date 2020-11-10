package io.chetan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




@SpringBootApplication
@EnableEurekaClient
public class InMateServiceApplication {

	private static Logger LOGGER = LogManager.getLogger(InMateServiceApplication.class);
	
	public static void main(String[] args)
	{
		LOGGER.info("\n\n\n InMateServiceApplication - main \n\n");
		SpringApplication.run(InMateServiceApplication.class, args);
		
	 //PGOwner p = new PGOwner();
	 
	 
	}

}
