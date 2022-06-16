package Test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/pqr")
	public String sayHello() {
		return "<h2> Welcome to spring Boot </h2>";
	}

}
