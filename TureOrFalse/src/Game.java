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




}