package br.com.cadastroapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	// Consultade status pra saber se o app está online
	@GetMapping(path = "/")
	public String check() {
		return "Online";
	}

}
