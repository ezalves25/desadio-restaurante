package br.com.desafio.msdesafio.config;

import br.com.desafio.msdesafio.MsDesafioApplication;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.com.desafio.msdesafio"})
public class AppSwaggerConfig {


    @Bean

    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Service Desafio Restaurante")
                        .description("Desafio Restaurante")
                        .version(MsDesafioApplication.getBuildPropertiesStatic().getVersion())
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("OpenAPI Specification")
                        .url("https://swagger.io/specification/"));
    }


}
