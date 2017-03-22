class Display {
  //定数
  public static final int DOWN_HP = 0; //この数字以下になったら倒れる
  public static final String CLEAR = "\033c";//画面をクリア
  public static final String BOLD = "\033[1m";//太字
  public static final String BOLD_DEFAULT = "\033[22m";//太字を元に戻す
  public static final String BACK_COLOR_BLUE = "\033[44m";//背景色を青に
  public static final String BACK_COLOR_BASE = "\033[00m";//背景色を戻す
  public static final String BACK_COLOR_WHITE = "\033[47m";//背景色を白に
  public static final String CENTER_LOG_CHANGE = "\033[1;31m";//太字にして文字を赤く
  public static final String COLOR_DEFAULT = "\033[m";//色を初期に戻す
  public static final String WINDOW_SIZE = "\033[4;170;370t";//コンソールのサイズを170pixel,370pixcel
  public static final int ESC = 0x1B;//ＥＳＣキー
  public static final int ALL_EM = 8;
  //変数
    String logs[] = new String[8];

  //  文字だけでステータスを表示
  /*  Display(Player ps, Enemy es){
      System.out.printf("\033[2");
      System.out.println("自分のLV:" + ps.getLevel());
      System.out.println("自分のHP:" + ps.getHP());
      System.out.println("自分のMP:" + ps.getMP());
      System.out.println("敵のLV:" + es.getLevel());
      System.out.println("敵のHP:" + es.getHP());
    }*/

    //バーでHPなどを表示
  Display(Player ps, Enemy es){
    System.out.printf(WINDOW_SIZE);
    statusDisplay(ps, es);
    choiseAction();
  }

  //バーでステータスを表示
  void statusDisplay(Player ps, Enemy es){
  //  System.out.printf("%c[1;1H", ESC); //カーソルを上へ
    System.out.printf(CLEAR);
    System.out.println("------------------------");
    System.out.println(es.getName() + "\t\t|8." + BACK_COLOR_BLUE + logs[7] + BACK_COLOR_BASE);
    System.out.print("LV:" + es.getLevel() + "\t");
  //  System.out.println("HP:" + es.getHP() + "\t|7." + logs[6]);//数字によるHP表示(敵)
  //バーでHP表示(敵)
  System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(es.getHP() >= es.getMaxHP()*a/10){
        System.out.print("■");
      }else{
        System.out.print("□");
      }
    }
    System.out.println("\t|7." + logs[6]);
/*    System.out.println("\t\t\t|" + logs[1]);
    System.out.println("\t" + centerLog + "\t|" + logs[2]);
    */
    System.out.println("------------------------|6." + logs[5]);
    System.out.print(ps.getName());
    if((ps.getName().getBytes().length) != ALL_EM){
        System.out.print("\t");
    }
    //System.out.println("HP:" + ps.getHP() + "\t|5." + logs[4]);//数字でHP表示（自分）
    //バーでHP表示(自分)
    System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(ps.getHP() >= ps.getMaxHP()*a/10){
        System.out.print("■");
      }else{
        System.out.print("□");
      }
    }
    System.out.println("\t|5." + logs[4]);
    System.out.print("LV:" + ps.getLevel() + "\t");
    //System.out.println("MP:" + ps.getMP() + "\t\t|4." + logs[3]);//数字でMP表示（自分）
    //バーでHP表示(自分)
    System.out.print("MP:");
      for(int a = 1; a <= 10; a++){
        if(ps.getMP() >= ps.getMaxMP()*a/10){
          System.out.print("■");
        }else{
          System.out.print("□");
        }
      }
      System.out.println("\t|4." + logs[3]);
/*    System.out.println("自分のHP:" + ps.getHP() + "\t\t" + logs[0]);
    System.out.println("自分のMP:" + ps.getMP() + "\t\t" + logs[1]);
    System.out.println("敵のLV:" + es.getLevel() + "\t\t" + logs[2]);
    System.out.println("敵のHP:" + es.getHP() + "\t\t" + logs[3]);
    */
    //System.out.printf("%c[1;1H", ESC); //かーそる位置をしたに
    //System.out.printf("%c[>5h", ESC); // カーソル消去
  }
  //HPとMPを表示するメソッド(数字で)
  /*void statusDisplay(Player ps, Enemy es){
    System.out.println("\n自分のLV:" + ps.getLevel());
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のLV:" + es.getLevel());
    System.out.println("敵のHP:" + es.getHP());
  }
  */

  //行動選択(枠付き)
  void choiseAction(){
    System.out.println("========================|3."+ logs[2]);
    System.out.println("1.攻撃 2.特技\t\t|2." + logs[1]);
    System.out.println("3.道具 4.逃走\t\t|1." + logs[0]);
    System.out.println("======================== ");
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
  String damageDisplay(int d, Player ps){
    if(d>=0){
      return d + "のダメージを食らった";
    }else{
      return (d * -1) + "の回復";
    }
  }
  //敵へのダメージを表示
  String damageDisplay(int d, Enemy es){
    if(d>=0){
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
  void result(Player ps, Enemy es){
    if(es.getHP() <= DOWN_HP){
      System.out.println("戦闘に勝利した");
    }else if(ps.getHP() <= DOWN_HP){
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

  //中央にダメージ表示する用
  String centerLog =  "1234567789";
  void setCenterLog(int i){
    if(i>=0){
      centerLog = CENTER_LOG_CHANGE + i + "ダメージ" + BOLD_DEFAULT + COLOR_DEFAULT;
    }else{
      centerLog = -1*i + "回復";
    }

  }
    /*
    private int count;//行数のカウント
    void choiseAction(int a){
      System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走\n");
      System.out.printf("\033[%dA" ,1);
      count=6;
    }
    void damageDisplay(int d, int a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("敵に" + d + "のダメージ\n");
      System.out.printf("\033[%dB" ,count-2);
      System.out.printf("\033[2K");
    }
    void statusDisplay(Player ps, Enemy es, int  a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("自分のHP:" + ps.getHP());
      System.out.printf("\033[2K");
      System.out.println("自分のMP:" + ps.getMP());
      System.out.printf("\033[2K");
      System.out.println("敵のHP:" + es.getHP());
      System.out.printf("\033[%dB" , 2);
      System.out.printf("\033[2k");
    }*/
}
