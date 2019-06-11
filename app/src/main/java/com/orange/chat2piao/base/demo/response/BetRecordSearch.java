package com.orange.chat2piao.base.demo.response;

import java.util.List;
import java.util.Map;

/**
 * "token_cd": "880d24e6-8dcf-44aa-a991-f9876eb86a23",
 * "BEGINTIME": "2016-01-01",
 * "ISPL": null,
 * "ENDTIME": "2017-07-18 00:00:00",
 * "MIR": [
 * {
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
 * }
 * ],
 * "STATE": {
 * "0": "正在写入",
 * "1": "正常",
 * "2": "已撤单",
 * "3": "已结算",
 * "4": "完成",
 * "5": "已派奖",
 * "6": "撤消派奖",
 * "7": "已作废",
 * "8": "已封盘"
 * },
 * "PAGE": {
 * "recourdCount": 59,
 * "ccPage": 1,
 * "startRecord": 0,
 * "endRecord": 59,
 * "count": 2,
 * "totalPage": 30
 * }
 * }
 * Created by Administrator on 2017/7/20.
 */

public class BetRecordSearch {
    public String token_cd;
    public String BEGINTIME;
    public List<BetRecord> MIR;
    public BetRecordPage PAGE;
    public Map<String, Double> SUM;
    public Allcount ALLCOUNT;


}
