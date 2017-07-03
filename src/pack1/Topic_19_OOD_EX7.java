package pack1;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//Explain how you would design a chat server. In particular, provide details about the various backend components, 
//classes, and methods. What would be the hardest problems to solve?
class ChatServer {
	Set<User1> users = new HashSet<User1>();
	Set<Chat> chats=new HashSet<Chat>();
	void addUser(User1 u) {
		users.add(u);
	}
	
	void createChat(User1 from,User1 to){
		
	}
	void closeChat(Chat c){
		
	}

}

class Chat {
	User1 from, to;
	Message msg;
	void sendMessages(Message m){
		
	}
	void receiveMessage(String m){
		//connect to network
	}
	Chat(User1 from, User1 to) {
		this.from = from;
		this.to = to;
	}
}
enum availability{
	Online,Away,Offline
}
class User1 {
	String userId;
	Set<User1> friends = new HashSet<User1>();
	availability status;
	User1(String u) {
		userId = u;
	}

	void addFriends(User1 f) {
		friends.add(f);
	}

	void removeFriends(User1 e) {

	}
	void setStatus(availability sts){
		this.status=sts;
	}
	
}

class Message {
	Queue<String> msg;
	User1 Sender;

	void addMessage(String msg) {
		this.msg.add(msg);
	}
}

public class Topic_19_OOD_EX7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
