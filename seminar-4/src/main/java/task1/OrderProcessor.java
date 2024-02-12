package task1;

public class OrderProcessor {
    private EmailService emailService;

    public OrderProcessor(EmailService emailService) {
        this.emailService = emailService;
    }

    public void processOrder(Order order) {
// Обработка заказа
        emailService.sendEmail(order.getCustomerEmail(), "Заказ обработан");
    }
}