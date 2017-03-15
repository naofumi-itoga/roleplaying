//CPUのステータスを保存するクラス
class Enemy {
  private String enemyName;
  private int enemyHP;
  private int enemyAttack;
  private int escapeProbability;
  private Attribution enemyAttribution;
  private int enemyLevel;
  private Item enemyUseItem;
  private int enemyMaxHP;
  //オブジェクトの初期データを決定する
  Enemy(int x, int y, int z){
    enemyMaxHP = x;
    enemyHP = enemyMaxHP;;
    enemyAttack = y;
    escapeProbability = z;
    enemyAttribution = new Attribution();
  }
  //初期データをレベルによって決定する
  Enemy(int x){
    enemyLevel = x;
    int upStates[]= new int[2];
    for(int i=0;i<enemyLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*3);
        upStates[j] += rnd;
      }
    }
    enemyMaxHP = upStates[0]*10;
    enemyHP = enemyMaxHP;
    enemyAttack = upStates[1];
    enemyAttribution = new Attribution();
    enemyUseItem = new Item(-enemyHP/5, 1, "薬草");
    escapeProbability = 60;
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
  //属性を返す
  int getAttribution(){
    return enemyAttribution.getAttribution();
  }
  //レベルを返す
  int getLevel(){
    return enemyLevel;
  }
  //さいだいHPを返す
  int getMaxHP(){
    return enemyMaxHP;
  }
  int getItemCount(){
    return enemyUseItem.getItemCount();
  }
  //Itemクラスを読み取りアイテムの効果を返す
  int getItemEffect(){
    return enemyUseItem.getItemEffect();
  }
  //アイテムの名前を返す
  String getItemName(){
    return enemyUseItem.getItemName();
  }
  //アイテムの所持数を減らす
  int itemLost(){
    return enemyUseItem.itemLost();
  }
}
