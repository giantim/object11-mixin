package example.extend;

import example.Call;
import example.Money;

public class FixedRatePhone extends Phone {
    @Override
    protected Money calculateCallFee(Call call) {
        return null;
    }
}
