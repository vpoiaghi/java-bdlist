package start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// https://openclassrooms.com/fr/courses/4668056-construisez-des-microservices/5123565-documentez-votre-microservice-avec-swagger-2'

/**
 *
 */
@SpringBootApplication(scanBasePackages={"data", "front", "mappers", "services", "start", "utils"})
@EnableSwagger2
public class Start implements CommandLineRunner {

	
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
	}
}