package example.mixin;

import example.Money;

import java.time.Duration;

public class RateDiscountableNightlyDiscountPolicy
        extends NightlyDiscountPolicy
        implements RateDiscountablePolicy {
    private Money discountAmount;

    public RateDiscountableNightlyDiscountPolicy(Money nightlyAmount, Money regularAmount,
                                                 Duration seconds, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    public BasicRatePolicy getRatePolicy() {
        return new NightlyDiscountPolicy(nightlyAmount, regularAmount, seconds);
    }

    @Override
    public Money discountAmount() {
        return discountAmount;
    }
}
