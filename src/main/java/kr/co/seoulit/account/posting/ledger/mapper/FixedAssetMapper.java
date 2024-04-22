package kr.co.seoulit.account.posting.ledger.mapper;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.ledger.to.FixedAssetBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface FixedAssetMapper {
    public ArrayList<FixedAssetBean> selectFixedAssetList(String accountCode, String accountName);

    //고정자산 추가
    void insertFixedAsset(HashMap<String, Object> fixedAssetBean);

    ArrayList<FixedAssetBean> depreciationList();

    ArrayList<FixedAssetBean> selectedDepreciationList(String accountCode);

    ArrayList<FixedAssetBean> fixedAssetLedgerList();
}
