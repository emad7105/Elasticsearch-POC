import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.*;

public class Main {

	public static void main(String[] args) {

		// on startup
		System.out.println("Starting up ...");
		
		Node node = nodeBuilder().node();
		Client client = node.client();
		

		// on shutdown
		System.out.println("Shutting down ...");
		node.close();
	}

}
