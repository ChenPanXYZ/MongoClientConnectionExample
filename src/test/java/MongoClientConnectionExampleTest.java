import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoClientConnectionExampleTest {

    private MongoClientConnectionExample mongoClientConnectionExample;

    @Before
    public void setUp() {
        mongoClientConnectionExample = new MongoClientConnectionExample();
    }

    @Test
    public void testConnection() {
        // Create a new client and connect to the server
        String message = "Connection is not setup correct.";
        try (MongoClient mongoClient = MongoClients.create(mongoClientConnectionExample.settings)) {
            MongoDatabase database = mongoClient.getDatabase("student-management-system-api");
            try {
                // read the collections "welcome".
                MongoCollection<Document> collection = database.getCollection("welcome");
                // Read the first document from the collection.
                Document myDoc = collection.find().first();
                // get "message" field from the document.
                message =  myDoc.getString("message");
            }
            catch (MongoException me) {
                System.err.println(me);
            }
        }
        assertEquals("Hello World!", message);
    }
}