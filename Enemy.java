//CPUのステータスを保存するクラス
class Enemy {
  private String enemyName;//敵の名前
  private int enemyHP;//敵のHP
  private int enemyAttack;//敵の攻撃力
  private int escapeProbability;//敵から逃げられる確率
  private Attribution enemyAttribution;//敵の属性
  private int enemyLevel;//敵のレベル
  private Item enemyUseItem;//敵の使用できるアイテム
  private int enemyMaxHP;//敵の最大HP
  public static final int HEAL_ITEM = 0;//敵の回復道具
  public static final int ATTACK_ITEM = 1;//敵の攻撃道具
  public static final int OTHER_ITEM = 2;//敵のその他の道具
  public static final int HEAL_HERB = 5;//薬草の回復量
  public static final int HAVE_HERB = 1;//敵が所持している薬草の数
  public static final int MAX_UP = 3;//レベルアップ時の能力の最大上昇値
  public static final int HP_UP = 10;//ほかの能力に比べ、HPがどの程度上がりやすいか
  public static final int MAX_ESCAPE = 100;//最大の逃げることができる確率
  public static final int ESCAPE_LINEAR = 2;//レベル＊これ＝逃げられない確率
  public static final int DOWN_HP = 0;//倒れるHP
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
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    enemyMaxHP = upStates[0]*HP_UP;
    enemyHP = enemyMaxHP;
    enemyAttack = upStates[1];
    enemyAttribution = new Attribution();
    enemyUseItem = new Item(-enemyHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "薬草");
    escapeProbability = (MAX_ESCAPE-x*ESCAPE_LINEAR);
  }
  //CPUのHPを計算するメソッド
  void HPCalc(int d){
    enemyHP-=d;
    if(enemyHP<DOWN_HP){
      enemyHP=DOWN_HP;
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
