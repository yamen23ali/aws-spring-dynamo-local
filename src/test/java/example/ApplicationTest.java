package example;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.amazonaws.services.dynamodbv2.local.embedded.DynamoDBEmbedded;
import com.amazonaws.services.dynamodbv2.local.shared.access.AmazonDynamoDBLocal;

@RunWith( MockitoJUnitRunner.class )
public class ApplicationTest
{
	 @Test
	 public void testCreateCart()
	 {
		 AmazonDynamoDBLocal dd = DynamoDBEmbedded.create();
		 System.out.println( dd.listTables() );
		 
		 assertTrue( "Not detecting if cancellation is permitted", true );
	 }
}
