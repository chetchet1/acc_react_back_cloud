package kr.co.seoulit.account.budget.formulation.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class BudgetProductPK implements Serializable {

    private String accountInnerCode;
    private String accountPeriodNo;
    private String budgetingCode;
    private String deptCode;
    private String workplaceCode;

}
