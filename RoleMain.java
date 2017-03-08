class RoleMain {
  public static void main(String args[]){
    PlayerStatus ps = new PlayerStatus(100, 10, 20);
    EnemyStatus es1 = new EnemyStatus(150, 22);
  }
}

class PlayerStatus {
  static String playerName;
  static int playerHP;
  static int playerMP;
  static int playerAttack;

  PlayerStatus(int x,int y,int z){
    playerHP = x;
    playerMP = y;
    playerAttack = z;
  }

  static void nameSet(String str){
    playerName=str;
    System.out.println(playerName);
  }
}

class EnemyStatus {
  static String enemyName;
  static int enemyHP;
  static int enemyAttack;

  EnemyStatus(int x, int y){
    enemyHP = x;
    enemyAttack = y;
  }
}
