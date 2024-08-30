import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//      勝ち負けか続けるかの結果を受け取る
        boolean gameResult;
//      ユーザーとcomのインスタスを作成
        Player user = new Player("ユーザー","〇");
        Player com = new Player("コンピューター","☓");

//      ゲームの説明
        System.out.println("〇☓ゲーム");
        System.out.println("ユーザーが先行、comが後攻です。");


//      ゲームの回数を書くのする変数
        int cont = 0;
//      ゲームをする処理
        while (true){

//          ユーザ側の処理
            while (true){

//              入力の指示
                System.out.println();
                System.out.println("行番号を1~3、列番号を1~3で");
                System.out.println("行・列の順でつなげて入力してください");
//      　      表を出力
                Game.printGameData();
//              数字に変換されるデータかどうか
                try{
//                  ユーザから入力場所を受けとる
                    int plase = Integer.parseInt(sc.nextLine());
//                  受け取った場所に〇をセットする　出来た場合はtrueを出来なかった場合はfalseを受け取る
                    boolean result = Game.addGameData(plase-11,user.getSymbol());
                    if(result){
                        break;
                    }

                }catch (NumberFormatException e){

                }

//              再度入力してもらう(形式が間違っているか　その場所が埋まっているため)
                System.out.println("入力形式が間違っています");
            }
//       ゲームの勝ち負けかまだ続けるかを判定する
//      勝ち負けか続けるかの結果を受け取る
            gameResult = Game.judgement(user.getSymbol());
            cont++;
            if(gameResult || cont == 9){
                break;
            }

//      com側の処理
            while (true){
//          ランダムな数字を生成する
                int plase = Game.createRandomPlace();
//          生成した数字の場所に〇をセットする　出来た場合はtrueを出来なかった場合はfalseを受け取る
                boolean result = Game.addGameData(plase,com.getSymbol());
//            データをセット出来たらループを抜ける
                if(result){
                    break;
                }
            }
            gameResult = Game.judgement(com.getSymbol());
            cont++;
            if(gameResult){
                break;
            }
        }
        //表を表示
        Game.printGameData();

        //結果を表示する
        if(cont == 9 && !gameResult){
            System.out.println("引き分け");
        }else if(cont % 2 == 1){
            System.out.println("ユーザーの勝ち");
        }else{
            System.out.println("comの勝ち");
        }

    }
}