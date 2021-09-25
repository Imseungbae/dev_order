package dev.practice.order.infrastructure.notification;

import dev.practice.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("send Email~");
    }

    @Override
    public void sendKakao(String phoneNumber, String description) {
        log.info("send Kakao~");
    }

    @Override
    public void sendSMS(String phoneNumber, String description) {
        log.info("send SMS~");
    }
}
