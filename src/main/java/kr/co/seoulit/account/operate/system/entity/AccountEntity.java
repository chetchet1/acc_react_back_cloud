package kr.co.seoulit.account.operate.system.entity;

import kr.co.seoulit.account.operate.system.to.AccountControlBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountEntity {
    @Id
    private String accountInnerCode;

    private String parentAccountInnerCode;
    private String accountCode;
    private String accountCharacter;
    private String accountName;
    private String accountDisplayNameWithCode;
    private String accountDisplayName;
    private String accountDivision;
    private String accountUseCheck;
    private String accountDescription;
    private String groupCode;
    private String editable;
    private String target;
    private String budget;

//    private ArrayList<AccountControlBean> accountControlList;
}
