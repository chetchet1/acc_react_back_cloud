package kr.co.seoulit.account.posting.business.to;

import kr.co.seoulit.account.operate.funds.to.NoteBean;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// 전표
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SLIP")
public class SlipBean extends BaseBean {

    @Id
    private String id;
    private String slipNo;
    private String accountPeriodNo;
    private String deptCode;
    private String slipType;
    private String expenseReport;
    private String authorizationStatus;
    private String postingDate;
    private String reportingEmpCode;
    private String reportingDate;
    private String approvalEmpCode;
    private String approvalDate;
    private String slipDescription;
    private String slipStatus;
    private String reportingEmpName;

    @Transient
    private String balanceDivision;
    @Transient
    private String positionCode;
    @Transient
    private String approvalEmpName;
    @Transient
    private String deptName;
    @Transient
    private ArrayList<JournalBean> journalBean;
//    @Transient
//    private ArrayList<JournalDeadlineDivsionBean> journalDeadline;
    @Transient
    private ArrayList<NoteBean> noteDetail;
}
