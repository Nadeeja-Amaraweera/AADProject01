package lk.ijse.AADAplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "lk.ijse.AADAplication.Entity")
public class AadAplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadAplicationApplication.class, args);
	}

}
