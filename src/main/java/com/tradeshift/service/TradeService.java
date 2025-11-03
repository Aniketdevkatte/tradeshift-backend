
package com.tradeshift.service;

import com.tradeshift.model.Asset;
import com.tradeshift.model.Portfolio;
import com.tradeshift.repository.AssetRepository;
import com.tradeshift.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService {
    @Autowired private PortfolioRepository portfolioRepository;
    @Autowired private AssetRepository assetRepository;

    public String buy(Long portfolioId, String symbol, int qty, double price){
        Optional<Portfolio> p = portfolioRepository.findById(portfolioId);
        if (!p.isPresent()) {
            return "portfolio_not_found";
        }

        Asset a = new Asset();
        a.setSymbol(symbol);
        a.setQuantity(qty);
        a.setPrice(price);
        a.setPortfolio(p.get());
        assetRepository.save(a);
        // update portfolio totalValue simply (demo)
        double newTotal = p.get().getTotalValue() + qty * price;
        Portfolio port = p.get();
        port.setTotalValue(newTotal);
        portfolioRepository.save(port);
        return "bought";
    }
}
