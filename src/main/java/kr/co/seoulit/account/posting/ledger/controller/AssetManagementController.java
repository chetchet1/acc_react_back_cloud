package kr.co.seoulit.account.posting.ledger.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.ledger.to.FixedAssetBean;
import kr.co.seoulit.account.posting.ledger.to.FixedAssetDetailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.to.AssetBean;
import kr.co.seoulit.account.posting.ledger.to.AssetItemBean;
import kr.co.seoulit.account.posting.ledger.to.DeptBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class AssetManagementController{

	@Autowired
    private LedgerService ledgerService;



	// ================================ 고정자산 추가============================

	//고정자산분류
	@GetMapping("/assetList")
	public ArrayList<AssetBean> assetList() {

        	ArrayList<AssetBean> AssetList = ledgerService.findAssetList();
			System.out.println("AssetList = " + AssetList);
        	return AssetList;
    }


	//고정자산 목록
	@GetMapping ("/findFixedAssetList")
	public HashMap<String , Object> findFixedAssetList(@RequestParam("accountCode") String accountCode,
													   @RequestParam("accountName") String accountName
														 ) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("findFixedAssetList", ledgerService.findFixedAssetList(accountCode, accountName));
		System.out.println("accountCode = " + accountCode);
		System.out.println("accountName = " + accountName);
		return map;
	}

	//고정자산추가
	@PostMapping("/addFixedAsset")
    public void insertFixedAsset(@RequestBody FixedAssetBean fixedAssetBean){
		System.out.println("fixedAssetBean = " + fixedAssetBean);
		ledgerService.insertFixedAsset(fixedAssetBean);
    }

	//감가상각현황 전체조회
	@GetMapping("/getDepreciationList")
	public ArrayList<FixedAssetBean> depreciationList(){
		return ledgerService.depreciationList();
	}

	//감가상각현황 조건조회

	@GetMapping("/selectedDepreciationList")
	public ArrayList<FixedAssetBean> selectedDepreciationList(@RequestParam("accountCode") String accountCode){
		return ledgerService.selectedDepreciationList(accountCode);
	}

	@GetMapping("/getFixedAssetLedgerList")
	public ArrayList<FixedAssetBean> fixedAssetLedgerList(){
		return ledgerService.fixedAssetLedgerList();
	}

	@PostMapping("/assetstorage")
    public void assetStorage(@RequestParam(value="previousAssetItemCode", required=false) String previousAssetItemCode,
    								 @RequestParam(value="assetItemCode", required=false) String assetItemCode,
    								 @RequestParam(value="assetItemName", required=false) String assetItemName,
    								 @RequestParam(value="parentsCode", required=false) String parentsCode,
    								 @RequestParam(value="parentsName", required=false) String parentsName,
    								 @RequestParam(value="acquisitionDate", required=false) String acquisitionDate,
    								 @RequestParam(value="acquisitionAmount", required=false) String acquisitionAmount,
    								 @RequestParam(value="manageMentDept", required=false) String manageMentDept,
    								 @RequestParam(value="usefulLift", required=false) String usefulLift) {

    	System.out.println(assetItemCode+"@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        	HashMap<String, Object> map = new HashMap<>();
        	map.put("assetItemCode", assetItemCode);
        	map.put("assetItemName", assetItemName);
        	map.put("parentsCode", parentsCode);
        	map.put("parentsName", parentsName);
        	map.put("acquisitionDate", acquisitionDate);
        	map.put("acquisitionAmount", Integer.parseInt((acquisitionAmount).replaceAll(",","")));
        	map.put("manageMentDept", manageMentDept);
        	map.put("usefulLift", usefulLift);
        	map.put("previousAssetItemCode", previousAssetItemCode);


        	ledgerService.assetStorage(map);

    }


	@GetMapping("/CurrentAssetCode")
	public ArrayList<AccountBean> currentAssetCode(){
		return ledgerService.currentAssetCode();
	}

	@GetMapping("/assetDta")
	public ArrayList<AssetItemBean> findAssetDta (@RequestParam("parentsCode") String parentsCode){
		ArrayList<AssetItemBean> assetDta = ledgerService.findAssetDta(parentsCode);
		return assetDta;
	}

	@GetMapping("/assetitemlist") //세부고정자산
    public ArrayList<AssetItemBean> assetItemList(@RequestParam("parentsCode") String parentsCode) {

        	ArrayList<AssetItemBean> AssetItemList = ledgerService.findAssetItemList(parentsCode);

        	return AssetItemList;
    }

	@GetMapping("/deptlist")
    public ArrayList<DeptBean> deptList() {

        	ArrayList<DeptBean> DeptList = ledgerService.findDeptList();

        	return DeptList;
    }



    @GetMapping("/assetremoval")
    public void assetRemove(@RequestParam String assetItemCode) {

        	ledgerService.removeAssetItem(assetItemCode);

    }
}
