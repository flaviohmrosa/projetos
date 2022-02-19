package okdados.com.br.api_leinertex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiLeinertexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLeinertexApplication.class, args);

		int r = 20;
		int g = 99;
		int b = 155;
		String hex = String.format("#%02X%02X%02X", r, g, b);
		System.out.println(hex);

	}

}
