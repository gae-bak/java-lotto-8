package lotto;

import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    // 랜럼 로또 넘버 뽑기(난수 생성)
    private List<Integer> pullOutNumbers() {
        Random random = new Random();
        int randomNumber = random.nextInt(44) + 1;
        for (int i = 0; i < 6; i++) {
            numbers.add(randomNumber);
        }
        return numbers;
    }

}
