package kr.co.seoulit.account.settlement.financialstatements.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MonthIncomeBean {

    private String year;
    private String month;
    private String salesSummary;
    private String salesCostSummary;
    private String grossMargin;
    private String salesManageCostSummary;
    private String operatingProfit;
    private String nonOperatingProfitSummary;
    private String nonOperatingCostSummary;
    private String ordinaryProfit;
    private String corporateTaxSummary;
    private String netIncome;
}
