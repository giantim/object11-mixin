package example.mixin;

import example.Money;

public interface RateDiscountablePolicy extends BasicRatePolicy {
    BasicRatePolicy getRatePolicy();

    Money discountAmount();

    default Money calculateFee(Phone phone) {
        Money fee = getRatePolicy().calculateFee(phone);
        return fee.minus(discountAmount());
    }

    static Money afterCalculated(Phone phone, BasicRatePolicy basicRatePolicy, Money discountAmount) {
        Money fee = basicRatePolicy.calculateFee(phone);
        return fee.minus(discountAmount);
    }

    static Money afterCalculated(Money fee, Money discountAmount) {
        return fee.minus(discountAmount);
    }
}
