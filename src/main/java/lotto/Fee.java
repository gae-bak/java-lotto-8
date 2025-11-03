package lotto;

public class Fee {

    public static int validate(String purchaseFee) {
        if(!purchaseFee.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 수를 입력했습니다.");
        }

        Integer fee = Integer.valueOf(purchaseFee);

        if (fee < 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 요금이 입력되었습니다.(음수 입력)");
        }

        if (fee == 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 요금이 입력되었습니다. (0원 입력)");
        }

        if(!(fee % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 요금은 천원 단위로 나누어 떨어져야합니다.");
        }

        return fee / 1000;
    }
}
