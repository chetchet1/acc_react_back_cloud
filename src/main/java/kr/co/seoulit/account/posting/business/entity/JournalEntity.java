package kr.co.seoulit.account.posting.business.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Journal")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class JournalEntity {
    @Id
    private String journalNo;
    private String slipNo;
    private String balanceDivision;
    private String accountInnerCode;
    private String customerCode;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
}
