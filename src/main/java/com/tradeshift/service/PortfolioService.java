
package com.tradeshift.service;

import com.tradeshift.model.Portfolio;
import com.tradeshift.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {
    @Autowired private PortfolioRepository portfolioRepository;

    public List<Portfolio> getUserPortfolios(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }

    public Portfolio savePortfolio(Portfolio p) {
        return portfolioRepository.save(p);
    }
}
