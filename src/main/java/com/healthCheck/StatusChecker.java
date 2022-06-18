package com.healthCheck;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//clase adaptada de https://github.com/CodelyTV/java-ddd-skeleton/

@RestController
public class StatusChecker {
	
	
	    @GetMapping("/health-check")
	    public HashMap<String, String> index() {
	        HashMap<String, String> status = new HashMap<>();
	        status.put("application", "mooc_backend");
	        status.put("status", "ok");

	        return status;
	    }
}