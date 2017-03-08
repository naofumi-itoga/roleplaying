import java.io.*;
class RoleMain {
  public static void main(String args[]){
    int damage;//ダメージ計算用変数
    boolean actionFlag;//行動したかどうかの判定
    PlayerStatus ps = new PlayerStatus(100, 10, 20);
    EnemyStatus es1 = new EnemyStatus(150, 22, 60);


      do{
        statusDisplay(ps,es1);
        actionFlag=false;
        while(!actionFlag){
          System.out.println("行動を選択してください。\n1.攻撃 2.特技 3.道具 4.逃走");
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//
            int re = Integer.parseInt(buf);//
            if(re == 1){
              damage = damageCalc(ps.getAttack());
              System.out.println("敵に" + damage + "のダメージ");
              es1.enemyHPCalc(damage);
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

  public static void statusDisplay(PlayerStatus ps, EnemyStatus es){
    System.out.println("自分のHP:" + ps.getHP());
    System.out.println("自分のMP:" + ps.getMP());
    System.out.println("敵のHP:" + es.getHP());
  }

  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;
    System.out.println(rand);
    return ((at*rand)/100);
  }
}

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

  void nameSet(String str){
    playerName=str;
    System.out.println(playerName);
  }

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
  void enemyHPCalc(int d){
    enemyHP-=d;
  }
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
