import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//      ユーザーとcomのインスタスを作成
        Player user = new Player("ユーザー", "〇");
        Player com = new Player("コンピューター", "☓");
        while (true) {
//          ユーザ側の処理
            while (true) {


//      　      表を出力
                Game.printGameData();
//              数字に変換されるデータかどうか
                try {
//                  ユーザから入力場所を受けとる
                    int plase = Integer.parseInt(sc.nextLine());
//                  受け取った場所に〇をセットする　出来た場合はtrueを出来なかった場合はfalseを受け取る
                    boolean result = Game.addGameData(plase - 11, user.getSymbol());
                    if (result) {
                        break;
                    }

                } catch (NumberFormatException e) {

                }

            }

//      com側の処理
            while (true) {
//          ランダムな数字を生成する
                int plase = Game.createRandomPlace();
//          生成した数字の場所に〇をセットする　出来た場合はtrueを出来なかった場合はfalseを受け取る
                boolean result = Game.addGameData(plase, com.getSymbol());
//            データをセット出来たらループを抜ける
                if (result) {
                    break;
                }
            }

        }
    }
}