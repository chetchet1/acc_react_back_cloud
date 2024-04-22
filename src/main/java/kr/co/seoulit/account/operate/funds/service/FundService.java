package kr.co.seoulit.account.operate.funds.service;

import kr.co.seoulit.account.operate.funds.to.InoutBean;
import kr.co.seoulit.account.operate.funds.to.PlanBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface FundService {

    //일자별자금계획 추가
    String registerPlan(PlanBean planBean);

    //일자별자금계획 조회
    HashMap<String, ArrayList<PlanBean>> getDailyFundPlan(String startDate, String endDate);

    //일자별자금계획 수정
    void updateDailyFundPlan(PlanBean planBean);

    //일자별자금계획 삭제
    void deleteDailyFundPlan(String planNo);

    //일일거래증감현황 조회
    HashMap<String, Object> getDailyTradeStatus(String date);

    //입출금예정액 조회
    HashMap<String, ArrayList<InoutBean>> getInoutExpectedPrice(String date);

    //예적금현황 조회
    HashMap<String, Object> getFinanceStatus(String date, String accountName);

    //총괄거래현황 조회
    HashMap<String, Object> getGeneralFundStatus(String startDate, String endDate);
}
