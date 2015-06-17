package be.heydari.elastic.nativeapi;


import be.heydari.elastic.Tweet;
import be.heydari.elastic.User;
import com.google.gson.Gson;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;


import java.time.Instant;

public class Twitter {
	private Gson mapper;
	private Client client;
	
	public Twitter(Client client){
		this.mapper = new Gson();
		this.client = client;
	}
	
	
	public IndexResponse indexTweet(Tweet tweet) {
		// Tweet to Json
		String json = mapper.toJson(tweet, Tweet.class);
		
		// Prepare the Sharding info
		String index = "twitter";
		String type = "tweet";
		String id = tweet.getId(); // can be null
		
		// Prepare for the Indexation
		IndexRequestBuilder indexRequestBuilder = client.prepareIndex(index, type, id);

		// Perform the Indexation
		return indexRequestBuilder.setSource(json).execute().actionGet();
	}
	
	public Tweet getTweet(String id) {
		// Request
		GetRequest gr = new GetRequest("twitter", "tweet", id);
		GetResponse response = client.get(gr).actionGet();
		
		// Response
		if (response.isExists()) {
			String json = response.getSourceAsString();
			return mapper.fromJson(json, Tweet.class);
		} else {
			return null;
		}
	}
	
	public void deleteTweet() {
		// TODO
	}
	
	public void getTweetsByUsers(User user) {
		// TODO
	}
	
	public void getTweetsByTime(Instant timestamp) {
		// TODO
	}
	
	public void searchTweetsBy(String searchKey) {
		// TODO
	}
	
}
