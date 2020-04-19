package example.extend;

import example.Call;
import example.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected Money afterCalculated(Money fee) {
        return fee;
    }

    public List<Call> getCalls() {
        return this.calls;
    }

    abstract protected Money calculateCallFee(Call call);
}
