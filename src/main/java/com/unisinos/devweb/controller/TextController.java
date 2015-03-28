package com.unisinos.devweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {

	@RequestMapping("/lista")
	public String index() {
		System.out.println("listando arquivos...");
		return "lista";
	}
	
}
