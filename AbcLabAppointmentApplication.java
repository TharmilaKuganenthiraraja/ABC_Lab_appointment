package ABC_Lab_appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= "ABC_Lab_appointment")
public class AbcLabAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcLabAppointmentApplication.class, args);
	}

}
