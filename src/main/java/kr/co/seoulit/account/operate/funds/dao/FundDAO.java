package kr.co.seoulit.account.operate.funds.dao;

import kr.co.seoulit.account.operate.funds.to.GeneralFundBean;
import kr.co.seoulit.account.operate.funds.to.InoutBean;
import kr.co.seoulit.account.operate.funds.to.PlanBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface FundDAO {

    //당일 마지막 계좌번호 조회
    public String getPlanMaxNo(String today);

    //일자별 자금계획 조회
    public ArrayList<PlanBean> getDailyFundPlan(HashMap<String, Object> Data);

    public void updateDailyFundPlan(PlanBean planBean);

    //일일거래증감현황 조회
    public HashMap<String, Object> getDailyTradeStatus(HashMap<String, Object> param);

    //입출금예정액 조회
    public ArrayList<InoutBean> getInoutExpectedPrice(HashMap<String, String> data);

    //예적금현황 조회
    public HashMap<String, Object> getFinanceStatus(HashMap<String, Object> param);

    //총괄거래현황 조회
    public ArrayList<GeneralFundBean> getGeneralFundStatus(HashMap<String, String> param);
}
