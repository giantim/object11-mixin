package example.composition;

import example.Money;

public class AgreementDiscountablePolicy extends AdditionalRatePolicy {
    public AgreementDiscountablePolicy(RatePolicy next) {
        super(next);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return super.calculateFee(phone);
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return null;
    }
}
