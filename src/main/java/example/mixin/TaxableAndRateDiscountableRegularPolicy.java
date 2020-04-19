package example.mixin;

import example.Money;

import java.time.Duration;

public class TaxableAndRateDiscountableRegularPolicy
        extends RegularPolicy
        implements RateDiscountablePolicy, TaxablePolicy {
    private Money discountAmount;
    private double taxRate;

    public TaxableAndRateDiscountableRegularPolicy(Money amount, Duration seconds,
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
        Money fee = RateDiscountablePolicy.afterCalculated(phone, getRatePolicy(), discountAmount());
        return TaxablePolicy.afterCalculated(fee, getTaxRate());
    }
}
