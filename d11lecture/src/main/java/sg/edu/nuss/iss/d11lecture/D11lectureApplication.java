package sg.edu.nuss.iss.d11lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collections;



@SpringBootApplication
public class D11lectureApplication {

	public static void main(String[] args) {
		// Instead of directly running it
		// SpringApplication.run(D11lectureApplication.class, args);

		// Instantiate it
		SpringApplication app = new SpringApplication(D11lectureApplication.class);

		String port = "8080";

		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		if (cliOpts.containsOption("port")) {
			port = cliOpts.getOptionValues("port").get(0); // get the first value
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		// System.out.printf("Application started on port %d\n", port);
		app.run(args);

	}

	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}

}
