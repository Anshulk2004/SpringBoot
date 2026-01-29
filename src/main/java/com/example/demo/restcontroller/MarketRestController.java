package com.example.demo.restcontroller;

import com.example.demo.model.Market;
import com.example.demo.service.MarketServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/market/1.0")
public class MarketRestController {

    private final MarketServiceImpl marketService;

    public MarketRestController(MarketServiceImpl marketService) {
        this.marketService = marketService;
    }


    @GetMapping("/hello")
    public String welcome(){
        return "Hello from Spring Boot day 02";
    }


    @GetMapping("/equities")
    public List<Market> getEquities(){
        return marketService.getAllEquities();
    }

    @GetMapping("/equities/{equity_id}")
    public Market getEquityById(@PathVariable long equity_id){
        return marketService.getEquityByid(equity_id);
    }

    @PostMapping("/equities")
    public Market addNewEquity(@RequestBody Market m){
        return marketService.saveEquity(m);

    }
    @PutMapping("/equities/{id}")
    public Market updateEquity(@PathVariable long id, @RequestBody Market m){
        return marketService.updateEquity(id, m);
    }

    @DeleteMapping("/equities/{id}")
    public void deleteEquityById(@PathVariable long id){
        marketService.deleteEquityById(id);
    }
}