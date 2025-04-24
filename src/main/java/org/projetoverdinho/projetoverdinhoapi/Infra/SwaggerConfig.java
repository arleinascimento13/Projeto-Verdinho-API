package org.projetoverdinho.projetoverdinhoapi.Infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Verdinho API")
                        .description("Documentação da API relacionada a geração de ocorrências")
                        .version("v1"));
    }
}