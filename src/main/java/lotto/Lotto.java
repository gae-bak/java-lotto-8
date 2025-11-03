package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재하면 안됩니다.");
        }

        if (numbers.stream().anyMatch(n -> n <= 0)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 음수가 존재하면 안됩니다.");
        }

        if (numbers.stream().anyMatch(n -> n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 46이상인 수가 존재하면 안됩니다.");
        }
    }

    // TODO: 추가 기능 구현
    // 랜럼 로또 넘버 뽑기(난수 생성)
    public List<Integer> pullOutNumbers() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return integers;
    }

    public void addRandomLottoNumbers(List<List<Integer>> lottoNumbers, List<Integer> lottoRandomNumbers) {
        System.out.println(lottoRandomNumbers.toString());
        lottoNumbers.add(lottoRandomNumbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
