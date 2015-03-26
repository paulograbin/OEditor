package org.springframework.samples.service.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
}
