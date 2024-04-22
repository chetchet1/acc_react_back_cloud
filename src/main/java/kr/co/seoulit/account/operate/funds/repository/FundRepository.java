package kr.co.seoulit.account.operate.funds.repository;

import kr.co.seoulit.account.operate.funds.to.PlanBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<PlanBean,String> {

}
