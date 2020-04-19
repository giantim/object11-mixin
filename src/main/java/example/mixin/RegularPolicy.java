package example.mixin;

import example.Call;
import example.Money;

import java.time.Duration;

public class RegularPolicy implements BasicRatePolicy {
    protected Money amount;
    protected Duration seconds;

    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    public Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
