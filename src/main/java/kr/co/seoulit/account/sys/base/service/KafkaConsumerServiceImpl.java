package kr.co.seoulit.account.sys.base.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.seoulit.account.operate.system.to.OpenMrpBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaConsumerServiceImpl(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9103").build(); // 컨트롤러의 기본 URL
        this.objectMapper = objectMapper;
    }

    @Override
    public void consumeMessages() {
        // 메시지를 수동으로 소비할 로직을 여기에 추가할 수 있습니다.
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "kafka-react-logi-acc1", partitions = "0"),
            groupId = "kafka-react-logi-acc"
    )
    public void processLogisticsMessage(String message) {
        try {
            // JSON 문자열을 List<OpenMrpBean>으로 변환
            List<OpenMrpBean> openMrpListData = objectMapper.readValue(message, new TypeReference<List<OpenMrpBean>>() {});

            // 데이터 처리 로직 (데이터 확인)
            System.out.println("Logistics - OpenMrpList Data: " + openMrpListData);

            // 컨트롤러의 API로 데이터 전송
            sendDataToController(openMrpListData);

        } catch (Exception e) {
            // 예외 발생 시 에러 로그 출력
            System.err.println("Kafka 메시지 처리 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendDataToController(List<OpenMrpBean> openMrpListData) {
        // HTTP 요청을 통해 컨트롤러의 API로 데이터 전송
        webClient.post()
                .uri("/api/account/budget/mrp/list")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(openMrpListData)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(aVoid -> {
                    System.out.println("데이터가 성공적으로 컨트롤러로 전송되었습니다.");
                })
                .doOnError(error -> {
                    System.err.println("컨트롤러로 데이터 전송 중 오류 발생: " + error.getMessage());
                })
                .subscribe();
    }
}
