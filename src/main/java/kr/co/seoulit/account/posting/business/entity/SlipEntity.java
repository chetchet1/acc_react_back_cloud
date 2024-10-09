package kr.co.seoulit.account.posting.business.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "slip")
@Data
@EqualsAndHashCode(callSuper = false)
public class SlipEntity {
    @Id
    private Long slipNo;
    private String accountPeriodNo;
    private String deptCode;
    private String slipType;
    private String expenseReport;
    private String reportingEmpCode;
    private String reportingDate;
    private String approvalEmpCode;
    private String approvalDate;
    private String slipStatus;

//    private String deptName;
//    private String id;
//    private String authorizationStatus;
//    private String reportingEmpName;
//    private String balanceDivision;
//    private String positionCode;
}
