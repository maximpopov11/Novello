package myProject.chat;

import myProject.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller      // this is needed for this to be an endpoint to springboot
@ServerEndpoint(value = "/chat/{username}/{GroupID}")  // this is Websocket url
public class ChatSocket {

  // cannot autowire static directly (instead we do it by the below
  // method
	private static MessageRepository msgRepo; 

	/*
   * Grabs the MessageRepository singleton from the Spring Application
   * Context.  This works because of the @Controller annotation on this
   * class and because the variable is declared as static.
   * There are other ways to set this. However, this approach is
   * easiest.
	 */
	@Autowired
	public void setMessageRepository(MessageRepository repo) {
		msgRepo = repo;  // we are setting the static variable
	}

	// Store all socket session and their corresponding username.
	private static Map<String, Map<Session, User>> sessionUserMap = new Hashtable<>();
						//string is book ID
	private static Map<String, Map<User, Session>> userSessionMap = new Hashtable<>();

	private final Logger logger = LoggerFactory.getLogger(ChatSocket.class);

	@OnOpen
	public void onOpen(Session session, @PathParam("username") User user, @PathParam("groupID") int groupId)
      throws IOException {

		logger.info("Entered into Open");

    // store connecting user information
		sessionUserMap.put(session, user);
		userSessionMap.put(user, session);

		//Send chat history to the newly connected user
		sendMessageToPArticularUser(user, getChatHistory());
		
    // broadcast that new user joined
		String message = "User:" + user + " has Joined the Chat";
		broadcast(message);
	}


	@OnMessage
	public void onMessage(Session session, String message) throws IOException {

		/*
		Json{
			roomId
			Sender
			Message
		}
		 */


		// Handle new messages
		logger.info("Entered into Message: Got Message:" + message);
		User user = sessionUserMap.get(session);

    // Direct message to a user using the format "@username <message>"
//		if (message.startsWith("@")) {
//			User destUsername = message.split(" ")[0].substring(1);

      // send the message to the sender and receiver
//			sendMessageToPArticularUser(destUser, "[DM] " + user + ": " + message);
//			sendMessageToPArticularUser(user, "[DM] " + user + ": " + message);

//		}
//    else { // broadcast
//			broadcast(user + ": " + message);
//		}

		// Saving chat history to repository
		msgRepo.save(new Message(user, message));
	}


	@OnClose
	public void onClose(Session session) throws IOException {
		logger.info("Entered into Close");

    // remove the user connection information
		User user = sessionUserMap.get(session);
		sessionUserMap.remove(session);
		userSessionMap.remove(user);

    // broadcase that the user disconnected
		String message = user + " disconnected";
		broadcast(message);
	}


	@OnError
	public void onError(Session session, Throwable throwable) {
		// Do error handling here
		logger.info("Entered into Error");
		throwable.printStackTrace();
	}


	private void sendMessageToPArticularUser(User user, String message) {
		try {
			userSessionMap.get(user).getBasicRemote().sendText(message);
		} 
    catch (IOException e) {
			logger.info("Exception: " + e.getMessage().toString());
			e.printStackTrace();
		}
	}


	private void broadcast(String message) {
		sessionUserMap.forEach((session, username) -> {
			try {
				session.getBasicRemote().sendText(message);
			} 
      catch (IOException e) {
				logger.info("Exception: " + e.getMessage().toString());
				e.printStackTrace();
			}

		});

	}
	

  // Gets the Chat history from the repository
	private String getChatHistory() {
		List<Message> messages = msgRepo.findAll();
    
    // convert the list to a string
		StringBuilder sb = new StringBuilder();
		if(messages != null && messages.size() != 0) {
			for (Message message : messages) {
				sb.append(message.getUser() + ": " + message.getContent() + "\n");
			}
		}
		return sb.toString();
	}

} // end of Class
