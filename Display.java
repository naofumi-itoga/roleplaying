import java.util.*;

class Display {
  //定数
  public static final int DOWN_HP = 0; //この数字以下になったら倒れる
  public static final String CLEAR = "\033c"; //画面をクリア
  public static final String BOLD = "\033[1m"; //太字
  public static final String BOLD_DEFAULT = "\033[22m"; //太字を元に戻す
  public static final String BACK_COLOR_BLUE = "\033[44m"; //背景色を青に
  public static final String BACK_COLOR_BASE = "\033[00m"; //背景色を戻す
  public static final String BACK_COLOR_WHITE = "\033[47m"; //背景色を白に
  public static final String CENTER_LOG_CHANGE = "\033[1;31m"; //太字にして文字を赤く
  public static final String COLOR_DEFAULT = "\033[m"; //色を初期に戻す
  public static final String WINDOW_SIZE = "\033[4;170;370t"; //コンソールのサイズを170pixel,370pixcel
  public static final String UNDER_SCORE = "\033[4m"; //下線を付ける
  public static final String UNDER_SCORE_RELEASE = "\033[24m"; //下線を消す
  public static final int ESC = 0x1B; //ＥＳＣキー
  public static final int ALL_EM = 8; //すべてが大文字の場合のバイト数
  public static final int NO_ITEM = 0; //アイテムがない状態
  //変数
  String logs[] = new String[8]; //ダメージなどを保存する
  String centerLog; //下に表示する文章を表示する

  //  文字だけでステータスを表示
  /*  Display(Player player, Enemy enemy){
      System.out.printf("\033[2");
      System.out.println("自分のLV:" + player.getLevel());
      System.out.println("自分のHP:" + player.getHP());
      System.out.println("自分のMP:" + player.getMP());
      System.out.println("敵のLV:" + enemy.getLevel());
      System.out.println("敵のHP:" + enemy.getHP());
    }*/

    //ウィンドウのサイズを変更してステータスと行動選択の表示
  Display(Player player){
    System.out.printf(WINDOW_SIZE);
//    statusDisplay(player, enemy);
//    choiseAction();
  }

  //バーでステータスを表示
  void statusDisplay(Player player, Enemy enemy){
    System.out.printf(CLEAR);
    System.out.println("------------------------");
    System.out.println(enemy.getName() + "\t\t|8." + logs[7]);
    System.out.print("LV:" + enemy.getLevel() + "\t");
  //  System.out.println("HP:" + enemy.getHP() + "\t|7." + logs[6]);//数字によるHP表示(敵)
  //バーでHP表示(敵)
  System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(enemy.getHP() >= enemy.getMaxHP() * a / 10){
        System.out.print("■");
      }else{
        System.out.print("□");
      }
    }
    System.out.println("\t|7." + logs[6]);
    System.out.println("------------------------|6." + logs[5]);
    System.out.print(player.getName());
    if((player.getName().getBytes().length) != ALL_EM){
        System.out.print("\t");
    }
    //System.out.println("HP:" + player.getHP() + "\t|5." + logs[4]);//数字でHP表示（自分）
    //バーでHP表示(自分)
    System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(player.getHP() >= player.getMaxHP() * a / 10){
        System.out.print("■");
      }else{
        System.out.print("□");
      }
    }
    System.out.println("\t|5." + logs[4]);
    System.out.print("LV:" + player.getLevel() + "\t");
    //System.out.println("MP:" + player.getMP() + "\t\t|4." + logs[3]);//数字でMP表示（自分）
    //バーでHP表示(自分)
    System.out.print("MP:");
      for(int a = 1; a <= 10; a++){
        if(player.getMP() >= player.getMaxMP() * a / 10){
          System.out.print("■");
        }else{
          System.out.print("□");
        }
      }
      System.out.println("\t|4." + logs[3]);
/*    System.out.println("自分のHP:" + player.getHP() + "\t\t" + logs[0]);
    System.out.println("自分のMP:" + player.getMP() + "\t\t" + logs[1]);
    System.out.println("敵のLV:" + enemy.getLevel() + "\t\t" + logs[2]);
    System.out.println("敵のHP:" + enemy.getHP() + "\t\t" + logs[3]);
    */
  }
  //HPとMPを表示するメソッド(数字で)
  /*void statusDisplay(Player player, Enemy enemy){
    System.out.println("\n自分のLV:" + player.getLevel());
    System.out.println("自分のHP:" + player.getHP());
    System.out.println("自分のMP:" + player.getMP());
    System.out.println("敵のLV:" + enemy.getLevel());
    System.out.println("敵のHP:" + enemy.getHP());
  }
  */

  //行動選択(枠付き)
  void choiseAction(){
    System.out.println("========================|3." + logs[2]);
    System.out.println("1.攻撃 2.特技\t\t|2." + logs[1]);
    System.out.println("3.道具 4.逃走\t\t|1." + logs[0]);
    System.out.println("======================== ");
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }



  //コンソールの描画を初期化する
  void clearDisplay(){
    System.out.printf(CLEAR + WINDOW_SIZE);
  }
  //ダメージを表示するメソッド
  String damageDisplay(int d){
    return "" + d + "のダメージ";
  }
  //プレイヤーへのダメージおよび回復効果を表示
  String damageDisplay(int d, Player player){
    if(d >= 0){
      return d + "のダメージを食らった";
    }else{
      return (d * -1) + "の回復";
    }
  }
  //敵へのダメージを表示
  String damageDisplay(int d, Enemy enemy){
    if(d >= 0){
      return "敵に" + d + "のダメージを与えた";
    }else{
      return "敵は" + (d * -1) + "の回復";
    }
  }
  //行動選択の文章を表示する
