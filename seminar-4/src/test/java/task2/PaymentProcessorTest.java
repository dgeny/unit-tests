package task2;

import org.junit.jupiter.api.Test;

class PaymentProcessorTest {
    @Test
    void processPayment() {
        {
// Создаем StubBankService
            StubBankService bankService = new StubBankService();
// Создаем PaymentProcessor с StubBankService
            PaymentProcessor paymentProcessor = new PaymentProcessor(bankService);

// Создаем тестовый платеж
            Payment payment = createTestPayment();

// Вызываем метод processPayment для тестирования
          boolean result = paymentProcessor.processPayment(payment);

// Здесь можно добавить проверки, что результат соответствует ожиданиям
        }
    }

    private Payment createTestPayment() {
        return new Payment() ;
    }
}