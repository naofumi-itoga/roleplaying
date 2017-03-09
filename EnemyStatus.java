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
    if(enemyHP<0){
      enemyHP=0;
    }
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
