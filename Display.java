class Display {
  private int count;//行数のカウント
  Display(PlayerStatus ps, EnemyStatus es){
    System.out.printf("\033[2J");
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のHP:" + es.getHP());
  }
  //HPとMPを表示するメソッド
  void statusDisplay(PlayerStatus ps, EnemyStatus es){
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のHP:" + es.getHP());
  }
    void statusDisplay(PlayerStatus ps, EnemyStatus es, int  a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("自分のHP:" + ps.getHP());
      System.out.printf("\033[2K");
      System.out.println("自分のMP:" + ps.getMP());
      System.out.printf("\033[2K");
      System.out.println("敵のHP:" + es.getHP());
      System.out.printf("\033[%dB" , 2);
      System.out.printf("\033[2k");
    }
    void clearDisplay(){
      System.out.printf("\033[2J");
    }
    void damageDisplay(int d){
      System.out.println("敵に" + d + "のダメージ\n");
    }
    void damageDisplay(int d, int a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("敵に" + d + "のダメージ\n");
      System.out.printf("\033[%dB" ,count-2);
      System.out.printf("\033[2K");
    }
    void choiseAction(){
      System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走\n");
    }
    void choiseAction(int a){
      System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走\n");
      System.out.printf("\033[%dA" ,1);
      count=6;
    }
}
