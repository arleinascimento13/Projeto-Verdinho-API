package org.projetoverdinho.projetoverdinhoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@Profile("dev")
public class ProjetoVerdinhoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoVerdinhoApiApplication.class, args);
    }


}
