package kr.co.seoulit.account.sys.base.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERIOD")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class PeriodEntity {
    @Id
    private String accountPeriodNo;
    private String periodStartDate;
    private String periodEndDate;
    private String workplaceCode;
}
