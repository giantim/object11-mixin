package example.mixin;

import example.Money;

import java.time.Duration;

public class RateDiscountableAndTaxableRegularPolicy
        extends RegularPolicy
        implements TaxablePolicy, RateDiscountablePolicy {
    private Money discountAmount;
    private double taxRate;

    public RateDiscountableAndTaxableRegularPolicy(Money amount, Duration seconds,
                                                   Money discountAmount, double taxRate) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
        this.taxRate = taxRate;
    }

    @Override
    public BasicRatePolicy getRatePolicy() {
        return new RegularPolicy(amount, seconds);
    }

    @Override
    public Money discountAmount() {
        return discountAmount;
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = TaxablePolicy.afterCalculated(phone, getRatePolicy(), taxRate);
        return RateDiscountablePolicy.afterCalculated(fee, discountAmount);
    }
}
