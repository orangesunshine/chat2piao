package com.orange.chat2piao.base.demo.response;

public class Allcount {
    private double selfBonusMoney;
    private double winmoney;
    private double betmoneytotal=0.000;

    public double getSelfBonusMoney() {
        return selfBonusMoney;
    }

    public void setSelfBonusMoney(double selfBonusMoney) {
        this.selfBonusMoney = selfBonusMoney;
    }

    public double getWinmoney() {
        return winmoney;
    }

    public void setWinmoney(double winmoney) {
        this.winmoney = winmoney;
    }

    public double getBetmoneytotal() {
        return betmoneytotal;
    }

    public void setBetmoneytotal(double betmoneytotal) {
        this.betmoneytotal = betmoneytotal;
    }
}
