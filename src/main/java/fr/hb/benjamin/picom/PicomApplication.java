package fr.hb.benjamin.picom;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import fr.hb.benjamin.picom.service.StopService;




@SpringBootApplication
public class PicomApplication {

	public static void main(String[] args) {
	   
	       
	    
		SpringApplication.run(PicomApplication.class, args);
	}
	
	// TODO: data initialisation (TimeSlot)
	
//	@Value("classpath:data/tcl_sytral.json")
//	@Bean
//	CommandLineRunner runner(StopService stopService  ) {
//	
//		  return args -> {
//			
//			  Resource resourceFile;
//	            System.out.println(data);
//	        };
//		ObjectMapper mapper = new ObjectMapper();
//		TypeReference<Area> TypeReference.getClass().getResourceAsStream(name:"/json//Picom_Ben/src/main/resources/json/tcl_sytral.json");
//		
//	}

}
