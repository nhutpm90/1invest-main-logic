package com.invest.microservices.mainlogic.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private Environment environment;
	
	@Value("${app.env}")
    private String env;
	
	@GetMapping("/live-check")
	public String liveCheck() throws Exception {
		Integer port = Integer.parseInt(environment.getProperty("local.server.port"));
		return "1Invest Main Logic Server:: port:: " + port + " - " + new Date() + " - env:: " + env;
	}
}
