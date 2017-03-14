//CPUのステータスを保存するクラス
class EnemyStatus {
  private String enemyName;
  private int enemyHP;
  private int enemyAttack;
  private int escapeProbability;
  private Attribution enemyAttribution;
  private int enemyLevel;
  //オブジェクトの初期データを決定する
  EnemyStatus(int x, int y, int z){
    enemyHP = x;
    enemyAttack = y;
    escapeProbability = z;
    enemyAttribution = new Attribution();
  }
  EnemyStatus(int x){
    enemyLevel = x;
    int upStates[]= new int[2];
    for(int i=0;i<enemyLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*3);
        System.out.println("この数上がった"+rnd);
        upStates[j] += rnd;
      }
    }
    enemyHP = upStates[0]*10;
    enemyAttack = upStates[1];
    enemyAttribution = new Attribution();
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
  //CPUに対して逃げるを選択した際の成功確率を返す
  int getEscape(){
    return escapeProbability;
  }
  int getAttribution(){
    return enemyAttribution.getAttribution();
  }
  int getLevel(){
    return enemyLevel;
  }
}
