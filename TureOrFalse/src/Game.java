import java.util.Random;

public class Game {
    // ゲームデータを格納する二次元配列
    private static String[][] gameData= {{"","",""},{"","",""},{"","",""}};

    //　ゲームデータを配列に格納する関数
//  格納できた場合はtrueを 格納出来ない場合はfalseを返す
    public static boolean addGameData(int place,String symbol){
        int line = place / 10;
        int column = place % 10;
        if((line < 0 || line > 2) || (column < 0 || line > 2)){
//          数字の入力範囲を超えているため
            return false;
        }
        if(gameData[line][column].equals("")){
            gameData[line][column] = symbol;
            return true;
        }else {
            return false;
        }
    }

    //　ゲームの表をコンソールに出力する関数
    public static void printGameData(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameData[i][j].equals("")){
                    System.out.print("　  ");
                }else{
                    System.out.print(" "+gameData[i][j]+" ");
                }
                if(j == 2){
                    System.out.println();
                    break;
                }
                System.out.print("|");
            }
        }
    }

    //  ゲームの行列をランダムに返す関数()
//   10の位は行,1の位は列を表す
    public static int createRandomPlace(){
        Random rand = new Random();
        int result = 0;
        result = rand.nextInt(3) * 10;
        result += rand.nextInt(3);
        return result;
    }

    //  ゲームが勝ち負けを返す関数
//    勝った場合はtrueをゲームを続行する場合はfalseを返す
    public static boolean judgement(String symbol){
//      勝ちが確定した場合はtrueを格納する
        boolean judFlg = true;

//      縦の判定
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameData[j][i].equals(symbol)){
                    continue;
                }else{
                    judFlg = false;
                    break;
                }
            }
            if(judFlg || i ==2) {
                break;
            }
            judFlg = true;
        }
//        処理を続けるか続けないかの判定
        if(judFlg){
            System.out.println(1);
            return true;
        }else{
//          フラグの初期化
            judFlg = true;
        }


//        横の判定
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameData[i][j].equals(symbol)){
                    continue;
                }else{
                    judFlg = false;
                    break;
                }
            }
            if(judFlg || i ==2) {
                break;
            }
            judFlg = true;
        }
        //        処理を続けるか続けないかの判定
        if(judFlg){
            System.out.println(2);
            return true;
        }else{
//          フラグの初期化
            judFlg = true;
        }


//        ななめの判定
        for(int i = 0; i < 3; i++){
            if(gameData[i][i].equals(symbol)){
                continue;
            }else{
                judFlg = false;
                break;
            }
        }
        // 処理を続けるか続けないかの判定
        if(judFlg){
            return true;
        }else{
//          フラグの初期化
            judFlg = true;
        }

        for(int i = 0; i < 3; i++){
            if(gameData[i][2 - i].equals(symbol)){
                continue;
            }else{
                judFlg = false;
                break;
            }
        }

        // 最終的な勝ち負けの判定
        if(judFlg){
            return true;
        }else{
            return false;
        }

    }


}