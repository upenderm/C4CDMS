package com.c4networks.cdms.cdmsapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

	@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> loadWelcomePage() {

		String str = "<h1>WELCOME TO CDMSAPI</h1><a href='http://localhost:8082/cdmsapi/contractDocs/allAvailableContracts'>Click Here</a>";
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

}
