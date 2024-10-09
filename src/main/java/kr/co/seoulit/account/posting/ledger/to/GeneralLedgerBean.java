package kr.co.seoulit.account.posting.ledger.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GeneralLedgerBean {
    private String reportingDate;
    private String accountName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private String customerName;
    private String expenseReport;
}
