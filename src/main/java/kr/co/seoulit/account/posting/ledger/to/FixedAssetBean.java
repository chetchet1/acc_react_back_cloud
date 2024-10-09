package kr.co.seoulit.account.posting.ledger.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Transient;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = false)
@Data
public class FixedAssetBean {

        private String accountCode;
        private String accountName;
        private String assetCode;
        private String assetName;
        private String acqDate;
        private String compStatus;
        private String checkStatus;
        private ArrayList<FixedAssetDetailBean> fixedAssetDetailBean;

        @Transient
        private String acqCost;
        @Transient
        private String initAccDepreciation;
        @Transient
        private String prevBookValue;
        @Transient
        private String genDepExpense;
        @Transient
        private String currAccDepreciation;
        @Transient
        private String currBookValue;
        @Transient
        private String acqQty;
        @Transient
        private String incDecQty;
        @Transient
        private String remQty;
}
