package be.heydari.elastic.spring.users.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users", type = "user", shards = 1, replicas = 0, indexStoreType = "memory")
public class User {
	
	@Id
	private String username;
	
	@Version
	private Long version;


	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, Long version) {
		this.username = username;
		this.version = version;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (username != null ? !username.equals(user.username) : user.username != null) return false;
		if (version != null ? !version.equals(user.version) : user.version != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (version != null ? version.hashCode() : 0);
		return result;
	}
}
