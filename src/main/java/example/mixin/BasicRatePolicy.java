package example.mixin;

import example.Call;
import example.Money;

public interface BasicRatePolicy {
    default Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    Money calculateCallFee(Call call);
}
