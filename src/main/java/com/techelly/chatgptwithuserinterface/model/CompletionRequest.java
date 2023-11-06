package com.techelly.chatgptwithuserinterface.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompletionRequest {
	private String model;
	//private String prompt; 
	private double temperature;
	private int max_tokens;
	 private List<Message> messages;
}
