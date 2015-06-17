package be.heydari.elastic.nativeapi;


import be.heydari.elastic.Tweet;
import com.google.gson.Gson;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Instant;

public class Twitter_IT extends TwitterIntegration {

	@After
	public void _cleanup() {
		cleanup();
	}
	
	@Test
	public void indexTweet() {
		Tweet tweet = Mocks.tweet("1");
		IndexResponse response = twitter.indexTweet(tweet);

		assertNotNull(response);
		assertNotNull(response.getId());
		assertNotNull(response.getIndex());
		assertNotNull(response.getType());
		assertNotNull(response.getVersion());
	}

	@Test
	public void fetchTweet() {
		Tweet tweet = Mocks.tweet("2");
		
		// index using native api
		IndexRequest request = new IndexRequest("twitter", "tweet", tweet.getId());
		request.source(new Gson().toJson(tweet));
		esClient().index(request).actionGet();

		Tweet fetchedTweet = twitter.getTweet(tweet.getId());
		
		assertNotNull(fetchedTweet);
		assertEquals(tweet, fetchedTweet);
	}
	
	
	public static class Mocks {
		public static Tweet tweet() {
			return  new Tweet(
					"1",
					"2",
					"My name is Heisenberg",
					Instant.now()
			);
		}

		public static Tweet tweet(String id) {
			return  new Tweet(
					id,
					"2",
					"My name is Heisenberg",
					Instant.now()
			);
		}
	}
}
