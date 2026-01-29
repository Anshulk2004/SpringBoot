package com.example.demo.service;

import com.example.demo.model.Market;
import com.example.demo.repository.MarketJPARepository;
import com.example.demo.repository.MarketRepoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {

//    private final MarketRepoImpl repository;
    private final MarketJPARepository repository;

    public MarketServiceImpl(MarketJPARepository repository) {
        this.repository = repository;
    }

//    public MarketServiceImpl(MarketRepoImpl repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Market> getAllEquities() {
//        return repository.getAllEquities();
        return repository.findAll().stream().map(entity ->
                new Market(entity.getId(), entity.getEquity(), entity.getPrice())
        ).toList();
    }

    @Override
    public Market getEquityByid(long id) {
//        return repository.getEquityByid(id);
        return repository.findById(id)
                .map(entity -> new Market(entity.getId(), entity.getEquity(), entity.getPrice()))
                .orElse(null);
    }

    @Override
    public Market saveEquity(Market saveEquity) {
//        return repository.saveEquity(saveEquity);
        var entity = new com.example.demo.entity.MarketEntity();
        entity.setEquity(saveEquity.equity);
        entity.setPrice(saveEquity.price);
        var savedEntity = repository.save(entity);
        return new Market(savedEntity.getId(), savedEntity.getEquity(), savedEntity.getPrice());
    }
}