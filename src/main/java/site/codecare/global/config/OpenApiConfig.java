package site.codecare.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPiConfig() {
        ArrayList<Server> servers = new ArrayList<>();
        servers.add(new Server().url("http://localhost:8010").description("Local Server"));

        //새로운 서버 url 추가하기
        servers.add(new Server().url("http://ip address:port").description("New Server"));

        return new OpenAPI()
                .info(new Info().title("My Service").description("My Service Description")
                        .license(new License().url("http://MyDomainLicence.com").name("My info"))
                        .contact(new Contact().name("contactName")
                                .email("myemail@gmail.com")
                                .url("http://contactDomain.com"))
                        .version("1.0.0"))
                .servers(servers);
    }
}