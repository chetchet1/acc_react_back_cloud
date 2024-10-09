package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WorkplaceBean extends BaseBean{
	private String workplaceCode;
	private String companyCode;
	private String workplaceName;
	private String businessLicense;
	private String corporationLicence;
	private String workplaceCeoName;
	private String businessConditions;
	private String businessItems;
	private String workplaceTelNumber;
	private String workplaceFaxNumber;
	private String workplaceBasicAddress;
	private String approvalStatus;
	private String workplaceZipCode;
	private String workplaceDetailAddress;

	//NEW
	private String  workplaceEstablishDate;
	private String  workplaceOpenDate;
	private String  workplaceCloseDate;



}
