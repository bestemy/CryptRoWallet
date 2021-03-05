package com.sci.finalproject.myProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coin_id")
    private int id;

    @Enumerated(EnumType.STRING)
//    @NaturalId
    @Column(name = "coin_name")
    @NotEmpty(message = "*Please provide a coin name")
    private CoinName coinName;

    @Column(name = "usd_price")
    @NotEmpty(message = "*Please provide an USD price")
    private Double usdPrice;

    @Column(name = "eur_price") //ctrl+shift+u lowercase to uppercase
    @NotEmpty(message = "*Please provide an EUR price")
    private Double eurPrice;

    @Column(name = "ron_price")
    @NotEmpty(message = "*PPlease provide a RON price")
    private Double ronPrice;

    @Column(name = "one_day_fluctuation_percentage")
    @NotEmpty(message = "*Please provide a 24H fluctuation")
    private Float oneDayFluctuation;

    @Column(name = "one_week_fluctuation_percentage")
    @NotEmpty(message = "*Please provide a 7D fluctuation")
    private Float oneWeekFluctuation;

    @Column(name = "market_cap_usd")
    @NotEmpty(message = "*Please provide a market cap")
    private Long marketCap;

    @Column(name = "volume_usd")
    @NotEmpty(message = "*Please provide a volume")
    private Long volume;
}
