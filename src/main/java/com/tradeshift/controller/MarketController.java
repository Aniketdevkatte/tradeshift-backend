package com.tradeshift.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    @GetMapping("/quote/{symbol}")
    public Map<String, Object> quote(@PathVariable String symbol) {
        Map<String, Object> data = new HashMap<>();
        data.put("symbol", symbol.toUpperCase());
        data.put("price", 123.45);
        data.put("timestamp", System.currentTimeMillis());
        return data;
    }
}

