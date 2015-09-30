package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration( exclude = { ErrorMvcAutoConfiguration.class } )
@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        final ConfigurableApplicationContext springContext = SpringApplication.run( Application.class, args );

        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            public void run()
            {
                // shutdown application
                // LOG.info("Shutting down spring context");
                springContext.close();

                // shutdown log4j2
                if ( LogManager.getContext() instanceof LoggerContext )
                {
                    // logger.info("Shutting down log4j2");
                    Configurator.shutdown( (LoggerContext) LogManager.getContext() );
                }
                else
                {
                    // logger.warn("Unable to shutdown log4j2");
                }
            }
        } );
    }
}
