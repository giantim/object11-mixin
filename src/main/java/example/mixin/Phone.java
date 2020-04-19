package example.mixin;

import example.Call;
import example.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private BasicRatePolicy basicRatePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(BasicRatePolicy ratePolicy, List<Call> calls) {
        this.basicRatePolicy = ratePolicy;
        this.calls.addAll(calls);
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return basicRatePolicy.calculateFee(this);
    }
}
