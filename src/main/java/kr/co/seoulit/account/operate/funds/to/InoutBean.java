package kr.co.seoulit.account.operate.funds.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class InoutBean extends BaseBean {

    private String accountName;
    private String expenseReport;
    private String price;
}
