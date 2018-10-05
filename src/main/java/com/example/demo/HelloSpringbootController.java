package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringbootController {

	@RequestMapping({ "/" })
	public String index(HttpSession session) {

		Integer visits = (Integer) session.getAttribute("visits-by-session-key");
		visits = visits == null ? 1 : ++visits;
		
		session.setAttribute("visits-by-session-key", visits);

		return "visits by session => " + visits;
	}

}
