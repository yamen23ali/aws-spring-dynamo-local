package example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.almworks.sqlite4java.SQLite;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;

@Configuration
public class DynamoDbConfiguration
{
    DynamoDBProxyServer server;

    AmazonDynamoDB dynamodb;

    @PostConstruct
    public void init()
        throws Exception
    {
    	
        Integer dynamoDbPort = 8000;

        final String[] localArgs = { "-inMemory", "-port", String.valueOf( dynamoDbPort ) };
        // final String[] localArgs = { "-inMemory"};
        DynamoDBProxyServer server = ServerRunner.createServerFromCommandLineArgs( localArgs );
        server.start();
        BasicAWSCredentials credentials = new BasicAWSCredentials( "dontCare", "dontCare" );
        dynamodb = new AmazonDynamoDBClient( credentials );
        dynamodb.setEndpoint( "http://localhost:" + String.valueOf( dynamoDbPort ) );
        
        System.out.println( dynamodb.listTables() );
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB()
    {
        return dynamodb;
    }

    @PreDestroy
    public void shutdown()
        throws Exception
    {
        if ( null != server )
        {
            server.stop();
        }
    }
}