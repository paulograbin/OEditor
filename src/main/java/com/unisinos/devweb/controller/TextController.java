package com.unisinos.devweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {

	@RequestMapping("/lista")
	public String index(Model uiModel) {
//		Gerenciador g = Gerenciador.getGerenciador();
//		g.init("/Users/paulograbin/Desktop/Desenvolvimento Web/src/main/webapp");
//		
//		System.out.println("Instanciando gerenciador no textcontroller");
//		
//		uiModel.addAttribute("files", g.getFiles());
		
		System.out.println("listando arquivos...");
		return "lista";
	}
	
}
