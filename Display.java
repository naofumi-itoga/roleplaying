class Display {
  public static final int DOWN_HP = 0; //この数字以下になったら倒れる

  Display(Player ps, Enemy es){
    System.out.printf("\033[2J");
    System.out.println("自分のLV:" + ps.getLevel());
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のLV:" + es.getLevel());
    System.out.println("敵のHP:" + es.getHP());
  }
  //HPとMPを表示するメソッド
  void statusDisplay(Player ps, Enemy es){
    System.out.println("\n自分のLV:" + ps.getLevel());
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のLV:" + es.getLevel());
    System.out.println("敵のHP:" + es.getHP());
  }
  //コンソールの描画を初期化する
  void clearDisplay(){
    System.out.printf("\033[2J");
  }
  //ダメージを表示するメソッド
  void damageDisplay(int d){
    System.out.println("" + d + "のダメージ");
  }
  //プレイヤーへのダメージおよび回復効果を表示
  void damageDisplay(int d, Player ps){
    if(d>=0){
      System.out.println(d + "のダメージを食らった");
    }else{
      System.out.println((d * -1) + "の回復");
    }
  }
  //敵へのダメージを表示
  void damageDisplay(int d, Enemy es){
    if(d>=0){
      System.out.println("敵に" + d + "のダメージを与えた");
    }else{
      System.out.println("敵は" + (d * -1) + "の回復");
    }
  }
  //行動選択の文章を表示する
  void choiseAction(){
    System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走");
  }
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
