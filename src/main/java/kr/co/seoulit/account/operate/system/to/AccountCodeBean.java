package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class AccountCodeBean extends BaseBean{

    private String accountLevel;
    private String leaf;
    private String accountInnerCode;
    private String parentAccountInnerCode;
    private String accountCode;
    private String accountCharacter;
    private String accountName;
    private String accountDisPlayNameWithCode;
    private String accountDisplayName;
    private String accountDivision;
    private String accountUseCheck;
    private String accountDescription;
    private String groupCode;
    private String target;
    private String fixedAssets;
}
