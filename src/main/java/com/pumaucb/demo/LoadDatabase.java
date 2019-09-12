package com.pumaucb.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BusRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Bus("Pumakatari", "123ABC", "50","Juan Perez")));
            log.info("Preloading " + repository.save(new Bus("Chikitiki", "456DEF","30","Marcos Gutierrez")));
        };
    }
}
