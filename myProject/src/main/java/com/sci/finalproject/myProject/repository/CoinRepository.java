package com.sci.finalproject.myProject.repository;

import com.sci.finalproject.myProject.model.Coin;
import com.sci.finalproject.myProject.model.CoinName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Integer> {
    Coin findCoinByCoinName (CoinName coinName);
}
