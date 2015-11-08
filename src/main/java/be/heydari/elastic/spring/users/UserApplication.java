package be.heydari.elastic.spring.users;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@Configuration
@EnableAutoConfiguration
public class UserApplication {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(UserApplication.class);
		application.run(args);
	}
}
