package kr.co.seoulit.account.operate.funds.to;


import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="NOTE")
public class NoteBean extends BaseBean{
    @Id
    private String noteNo;
    private String journalNo;
    private String noteType;
    private String accountInnerCode;
    private String drawer;
    private String endorser;
    private String drawee;
    private String issuanceDate;
    private String maturityDate;
    @Transient
    private String slipNo;
    @Transient
    private String approvalEmpCode;
    @Transient
    private String expenseReport;
    @Transient
    private String customerName;
    @Transient
    private String customerCode;
    @Transient
    private String notePrice;
    @Transient
    private String id;
}
