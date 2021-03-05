package com.sci.finalproject.myProject.controller;

import com.sci.finalproject.myProject.model.Coin;
import com.sci.finalproject.myProject.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CoinController {

    @Autowired
    private CoinService coinService;

    //TODO add other methods (read, update, delete) and modify HTML pages in accordance with new methods

    @RequestMapping(value="/admin/addCoin", method = RequestMethod.GET)
    public ModelAndView getCoinRegistration() {
        ModelAndView modelAndView = new ModelAndView();
        Coin coin = new Coin();
        modelAndView.addObject("coin", coin);
        modelAndView.setViewName("admin/addCoin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addCoin", method = RequestMethod.POST)
    public ModelAndView createNewCoin (@Valid Coin coin, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Coin coinExists = coinService.findCoinByName(coin.getCoinName());
        if (coinExists != null) {
            bindingResult
                    .rejectValue("coinName", "error.coin",
                            "Coin already registered!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/addCoin");
        } else {
            coinService.saveCoin(coin);
            modelAndView.addObject("successMessage", "Coin has been registered successfully");
            modelAndView.addObject("coin", new Coin());
            modelAndView.setViewName("admin/addCoin");

        }
        return modelAndView;
    }
}
