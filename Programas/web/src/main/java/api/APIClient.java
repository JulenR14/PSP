package api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

public class APIClient {

    public class ConsumingRestApplication {

        private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

        public static void main(String[] args) {
            SpringApplication.run(ConsumingRestApplication.class, args);
        }

        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }

        @Bean
        public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
            return args -> {
                RestTemplate quote = restTemplate.getForObject(
                        "http://localhost:8080/product", RestTemplate.class);
                log.info(quote.toString());
            };
        }
    }
}
