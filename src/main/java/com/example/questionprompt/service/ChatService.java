package com.example.questionprompt.service;

import java.util.Optional;

public interface ChatService {
	
	public Optional<String> callToOpenAiApi(String prompt);
}
