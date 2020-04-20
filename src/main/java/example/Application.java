package example;

//import example.mixin.Phone;
//import example.mixin.TaxableRegularPolicy;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;

import example.composition.Phone;
import example.composition.RateDiscountablePolicy;
import example.composition.RegularPolicy;
import example.composition.TaxablePolicy;

import java.time.Duration;

public class Application {
//    public static void main(String[] args) {
//        Phone taxableRegularPolicyPhone = new Phone(
//                new TaxableRegularPolicy(Money.wons(100), Duration.ofSeconds(10), 0.02),
//                new ArrayList<>(Arrays.asList(
//                        new Call(LocalDateTime.of(2017, 1, 2, 10, 0),
//                                LocalDateTime.of(2017, 1, 2, 10, 1))
//                ))
//        );
//        Money fee = taxableRegularPolicyPhone.calculateFee();
//        System.out.println(fee.toString());
//    }

    public static void composition() {
        Phone phone = new Phone( // 일반 요금제에 세금 정책 조합
                new TaxablePolicy(0.05,
                        new RegularPolicy(Money.wons(100), Duration.ofSeconds(100)))
        );

        Phone phone1 = new Phone( // 일반 요금제에 기본 요금 할인 정책 조합
                new TaxablePolicy(0.05,
                        new RateDiscountablePolicy(Money.wons(1000),
                                new RegularPolicy(Money.wons(100), Duration.ofSeconds(100))))
        );

        Phone phone2 = new Phone( // 세금 정책과 기본 요금 할인 정책이 적용되는 순서 변경
                new RateDiscountablePolicy(Money.wons(1000),
                        new TaxablePolicy(0.05,
                                new RegularPolicy(Money.wons(100), Duration.ofSeconds(100))))
        );
    }
}
