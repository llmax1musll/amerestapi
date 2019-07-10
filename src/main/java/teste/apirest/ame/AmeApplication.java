package teste.apirest.ame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class AmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmeApplication.class, args);
		//System.out.println("oi");
	}
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "index";
	}

}
