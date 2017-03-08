import java.io.*;
class RoleMain {
  public static void main(String args[]){
    int damage;//ダメージ計算用変数
    boolean actionFlag;//行動したかどうかの判定
    PlayerStatus ps = new PlayerStatus(100, 10, 20);
    EnemyStatus es1 = new EnemyStatus(150, 22, 60);
    Ability ab1 = new Ability(1.8, 2);

      do{
        statusDisplay(ps,es1);
        actionFlag=false;
        while(!actionFlag){
          System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走");
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//入力された文字を受け取る
            int re = Integer.parseInt(buf);//文字をint型に
            if(re == 1){
              damage = damageCalc(ps.getAttack());//ダメージ計算
              System.out.println("敵に" + damage + "のダメージ");
              es1.HPCalc(damage);
              actionFlag=true;
            }else if(re == 2){


            }else if(re == 3){

            }else if(re == 4){

            }else{
              System.out.println("1~4の中から選択してください");
            }
          }catch(Exception e){
          }
        };
    }while(es1.getHP()>0) ;

  }
//HPとMPを表示するメソッド
  public static void statusDisplay(PlayerStatus ps, EnemyStatus es){
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のHP:" + es.getHP());
  }
//ダメージの計算を行うメソッド
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;
    System.out.println(rand);
    return ((at*rand)/100);
  }
}
//プレイヤーのステータスを保存するクラス
class PlayerStatus {
  private String playerName;
  private int playerHP;
  private int playerMP;
  private int playerAttack;

  PlayerStatus(int x,int y,int z){
    playerHP = x;
    playerMP = y;
    playerAttack = z;
  }
//名前を決めるメソッド
  void nameSet(String str){
    playerName=str;
    System.out.println(playerName);
  }
  //HPの計算を行うメソッド
  void HPCalc(int d){
    playerHP-=d;
  }
//クラスに保存された情報を返すメソッド
  int getHP(){
    return playerHP;
  }
  int getMP(){
    return playerMP;
  }
  int getAttack(){
    return playerAttack;
  }
}
//CPUのステータスを保存するクラス
class EnemyStatus {
  private String enemyName;
  private int enemyHP;
  private int enemyAttack;
  private int escapeProbability;

  EnemyStatus(int x, int y, int z){
    enemyHP = x;
    enemyAttack = y;
    escapeProbability = z;
  }
  //CPUのHPを計算するメソッド
  void HPCalc(int d){
    enemyHP-=d;
  }
  //CPUのステータスを返すメソッド
  int getHP(){
    return enemyHP;
  }
  int getAttack(){
    return enemyAttack;
  }
  int getEscape(){
    return escapeProbability;
  }
}
//特技の情報を保存するメソッド
class Ability{
  private double abilityBonus;
  private int abilityCost;

  Ability(double x, int y){
    abilityBonus = x;
    abilityCost = y;
  }
//特技の性能を返すメソッド
  double getAbilityBonus(){
    return abilityBonus;
  }
  int getAbilityCost(){
    return abilityCost;
  }
}
