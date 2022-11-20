package poly.store.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import poly.store.interceptor.chatmessage;

@Controller
public class chatController {
	 @MessageMapping("/chat.sendMessage")
	    @SendTo("/topic/public")
	    public chatmessage sendMessage(@Payload chatmessage chatMessagePojo) {
	        return chatMessagePojo;
	    }

	    @MessageMapping("/chat.addUser")
	    @SendTo("/topic/public")
	    public chatmessage addUser(@Payload chatmessage chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
	        
	// Add username in web socket session
	    headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
	        return chatMessagePojo;
	    }
}
