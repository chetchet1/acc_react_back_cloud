package kr.co.seoulit.account.operate.humanresource.entity;

import kr.co.seoulit.account.budget.formulation.entity.BudgetProductPK;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@IdClass(DepartmentPK.class)
public class DepartmentEntity {
    @Id
    private String workplaceCode;
    @Id
    private String deptCode;
    private String workplaceName;
    private String deptName;
    private String companyCode;
    private String deptStartDate;
    private String deptEndDate;
}
