package poly.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class DaTotNghiepApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaTotNghiepApplication.class, args);
	}
	// cocw chế mã hóa mất  khẩu
		@Bean
		public BCryptPasswordEncoder getPasswordEncoder() {
	      return new BCryptPasswordEncoder();		
		}
}
