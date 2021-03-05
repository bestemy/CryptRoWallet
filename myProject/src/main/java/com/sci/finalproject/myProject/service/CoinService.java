package com.sci.finalproject.myProject.service;

import com.sci.finalproject.myProject.model.Coin;
import com.sci.finalproject.myProject.model.CoinName;
import com.sci.finalproject.myProject.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {
    public CoinRepository coinRepository;

    @Autowired
    public CoinService (CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    public Coin findCoinByName (CoinName coinName) {
        return coinRepository.findCoinByCoinName(coinName);
    }

    public Coin saveCoin (Coin coin) {
        return coinRepository.save(coin);
    }
}
