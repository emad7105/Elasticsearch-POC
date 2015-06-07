import java.time.Instant;

public class Tweet {
	
	public User user;
	public String message;
	public Instant timestamp;

	public Tweet(User user, String message, Instant timestamp) {
		this.user = user;
		this.message = message;
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
}
