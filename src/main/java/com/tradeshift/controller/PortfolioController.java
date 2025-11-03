package com.tradeshift.controller;

import com.tradeshift.model.Portfolio;
import com.tradeshift.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/{userId}")
    public List<Portfolio> list(@PathVariable("userId") Long userId) {
        return portfolioService.getUserPortfolios(userId);
    }

    @PostMapping
    public Portfolio add(@RequestBody Portfolio p) {
        return portfolioService.savePortfolio(p);
    }
}
