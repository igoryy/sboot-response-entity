package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/teste")
public class RestController {

	
	@GetMapping
	public ResponseEntity<String> buscar(){
		String teste = "Talvez eu não seja criativo";
		
		
		return ResponseEntity.ok(teste);
	}
}
