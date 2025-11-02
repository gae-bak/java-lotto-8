package lotto;

public class Fee {

    public static void validate(int fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("잘못된 요금이 입력되었습니다. [ERROR] 음수 입력");
        }

        if (fee == 0) {
            throw new IllegalArgumentException("잘못된 요금이 입력되었습니다. [ERROR] 0원 입력");
        }

        if(!(fee % 1000 == 0)) {
            throw new IllegalArgumentException("요금은 천원 단위로 나누어 떨어져야합니다.");
        }
    }
}
