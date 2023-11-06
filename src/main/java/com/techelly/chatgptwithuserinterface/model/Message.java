package com.techelly.chatgptwithuserinterface.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 
 *This represents the actual request being sent to the model so that the model can 
 *parse the message and generate a corresponding response in a human-readable format.
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Message {
	private String role;//Specifies the sender of the message(it is 'user' for request and 'assistant' in response).
	private String content; //This is the actual message
	// getters & setters
}