package kr.co.seoulit.account.operate.funds.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Id;

@EqualsAndHashCode(callSuper = false)
@Data
public class NoteSpecBean extends BaseBean {
    @Id
    private String noteNo;
    private String customerCode;
    private String customerName;
    private String notePrice;
    private String maturityDate;
    private String showDetails;
}
