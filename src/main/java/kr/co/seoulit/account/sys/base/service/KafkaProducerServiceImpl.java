package kr.co.seoulit.account.sys.base.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private Producer<String, String> producer;

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("kafka-accounting-home")
    private String topic;

    @PostConstruct
    public void init() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(props);
    }

    //2024-08-02
    //kafka로 메시지 보낼때 사용, 로직 추가해야함
    @Override
    public void sendMessage(String key, String value) {
        producer.send(new ProducerRecord<>(topic, key, value), (metadata, exception) -> {
            if (exception != null) {
                System.err.println("Failed to send message: " + exception.getMessage());
            } else {
                System.out.println("Message sent successfully: " + metadata.toString());
            }
        });
    }

    @PreDestroy
    public void close() {
        if (producer != null) {
            producer.close();
        }
    }
}