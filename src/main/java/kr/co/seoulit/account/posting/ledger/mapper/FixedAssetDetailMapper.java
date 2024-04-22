package kr.co.seoulit.account.posting.ledger.mapper;

import kr.co.seoulit.account.posting.ledger.to.FixedAssetDetailBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface FixedAssetDetailMapper {

//    public FixedAssetDetailBean selectAssetDetail(String assetCode);

        void insertFixedAssetDetail(HashMap<String, Object> fixedAssetDetailBean);
}
