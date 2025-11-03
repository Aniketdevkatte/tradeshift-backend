package com.tradeshift.controller;

import com.tradeshift.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/buy")
    public Map<String, String> buy(@RequestBody Map<String, Object> body) {
        Long portfolioId = Long.valueOf(String.valueOf(body.get("portfolioId")));
        String symbol = String.valueOf(body.get("symbol"));
        int qty = Integer.parseInt(String.valueOf(body.get("quantity")));
        double price = Double.parseDouble(String.valueOf(body.get("price")));
        String res = tradeService.buy(portfolioId, symbol, qty, price);

        Map<String, String> response = new HashMap<>();
        response.put("status", res);
        return response;
    }
}
