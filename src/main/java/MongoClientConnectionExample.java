import com.mongodb.*;

// Official Documentation.

public class MongoClientConnectionExample {
    public MongoClientSettings settings;
    public MongoClientConnectionExample() {
        String uri = "YOUR_CONNECTION_STRING";
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        this.settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
    }

}