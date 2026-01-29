package com.example.demo.repository;

import com.example.demo.model.Market;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MarketRepoImpl implements MarketRepo{

    private final List<Market> equities = new ArrayList<>();
//    private long id_sequence = 0;
    private final AtomicLong idSequence = new AtomicLong(0);

    public MarketRepoImpl() {
        saveEquity(new Market(0,"FSDF", 1232));
        saveEquity(new Market(0,"FSSD", 461));
        saveEquity(new Market(0,"RWWF", 8456));
        saveEquity(new Market(0,"BHUJ", 8986));
    }

    @Override
    public List<Market> getAllEquities() {
        return equities;
    }

    @Override
    public Market getEquityByid(long id) {
        for (Market m:equities) {
            if (m.id==id)
                return m;
        }
        return null;
    }

    @Override
    public Market saveEquity(Market saveEquity) {
        long id = idSequence.incrementAndGet();
//        id_sequence++;
        Market newM = new Market(id, saveEquity.equity,saveEquity.price);
        equities.add(newM);
        return newM;

    }
}