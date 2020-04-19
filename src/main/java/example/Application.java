package example;

import example.mixin.Phone;
import example.mixin.TaxableRegularPolicy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Phone taxableRegularPolicyPhone = new Phone(
                new TaxableRegularPolicy(Money.wons(100), Duration.ofSeconds(10), 0.02),
                new ArrayList<>(Arrays.asList(
                        new Call(LocalDateTime.of(2017, 1, 2, 10, 0),
                                LocalDateTime.of(2017, 1, 2, 10, 1))
                ))
        );
        Money fee = taxableRegularPolicyPhone.calculateFee();
        System.out.println(fee.toString());
    }
}
