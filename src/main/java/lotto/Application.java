package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String purchaseFee = Console.readLine();
//        Fee fee = new Fee();
        Fee.validate(Integer.valueOf(purchaseFee));
        String winNumbers = Console.readLine();
        String[] split = winNumbers.split(",");

        for (String winNumber : split) {
            Integer.valueOf(winNumber);
        }

       // Arrays.stream(split).

        Arrays.asList(split).sort((o1, o2) -> o1.compareTo(o2));
        // 무조건 Asc
        String bonusNumber = Console.readLine();


    }
}
