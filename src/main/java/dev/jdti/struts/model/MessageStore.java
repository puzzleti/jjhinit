package dev.jdti.struts.model;

public class MessageStore {

	private String message;

	public MessageStore() {
		super();
		this.message = "hello sruts user";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageStore [message=" + message + "]";
	}

}
