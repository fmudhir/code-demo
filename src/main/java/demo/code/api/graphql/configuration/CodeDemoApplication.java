package demo.code.api.graphql.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"demo.code"} , exclude = JpaRepositoriesAutoConfiguration.class)
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
@EnableJpaRepositories("demo.code.data.repository")
@EntityScan("demo.code.data.model")
public class CodeDemoApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CodeDemoApplication.class, args);
    }

}