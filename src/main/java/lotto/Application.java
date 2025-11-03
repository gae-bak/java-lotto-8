package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    private final static List<Integer> winNumbers = new ArrayList<>() ;
    private final static List<List<Integer>> lottoNumbers = new ArrayList<>();
    private static String purchaseFee;
    private static String winNumber;
    private static String bonusNumber;
    private static int purchaseLottoCount;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean firstValid = false;
        boolean secondValid = false;
        boolean thirdValid = false;
        while (!firstValid) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseFee = Console.readLine();
                purchaseLottoCount = Fee.validate(purchaseFee);
                firstValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (!secondValid) {
            try {
                winNumber = Console.readLine();
                splitAndValidatewinNumber(winNumber);
                secondValid = true;
            } catch (IllegalArgumentException e) {
                winNumbers.clear();
                System.out.println(e.getMessage());
            }
        }

        while (!thirdValid) {
            try {
                bonusNumber = Console.readLine();
                valueOfAndValidateNumber(bonusNumber);
                thirdValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Lotto lotto = new Lotto(winNumbers);

        System.out.println(purchaseLottoCount + "개를 구매했습니다.");
        for (int i = 0; i < purchaseLottoCount; i++) {
            lotto.addRandomLottoNumbers(lottoNumbers, lotto.pullOutNumbers());
        }

        WinningDetail winningDetail = new WinningDetail(valueOfAndValidateNumber(bonusNumber));
        winningDetail.printWinningDetails(lottoNumbers, lotto, Integer.valueOf(purchaseFee));
    }

    private static void splitAndValidatewinNumber(String winNumber) {
        String[] split = winNumber.split(",");
        List<String> list = Arrays.asList(split);
        if(split.length != list.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에는 중복된 값이 들어갈 수 없습니다.");
        }
        for (String splitNumber : split) {
            winNumbers.add(valueOfAndValidateNumber(splitNumber));
        }
    }

    private static int valueOfAndValidateNumber(String number) {
        if(number.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값이 들어오지 않았습니다 다시 입력해주세요.");
        }

        if(Integer.valueOf(number) <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호가 0 또는 음수가 나올 수 없습니다.");
        }

        if(Integer.valueOf(number) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호가 46이상이 나올 수 없습니다.");
        }

        return Integer.valueOf(number);
    }
}
