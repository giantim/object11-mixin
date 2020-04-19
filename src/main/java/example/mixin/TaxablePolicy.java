package example.mixin;

import example.Money;

public interface TaxablePolicy extends BasicRatePolicy {
    BasicRatePolicy getRatePolicy();

    double getTaxRate();

    default Money calculateFee(Phone phone) {
        Money fee = getRatePolicy().calculateFee(phone);
        return fee.plus(fee.times(getTaxRate()));
    }

    static Money afterCalculated(Phone phone, BasicRatePolicy basicRatePolicy, double taxRate) {
        Money fee = basicRatePolicy.calculateFee(phone);
        return fee.plus(fee.times(taxRate));
    }

    static Money afterCalculated(Money fee, double taxRate) {
        return fee.plus(fee.times(taxRate));
    }
}
