package task2;

public class PaymentProcessor {
    private StubBankService bankService;

    public PaymentProcessor(StubBankService bankService) {
        this.bankService = bankService;
    }

    public boolean processPayment(Payment payment) {
// Обработка платежа
        boolean result = bankService.makePayment(payment.getAmount(), payment.getCardNumber());
// Дополнительная логика
        return result;
    }
}

