package kr.co.seoulit.account.sys.base.service;

import kr.co.seoulit.account.operate.system.to.OpenMrpBean;

import java.util.List;

public interface KafkaConsumerService {
    void processLogisticsMessage(String message);
    void consumeMessages();
}