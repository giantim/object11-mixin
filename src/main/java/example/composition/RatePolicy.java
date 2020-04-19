package example.composition;

import example.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
