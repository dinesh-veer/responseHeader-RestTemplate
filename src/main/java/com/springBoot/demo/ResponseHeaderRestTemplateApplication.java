package com.springBoot.demo;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResponseHeaderRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseHeaderRestTemplateApplication.class, args);
	}

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ResponseHeaderRestTemplateApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
		//	HttpEntity<String> response = restTemplate.exchange(
		//			"https://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET,null ,String.class);
		//	log.info(response.)
				
				HttpEntity<String> response = restTemplate.exchange("https://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET, null, String.class);

				String resultString = response.getBody();
				HttpHeaders headers = response.getHeaders();
				log.info("Header", headers.toString());
				log.info("body", resultString.toString());
		};
	}
	
	
}
