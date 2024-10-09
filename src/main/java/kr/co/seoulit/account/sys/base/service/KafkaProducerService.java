package kr.co.seoulit.account.sys.base.service;

public interface KafkaProducerService {
    void sendMessage(String key, String value);
}