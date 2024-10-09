package kr.co.seoulit.account.operate.system.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OpenMrpBean extends BaseBean {

	private String mpsNo;
	private String bomNo;
	private String itemClassification;
	private String itemCode;
	private String itemName;
	private String orderDate;
	private String requiredDate;
	private int planAmount;         // String -> int로 변경
	private double totalLossRate;    // String -> double로 변경
	private double calculatedAmount; // String -> double로 변경
	private double requiredAmount;   // 이미 double로 선언되어 있음
	private String unitOfMrp;
	private double standardUnitPrice; // String -> double로 변경
	private double totalPrice;        // String -> double로 변경

	@JsonCreator
	public OpenMrpBean(
			@JsonProperty("mpsNo") String mpsNo,
			@JsonProperty("bomNo") String bomNo,
			@JsonProperty("itemClassification") String itemClassification,
			@JsonProperty("itemCode") String itemCode,
			@JsonProperty("itemName") String itemName,
			@JsonProperty("orderDate") String orderDate,
			@JsonProperty("requiredDate") String requiredDate,
			@JsonProperty("planAmount") String planAmount,                 // int -> String 수신 후 변환
			@JsonProperty("totalLossRate") String totalLossRate,           // double -> String 수신 후 변환
			@JsonProperty("calculatedAmount") String calculatedAmount,     // double -> String 수신 후 변환
			@JsonProperty("requiredAmount") double requiredAmount,
			@JsonProperty("unitOfMrp") String unitOfMrp,
			@JsonProperty("standardUnitPrice") String standardUnitPrice,   // double -> String 수신 후 변환
			@JsonProperty("totalPrice") String totalPrice                  // double -> String 수신 후 변환
	) {
		this.mpsNo = mpsNo;
		this.bomNo = bomNo;
		this.itemClassification = itemClassification;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;

		// String을 int로 변환 (null일 경우 기본값 0 설정)
		this.planAmount = planAmount != null ? Integer.parseInt(planAmount) : 0;

		// String을 double로 변환 (null일 경우 기본값 0.0 설정)
		this.totalLossRate = totalLossRate != null ? Double.parseDouble(totalLossRate) : 0.0;
		this.calculatedAmount = calculatedAmount != null ? Double.parseDouble(calculatedAmount) : 0.0;

		this.requiredAmount = requiredAmount;
		this.unitOfMrp = unitOfMrp;

		// String을 double로 변환 (null일 경우 기본값 0.0 설정)
		this.standardUnitPrice = standardUnitPrice != null ? Double.parseDouble(standardUnitPrice) : 0.0;
		this.totalPrice = totalPrice != null ? Double.parseDouble(totalPrice) : 0.0;
	}
}
