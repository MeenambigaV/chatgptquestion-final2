package com.techelly.chatgptwithuserinterface.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.techelly.chatgptwithuserinterface.dto.FormInputDTO;
import com.techelly.chatgptwithuserinterface.service.ChatService;

@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;
	// Handler methods to handle http request and prepare response

	// To load chat page
	// URL : http://localhost:8080/chat
	@GetMapping("/chat")
	public ModelAndView loadChatPage(@ModelAttribute FormInputDTO formInputDTO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@PostMapping("/")
	public ModelAndView getResponseFromOpenAiAPi(@ModelAttribute FormInputDTO formInputDTO) {
		Optional<String> response = chatService.callToOpenAiApi(formInputDTO.getPrompt());
		ModelAndView mv = new ModelAndView();
		mv.addObject("response", response.get());
		mv.setViewName("blog");
		return mv;
	}
}
