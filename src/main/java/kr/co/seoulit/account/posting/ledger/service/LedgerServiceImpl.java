package kr.co.seoulit.account.posting.ledger.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.mapper.AccountSubjectMapper;
import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.ledger.mapper.*;
import kr.co.seoulit.account.posting.ledger.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;

@Service
@Transactional
public class LedgerServiceImpl implements LedgerService {

	@Autowired
    private JournalEntryMapper journalEntryDAO;
	@Autowired
    private AuxiliaryLedgerMapper auxiliaryLedgerDAO;
	@Autowired
    private AssistantLedgerMapper assistantLedgerDAO;
	@Autowired
	private FixedAssetMapper fixedAssetMapper;
	@Autowired
	private FixedAssetDetailMapper fixedAssetDetailMapper;
	@Autowired
	private AccountSubjectMapper accountSubjectMapper;
	@Autowired
	private GeneralLedgerMapper generalLedgerMapper;


	@Override
	public ArrayList<GeneralLedgerBean> findGeneralAccountLedgerList(HashMap<String , Object> map){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");System.out.println(map);System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		return generalLedgerMapper.selectGeneralAccountLedgerList(map);
	}


	public ArrayList<AccountBean> currentAssetCode(){
		return accountSubjectMapper.selectCurrentAssetList();
	}


    @Override
	public ArrayList<CashJournalBean> findTotalCashJournal(String year, String account) {

        	ArrayList<CashJournalBean> cashJournalList = null;
        	HashMap<String, String> map = new HashMap<String, String>();
        	map.put("year", year);
        	map.put("account", account);
        	cashJournalList = auxiliaryLedgerDAO.selectTotalCashJournalList(map);

        return cashJournalList;
	}

	@Override
	public ArrayList<CashJournalBean> findCashJournal(String fromDate, String toDate) {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
        	ArrayList<CashJournalBean> cashJournalList = null;
        	cashJournalList = auxiliaryLedgerDAO.selectCashJournalList(map);

        return cashJournalList;
	}

	@Override
	public ArrayList<GeneralLedgerBean> findAccountLedger(String fromDate, String toDate, String accountCode){

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate",fromDate);
		map.put("toDate",toDate);
		map.put("accountCode", accountCode);
		ArrayList<GeneralLedgerBean> generalLedgerList = null;
		generalLedgerList = generalLedgerMapper.selectAccountLedger(map);

		return generalLedgerList;
	}

	@Override
    public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate) {

        	ArrayList<JournalBean> journalList = null;
        	journalList = journalEntryDAO.selectRangedJournalList(fromDate, toDate);

        return journalList;
    }

	@Override
    public ArrayList<JournalDetailBean> findJournalDetailList(String journalNo) {

        	ArrayList<JournalDetailBean> journalDetailBeans = null;
        	journalDetailBeans = journalEntryDAO.selectJournalDetailList(journalNo);

        return journalDetailBeans;
    }

	@Override
	public ArrayList<AssetBean> findAssetList() {


        	ArrayList<AssetBean> assetBean = null;
        	assetBean = assistantLedgerDAO.selectAssetList();

        return assetBean;
	}

	@Override
	public ArrayList<AssetItemBean> findAssetItemList(String parentsCode) {

        	ArrayList<AssetItemBean> assetBean = null;
        	assetBean = assistantLedgerDAO.selectAssetItemList(parentsCode);

        return assetBean;
	}

	public ArrayList<AssetItemBean> findAssetDta(String parentsCode){
		ArrayList<AssetItemBean> assetBean = null;
		assetBean = assistantLedgerDAO.selectAssetDta(parentsCode);
		return assetBean;
	}

	@Override
	public ArrayList<DeptBean> findDeptList(){

        	ArrayList<DeptBean> DeptBean = null;
        	DeptBean = assistantLedgerDAO.selectDeptList();

        return DeptBean;
	}

	@Override
	public void assetStorage(HashMap<String, Object> map) {

			if(map.get("previousAssetItemCode").equals("CREATE")) {
				assistantLedgerDAO.createAssetItem(map);
			}
			else {
				assistantLedgerDAO.updateAssetItem(map);
			}

	}

	@Override
	public void removeAssetItem(String assetItemCode) {

			assistantLedgerDAO.removeAssetItem(assetItemCode);

	}

	//고정자산 목록
	public ArrayList<FixedAssetBean> findFixedAssetList(String accountCode , String accountName){

		ArrayList<FixedAssetBean> findFixedAssetList = fixedAssetMapper.selectFixedAssetList(accountCode , accountName);
		return findFixedAssetList;
	}

	//고정자산 추가
	@Override
	public void insertFixedAsset(FixedAssetBean fixedAssetBean) {

		HashMap<String, Object> params = new HashMap<>();
		params.put("accountCode", fixedAssetBean.getAccountCode());
		params.put("accountName", fixedAssetBean.getAccountName());
		params.put("assetCode", fixedAssetBean.getAssetCode());
		params.put("assetName", fixedAssetBean.getAssetName());
		params.put("acqDate", fixedAssetBean.getAcqDate());
		params.put("compStatus", fixedAssetBean.getCompStatus());
		params.put("fixedAssetDetailBean", fixedAssetBean.getFixedAssetDetailBean());

		for (FixedAssetDetailBean detailBean : fixedAssetBean.getFixedAssetDetailBean()) {
			params.put("assetCode", detailBean.getAssetCode());
			params.put("acqCost", detailBean.getAcqCost());
			params.put("depMethod", detailBean.getDepMethod());
			params.put("initAccDepreciation", detailBean.getInitAccDepreciation());
			params.put("prevBookValue", detailBean.getPrevBookValue());
			params.put("usefulLife", detailBean.getUsefulLife());
			params.put("depCompYear", detailBean.getDepCompYear());
			params.put("dept", detailBean.getDept());
			params.put("acqQty", detailBean.getAcqQty());
			params.put("incDecQty", detailBean.getIncDecQty());
			params.put("remQty", detailBean.getRemQty());
			params.put("depRate", detailBean.getDepRate());
			params.put("month", detailBean.getMonth());
			params.put("genDepExpense", detailBean.getGenDepExpense());
			params.put("currAccDepreciation", detailBean.getCurrAccDepreciation());
			params.put("currBookValue", detailBean.getCurrBookValue());
		}

		fixedAssetDetailMapper.insertFixedAssetDetail(params);
		fixedAssetMapper.insertFixedAsset(params);
	}

	//감가상각현황 전체조회
	public ArrayList<FixedAssetBean> depreciationList(){
		System.out.println("serviceImpl!!!@@@@@@");
		return fixedAssetMapper.depreciationList();
	}

	//감가상각현황 조건조회
	public ArrayList<FixedAssetBean> selectedDepreciationList(String accountCode){
		return fixedAssetMapper.selectedDepreciationList(accountCode);
	}

	public ArrayList<FixedAssetBean> fixedAssetLedgerList(){
		return fixedAssetMapper.fixedAssetLedgerList();
	}


}
