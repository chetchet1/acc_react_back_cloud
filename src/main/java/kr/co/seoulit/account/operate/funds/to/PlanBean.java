package kr.co.seoulit.account.operate.funds.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper=false)
@Entity
@Data
@Table(name = "DAILY_FUND_PLAN")
public class PlanBean extends BaseBean {

    @Id
    private String planNo;
    private String planDate;
    private String fundCode;
    private String fundName;
    private String customerCode;
    private String customerName;
    private String expenseReport;
    private String balanceDivision;
    private String price;
}
