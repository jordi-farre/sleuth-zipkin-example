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

    @RequestMapping("/test")
    public String home() {
        String response = this.restTemplate.postForObject("https://httpbin.org/post", "testing", String.class);
        log.info(response);
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
