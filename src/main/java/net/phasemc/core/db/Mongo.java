package net.phasemc.core.db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import net.phasemc.core.Main;

public class Mongo {
    final ConnectionString connString = new ConnectionString(
            "mongodb+srv://"
                    + Main.getInstance().getConfig().getString("mongo.username")
                    + ":"
                    + Main.getInstance().getConfig().getString("mongo.password")
                    + "@"
                    + Main.getInstance().getConfig().getString("mongo.server")
                    + "/"
                    + Main.getInstance().getConfig().getString("mongo.database")
                    + "?w=majority"
    );
    final MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .retryWrites(true)
            .build();
    final MongoClient mongoClient = MongoClients.create(settings);
    final MongoDatabase database = mongoClient.getDatabase(Main.getInstance().getConfig().getString("mongo.database"));

    public void printDatabase() {
        System.out.println(database);
    }
}