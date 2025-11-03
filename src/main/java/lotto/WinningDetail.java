package lotto;

import java.util.List;

public class WinningDetail {

    private final int bonusNumber;
    private int allRevenue;

    WinningDetail(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void printWinningDetails(List<List<Integer>> lottonumbers, Lotto lotto, int purchaseFee) {

        for (List<Integer> lottoNumber : lottonumbers) {
            long matchCount = lottoNumber.stream().filter(lotto.getNumbers()::contains).distinct().count();
            countRanking((int) matchCount, bonusNumber, lottoNumber);
        }
        System.out.println("3개 일치 (5,000원) - " + Ranking.Fifth.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + Ranking.Forth.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Ranking.Third.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +Ranking.Second.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Ranking.First.getCount() + "개");
        for (Ranking ranking : Ranking.values()) {
            allRevenue += ranking.getRevenue();
        }
        Double allRevenueRate = Ranking.getAllRevenueRate(allRevenue, purchaseFee);
        System.out.println("총 수익률은 " + allRevenueRate + "%입니다.");
    }

    private static int countRanking(int matchCount, int bonusNumber, List<Integer> lottoNumber) {
        if(matchCount == 0 || matchCount == 1 || matchCount == 2) {
            return 0;
        }
        if(matchCount == 3) {
          return Ranking.Fifth.next();
        }
        if(matchCount == 4) {
           return Ranking.Forth.next();
        }
        if(matchCount == 5) {
            if(lottoNumber.contains(bonusNumber)) {
               return Ranking.Second.next();
            }
           return Ranking.Third.next();
        }
        return Ranking.First.next();
    }
}
