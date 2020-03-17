package demo.code.api.graphql.configuration;

import demo.code.business.dto.BulletDto;
import demo.code.business.dto.CompanyDto;
import demo.code.business.dto.TextDto;
import demo.code.data.service.BulletService;
import demo.code.data.service.EntityService;
import demo.code.data.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"demo.code"} , exclude = JpaRepositoriesAutoConfiguration.class)
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
@EnableJpaRepositories("demo.code.data.repository")
@EntityScan("demo.code.data.model")
public class CodeDemoApplication extends SpringBootServletInitializer {

    private final EntityService entityService;
    private final TextService textService;
    private final BulletService bulletService;

    @Autowired
    public CodeDemoApplication(EntityService entityService, TextService textService, BulletService bulletService) {
        this.entityService = entityService;
        this.textService = textService;
        this.bulletService = bulletService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CodeDemoApplication.class, args);
    }

    // pre-populate data for demo
    @Bean
    ApplicationRunner init(EntityService entityService) {
        return args -> {
            entityService.saveEntity(new CompanyDto().setName("BHHC"));
            Optional<CompanyDto> company = entityService.getCompanyByName("BHHC");


            StringBuilder sb = new StringBuilder();
            sb.append("These are the reasons I'd like to work for ");
            sb.append(company.get().getName());
            sb.append(": ${bullet}");

            TextDto savingText = new TextDto();
            savingText.setText(sb.toString());
            savingText.setEntityId(company.get().getId());
            textService.saveText(savingText);

            List<TextDto> text = textService.getTextsByEntityId(company.get().getId());

            BulletDto bullet1 = new BulletDto().setGroupId(text.get(0).getId()).setBullet("Reason 1");
            bulletService.saveTextBullet(bullet1);

            BulletDto bullet2 = new BulletDto().setGroupId(text.get(0).getId()).setBullet("Reason 2");
            bulletService.saveTextBullet(bullet2);

            BulletDto bullet3 = new BulletDto().setGroupId(text.get(0).getId()).setBullet("Reason 3");
            bulletService.saveTextBullet(bullet3);
        };
    }
}