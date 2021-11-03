package acc.projman.springExamples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	@Bean
	public Car getCar() {
		
		return new Car(new Engine(), new Door(), new Tires());
	}
}