/*  void choiseAction(){
    System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走");
  }
  */
  //戦闘結果
  void result(Player player, Enemy enemy){
    if(enemy.getHP() <= DOWN_HP){
      System.out.println("戦闘に勝利した");
    }else if(player.getHP() <= DOWN_HP){
      System.out.println("戦闘に敗北した");
    }else {
      System.out.println("戦闘から逃げ出した");
    }
  }

  //戦闘のログを保存する
  void setLog(String s){
    for(int i = logs.length - 1; i > 0; i--){
      logs[i] = logs[i - 1];
    }
    logs[0] = BACK_COLOR_BLUE + s + BACK_COLOR_BASE;
  }

  //ダメージ表示する用
  void setCenterLog(int i){
    if(i >= 0){
      centerLog = CENTER_LOG_CHANGE + i + "ダメージ" + BOLD_DEFAULT + COLOR_DEFAULT;
    }else{
      centerLog = -1 * i + "回復";
    }
  }
  //文字列保存
  void setCenterLog(String str){
      centerLog = str;
  }

  //スキルを表示する
  void skillDisplay(Player player){
    System.out.printf(CLEAR + UNDER_SCORE + BACK_COLOR_BLUE);
    for(int i = 0; i < player.getSkillGoods(); i++){
      System.out.println(i+1 + "." + player.getSkillName(i) + ":消費MP" + player.getSkillCost(i));
    }
    System.out.println("0.もどる" + UNDER_SCORE_RELEASE + BACK_COLOR_BASE);
  }

  //道具を表示する
  void itemDisplay(Player player){
    System.out.printf(CLEAR + UNDER_SCORE + BACK_COLOR_BLUE);
    for(int i = 0; i < player.getItemGoods(); i++){
      if(player.getItemCount(i) > NO_ITEM){
        System.out.println((i + 1) + "." + player.getItemName(i) + ":効果量" + player.getItemEffect(i) + ":所持数" + player.getItemCount(i));
      }
    }
    System.out.println("0.もどる" + UNDER_SCORE_RELEASE + BACK_COLOR_BASE);
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }
  //道具を表示する(道具屋)
  void itemDisplay(List<Item> item){
    System.out.printf(CLEAR + UNDER_SCORE + BACK_COLOR_BLUE);
    for(int i = 0; i < item.size(); i++){
      if(item.get(i).getItemCount() > NO_ITEM){
        System.out.println((i + 1) + "." + item.get(i).getItemName() + ":効果量" + item.get(i).getItemEffect() + ":所持数" + item.get(i).getItemCount() + ":値段" + Math.abs(item.get(i).getItemEffect() * item.get(i).getItemCount()));
      }
    }
    System.out.println("0.もどる" + UNDER_SCORE_RELEASE + BACK_COLOR_BASE);
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }

  //町のインターフェース
  void townDisplay(int money, String choises[]){
    List<String> choisesList = new ArrayList<String>();
    for(int i = 0; i < choises.length; i++){
      choisesList.add(choises[i]);
    }
    System.out.printf(CLEAR);
    System.out.println(" ---------------");
    System.out.println("|所持金:" + money + "en\t|");
    for(int i = 0; i < choisesList.size(); i++){
      if(choisesList.get(i).getBytes().length <= 4 ){
        System.out.println("|" + (i + 1) + "." + choisesList.get(i) + "\t\t|");
      }else{
        System.out.println("|" + (i + 1) + "." + choisesList.get(i) + "\t|");
      }
    }
    System.out.println(" ---------------");
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }

  //ダンジョンの選択画面
  void dungeonChoiseDisplay(int totalDungeon, String dungeonName[]){
    for(int i = 0; i < totalDungeon; i++){
        System.out.println((i + 1) + ":" + dungeonName[i]);
    }
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }

  //ダンジョン内での移動可能か表示
  void dungeonDisplay(Dungeon dungeons, int x, int y){
    System.out.printf(CLEAR);
    for(int i = 0; i < dungeons.getDepth(); i++){
      for(int j = 0; j < dungeons.getDepth(); j++){
        if(dungeons.searchDungeon(j, i) == 1){
          if(dungeons.getNowX() == j && dungeons.getNowY() == i){
            System.out.print("■");
          }else{
            System.out.print("□");
          }
        }else{
          System.out.print(" ");
        }
      }
      System.out.print("\n");
    }
    if(dungeons.searchDungeon(x, y - 1) == 1){
      System.out.print("   2:上");
    }
    System.out.print("\n");
    if(dungeons.searchDungeon(x - 1, y) == 1){
      System.out.print("3:左");
    }else{
      System.out.print("    ");
    }
    System.out.print("現");
    if(dungeons.searchDungeon(x + 1, y) == 1){
      System.out.print("1:右");
    }
    System.out.print("\n");
    if(dungeons.searchDungeon(x, y + 1) == 1){
      System.out.print("   4:下");
    }
    System.out.print("\n");
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }
}
