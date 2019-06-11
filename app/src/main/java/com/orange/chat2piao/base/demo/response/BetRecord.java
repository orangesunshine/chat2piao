package com.orange.chat2piao.base.demo.response;

import java.io.Serializable;

/**
 * "playtypename": "三星直选",
 * "selfBonusMoney": 39,
 * "winmoney": 1800,
 * "issueno": "20170512-083",
 * "betmoneytotal": 500,
 * "bettypename": "后三直选复式",
 * "gametypename": "重庆时时彩",
 * "betdt": 1494589771000,
 * "uniqueness": "9b7dca692f33dbda0b66f8f39e0ea72b_462_1",
 * "ordernumber": "1494589771654892",
 * "id": 462,
 * "state": "4",
 * "nums": "0,1,2,3,4,"
 * Created by Administrator on 2017/7/20.
 */

public class BetRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    public String tittleDate;
    public double tittleBetmoneytotal;
    public int id;
    public String playtypename;
    public double selfBonusMoney; //返点金额

    public double winmoney; //中奖金额
    public boolean isKg = false;
    public String issueno;

    public double betmoneytotal; //投注金额

    public String bettypename;


    public String gametypename;

    public long betdt;

    public String ordernumber;

    public String state;
    public String state2;

    public String nums;
    public String uniqueness;
    int ItemType = 0;
    public int betCount;
    public int multiple = 1;
    public double scale;//奖金
    public String digit;//位置
    public double bonus;//赔率
    public double winCount;//中奖注数
    public double betMoney;//单注金额
    public String lotterynum;//开奖号码

    @Deprecated
    public static String getStateString(int state) {
        String s = null;
        switch (state) {
            case 0:
                s = "正在写入";
                break;
            case 1:
                s = "正常";
                break;
            case 2:
                s = "已撤单";
                break;
            case 3:
                s = "已结算";
                break;
            case 4:
                s = "完成";
                break;
            case 5:
                s = "已派奖";
                break;
            case 6:
                s = "撤消派奖";
                break;
            case 7:
                s = "已作废";
                break;
            case 8:
                s = "已封盘";
                break;
        }
        return s;
    }

    @Deprecated
    public static String getKGStateString(int state) {
        String s = null;
        switch (state) {
            case 0:
                s = "正在写入";
                break;
            case 1:
                s = "正常";
                break;
            case 2:
                s = "已完成";
                break;
            case 3:
                s = "完成";
                break;
            case 4:
                s = "完成";
                break;
            case 5:
                s = "已派奖";
                break;
            case 6:
                s = "撤消派奖";
                break;
            case 7:
                s = "已作废";
                break;
            case 8:
                s = "已封盘";
                break;
        }
        return s;
    }

    public void setItemType(int itemType) {
        ItemType = itemType;
    }
}
