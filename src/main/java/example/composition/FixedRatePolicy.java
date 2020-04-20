package example.composition;

import example.Call;
import example.Money;

public class FixedRatePolicy extends BasicRatePolicy {
    @Override
    public Money calculateFee(Phone phone) {
        return super.calculateFee(phone);
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return null;
    }
}
