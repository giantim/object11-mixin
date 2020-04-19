package example.mixin;

import example.Money;

import java.time.Duration;

public class TaxableRegularPolicy
        extends RegularPolicy
        implements TaxablePolicy {
    private double taxRate;

    public TaxableRegularPolicy(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public BasicRatePolicy getRatePolicy() {
        return new RegularPolicy(amount, seconds);
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }
}
