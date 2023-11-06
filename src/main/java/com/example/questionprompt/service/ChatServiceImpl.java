// ChatServiceImpl.java
package com.example.questionprompt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.questionprompt.model.ResEntity;
import com.example.questionprompt.repository.ResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.questionprompt.model.CompletionRequest;
import com.example.questionprompt.model.CompletionResponse;
import com.example.questionprompt.model.Message;

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

	@Autowired
	private ResRepository resRepository;

	@Override
	public Optional<String> callToOpenAiApi(String prompt) {
		List<Message> messages = new ArrayList<>();

		msg.setContent(prompt);
		msg.setRole("user");
		messages.add(msg);
		request.setMessages(messages);
		request.setModel(model);
		request.setMax_tokens(500);
		request.setTemperature(0.7);

		CompletionResponse response = restTemplate.postForObject(apiUrl, request, CompletionResponse.class);
		// Save the response to the database
		ResEntity resEntity = new ResEntity();
		resEntity.setResponse(response.firstAnswer().orElse("")); // Save the response text
		resRepository.save(resEntity);
		return response.firstAnswer();
	}

}
