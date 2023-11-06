package com.techelly.chatgptwithuserinterface.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techelly.chatgptwithuserinterface.model.CompletionRequest;
import com.techelly.chatgptwithuserinterface.model.CompletionResponse;
import com.techelly.chatgptwithuserinterface.model.Message;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Qualifier("openaiRestTemplate")
	@Autowired
	private RestTemplate restTemplate;

	@Value("${openai.model}")
	private String model;

	@Value("${openai.api.url.completion}")
	private String apiUrl;
	
	@Autowired
	private CompletionRequest request;
	
	@Autowired
	private Message msg;
	
	@Override
	public Optional<String> callToOpenAiApi(String prompt) {
		List<Message> messages =new ArrayList<Message>();
		
		msg.setContent(prompt);
		msg.setRole("user");
		messages.add(msg);
		request.setMessages(messages);
		request.setModel(model);
		request.setMax_tokens(500);
		request.setTemperature(0.7);
		
		CompletionResponse response = restTemplate.postForObject(apiUrl, request, CompletionResponse.class);
		return response.firstAnswer();
	}

}
