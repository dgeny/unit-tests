package task1;

import org.testng.annotations.Test;

public class OrderProcessorTest {

    @Test
    public void testProcessOrder() {
// Создаем DummyEmailService
        EmailService emailService = new DummyEmailService();
// Создаем OrderProcessor с DummyEmailService
        OrderProcessor orderProcessor = new OrderProcessor(emailService);

// Создаем тестовый заказ
        Order order = createTestOrder();

// Вызываем метод processOrder для тестирования
        orderProcessor.processOrder(order);

// Здесь можно добавить проверки, что метод sendEmail был вызван с правильными аргументами
    }

    private Order createTestOrder() {
// Создаем и возвращаем тестовый заказ для теста
        return null;
    }
}