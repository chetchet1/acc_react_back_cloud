package kr.co.seoulit.account.posting.ledger.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FixedAssetDetailBean {
    private String assetCode;
    private String acqCost;
    private String depMethod;
    private String initAccDepreciation;
    private String prevBookValue;
    private String usefulLife;
    private String depCompYear;
    private String dept;
    private String acqQty;
    private String incDecQty;
    private String remQty;
    private String depRate;
    private String month;
    private String genDepExpense;
    private String currAccDepreciation;
    private String currBookValue;
}
