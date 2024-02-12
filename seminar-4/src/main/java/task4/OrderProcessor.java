package task4;

import task4.Order;

public class OrderProcessor {
    private EmailService emailService;

    public OrderProcessor(EmailService emailService) {
        this.emailService = emailService;
    }

    public void processOrder(Order order) {
// Реальная логика обработки заказа
// ...

// Отправляем уведомление о заказе с использованием emailService
        emailService.sendEmail(order.getEmail(), "Заказ #" + order.getId(), "Ваш заказ успешно обработан.");
    }
}
