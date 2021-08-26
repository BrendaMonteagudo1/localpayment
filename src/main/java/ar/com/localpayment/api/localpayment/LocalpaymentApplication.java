package ar.com.localpayment.api.localpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"controller","repos"})
public class LocalpaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalpaymentApplication.class, args);
	}

}
