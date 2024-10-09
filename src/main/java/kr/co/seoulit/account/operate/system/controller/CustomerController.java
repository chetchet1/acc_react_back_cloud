package kr.co.seoulit.account.operate.system.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.to.CustomerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.sys.common.util.BeanCreator;

import kr.co.seoulit.account.operate.system.service.SystemService;

import kr.co.seoulit.account.operate.system.to.BusinessBean;
import kr.co.seoulit.account.operate.system.to.DetailBusinessBean;
import kr.co.seoulit.account.operate.system.to.WorkplaceBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@CrossOrigin("*")
@RestController
@RequestMapping("/operate")
public class CustomerController {

	@Autowired
	private SystemService systemService;

	ModelAndView mav;
	ModelMap map = new ModelMap();

	// 업체리스트조회
	@GetMapping("/businesslist")
	public ArrayList<BusinessBean> findBusinessList() {

		ArrayList<BusinessBean> businessList = systemService.findBusinessList();

		return businessList;

	}

	@GetMapping("/customers")
	public HashMap<String, Object> getCustomerList() {
		HashMap<String, Object> map = new HashMap<>();

		map.put("accountCustomerList", systemService.getCustomerList());

		return map;
	}

	@GetMapping("/creditCard")
	public HashMap<String, Object> getCreditCard() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("creditCardList", systemService.getCreditCard());
		return map;
	}

	@GetMapping("/detailbusiness")
	public ArrayList<DetailBusinessBean> findDetailBusiness(@RequestParam String businessCode) {

		ArrayList<DetailBusinessBean> detailBusinessList = systemService.findDetailBusiness(businessCode);

		return detailBusinessList;


	}

	//2024 78 나머지는 알아서 수정하시길. 이상하게 생긴 건 내가 만든 게 아님...
	//JSON 형식으로 받아와야 함. 헤더는 컨픽에 수정해놨음.
	@RequestMapping("/registerworkplace")
	public void registerworkPlace(@RequestBody WorkplaceBean workplaceBean) {

//         JSONObject workplaceAddItemsAll = JSONObject.fromObject(workplaceAddItems);
//         WorkplaceBean workplaceBean = BeanCreator.getInstance().create(workplaceAddItemsAll, WorkplaceBean.class);

		systemService.registerWorkplace(workplaceBean);
	}


	@RequestMapping("/updateWorkplace")
	public void updateWorkplace2(@RequestBody WorkplaceBean workplaceBean){
		systemService.updateWorkplace(workplaceBean);
	}
	@RequestMapping("/workplaceremoval")
	public void removeWorkplace(@RequestBody WorkplaceBean workplaceBean) {

		systemService.removeWorkplace(workplaceBean); //delete
	}
	@RequestMapping("/workplace")
	public WorkplaceBean findWorkplace(@RequestParam String workplaceCode) {

		WorkplaceBean  workplaceBean = new WorkplaceBean();

		workplaceBean = systemService.findWorkplace(workplaceCode);

		return workplaceBean;
	}

	@RequestMapping("/allworkplacelist")
	public ArrayList<WorkplaceBean> findAllWorkplaceList() {

		ArrayList<WorkplaceBean> allWorkplaceList = new ArrayList<>();
		allWorkplaceList = systemService.findAllWorkplaceList();

		return allWorkplaceList;

	}

	@GetMapping("/approvalstatusmodification")
	public void modifyApprovalStatus(@RequestParam String status,
									 @RequestParam String codes	) {

		ArrayList<String> getCodes=new ArrayList<>();

		JSONArray jsonArray=JSONArray.fromObject(codes);
		for(Object obj :jsonArray) {
			String code=(String)obj;
			getCodes.add(code);
		}

		systemService.modifyApprovalStatus(getCodes,status);
	}

	//2024 78 NEW /operate


	//쓸거임
	@RequestMapping("/CustomerList")
	public ArrayList<CustomerBean> findCustomerList(){
		return systemService.findCustomerList();
	}

	//쓸거임
	@RequestMapping("/CustomerListId")
	public CustomerBean findCustomerListId(@RequestParam String customerCode){
		CustomerBean customerBean;
		customerBean = systemService.findIdCustomerList(customerCode);
		return customerBean;
	}
	//쓸거임
//	@RequestMapping("/insertCustomer")  //다른 방법이 있긴 한데 쓰다가 망했음
//	public void insertCustomer(
//			@RequestParam String customerCode,
//			@RequestParam(required = false) String workplaceCode,
//			@RequestParam(required = false) String customerName,
//			@RequestParam(required = false) String customerType,
//			@RequestParam(required = false) String customerCeo,
//			@RequestParam(required = false) String businessLicenseNumber,
//			@RequestParam(required = false) String socialSecurityNumber,
//			@RequestParam(required = false) String customerBusinessConditions,
//			@RequestParam(required = false) String customerBusinessItems,
//			@RequestParam(required = false) String customerZipCode,
//			@RequestParam(required = false) String customerBasicAddress,
//			@RequestParam(required = false) String customerDetailAddress,
//			@RequestParam(required = false) String customerTelNumber,
//			@RequestParam(required = false) String customerFaxNumber,
//			@RequestParam(required = false) String customerNote,
//			@RequestParam(required = false) String accountNumber,
//			@RequestParam(required = false) String cardNumber,
//			@RequestParam(required = false) String cardType,
//			@RequestParam(required = false) String cardMemberName,
//			@RequestParam(required = false) String cardOpenPlace,
//			@RequestParam(required = false) String financialInstituteCode,
//			@RequestParam(required = false) String financialInstituteName
//	){
//		CustomerBean customerBean = new CustomerBean();
//		customerBean.setCustomerCode(customerCode);
//		customerBean.setWorkplaceCode(workplaceCode);
//		customerBean.setCustomerName(customerName);
//		customerBean.setCustomerType(customerType);
//		customerBean.setCustomerCeo(customerCeo);
//		customerBean.setBusinessLicenseNumber(businessLicenseNumber);
//		customerBean.setSocialSecurityNumber(socialSecurityNumber);
//		customerBean.setCustomerBusinessConditions(customerBusinessConditions);
//		customerBean.setCustomerBusinessItems(customerBusinessItems);
//		customerBean.setCustomerZipCode(customerZipCode);
//		customerBean.setCustomerBasicAddress(customerBasicAddress);
//		customerBean.setCustomerDetailAddress(customerDetailAddress);
//		customerBean.setCustomerTelNumber(customerTelNumber);
//		customerBean.setCustomerFaxNumber(customerFaxNumber);
//		customerBean.setCustomerNote(customerNote);
//		customerBean.setAccountNumber(accountNumber);
//		customerBean.setCardNumber(cardNumber);
//		customerBean.setCardType(cardType);
//		customerBean.setCardMemberName(cardMemberName);
//		customerBean.setCardOpenPlace(cardOpenPlace);
//		customerBean.setFinancialInstituteCode(financialInstituteCode);
//		customerBean.setFinancialInstituteName(financialInstituteName);
//
//		systemService.insertCustomer(customerBean);
//	}
	@RequestMapping("/insertCustomer")
	public void insertCustomer(@RequestBody CustomerBean customerBean){
		systemService.insertCustomer(customerBean);
	}
	//쓸거임
	@RequestMapping("/deleteCustomer")
	public void deleteCustomer(@RequestParam String customerCode){
		systemService.deleteCustomer(customerCode);
	}
	//쓸거임
	@RequestMapping("/updateCustomer")
	public void updateCustomer(@RequestBody CustomerBean customerBean){
		systemService.updateCustomer(customerBean);
	}
}



