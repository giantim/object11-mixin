package example.mixin;

import example.Call;
import example.Money;

import java.time.Duration;

public class NightlyDiscountPolicy implements BasicRatePolicy {
    private static final int LATE_NIGHT_HOUR = 22;

    protected Money nightlyAmount;
    protected Money regularAmount;
    protected Duration seconds;

    public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    public Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }

        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
