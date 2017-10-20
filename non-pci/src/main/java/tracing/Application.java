package tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String home() {
        String response = this.restTemplate.getForObject("http://pci:8080/test", String.class);
        log.info(response);
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
