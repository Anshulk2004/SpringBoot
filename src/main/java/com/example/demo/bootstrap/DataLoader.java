package com.example.demo.bootstrap;

import com.example.demo.repository.MarketJPARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final MarketJPARepository repository;

    public DataLoader(MarketJPARepository repository){
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (repository.count()>0){
            return;
        }
        repository.saveAll(List.of(
                new com.example.demo.entity.MarketEntity(null,"FSDF", 1232),
                new com.example.demo.entity.MarketEntity(null,"FSSD", 461),
                new com.example.demo.entity.MarketEntity(null,"RWWF", 8456),
                new com.example.demo.entity.MarketEntity(null,"BHUJ", 8986)
        ));

    }
}
