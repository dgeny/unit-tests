package task4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderProcessorTest {

    private OrderProcessor orderProcessor;
    private EmailService emailServiceSpy;

    @BeforeEach
    public void setUp() {
// Создаем Spy для EmailService
        emailServiceSpy = Mockito.spy(new EmailService());
        orderProcessor = new OrderProcessor(emailServiceSpy);
    }

    @Test
    public void testProcessOrder() {
// Создаем тестовый заказ
        Order order = new Order(1, "john@example.com");

// Вызываем метод, который мы хотим протестировать
        orderProcessor.processOrder(order);

// Проверяем, что метод sendEmail был вызван с правильными аргументами
        verify(emailServiceSpy, times(1)).sendEmail("john@example.com", "Заказ #1", "Ваш заказ успешно обработан.");
    }
}

