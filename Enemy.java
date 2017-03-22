//CPUのステータスを保存するクラス
class Enemy {
  //定数
  public static final int HEAL_ITEM = 0; //敵の回復道具
  public static final int ATTACK_ITEM = 1; //敵の攻撃道具
  public static final int OTHER_ITEM = 2; //敵のその他の道具
  public static final int HEAL_HERB = 5; //薬草の回復量
  public static final int HAVE_HERB = 1; //敵が所持している薬草の数
  public static final int MAX_UP = 3; //レベルアップ時の能力の最大上昇値
  public static final int HP_UP = 10; //ほかの能力に比べ、HPがどの程度上がりやすいか
  public static final int MAX_ESCAPE = 100; //最大の逃げることができる確率
  public static final int ESCAPE_LINEAR = 2; //レベル＊これ＝逃げられない確率
  public static final int DOWN_HP = 0; //倒れるHP
  //変数
  private String name; //敵の名前
  private int HP; //敵のHP
  private int attack; //敵の攻撃力
  private int escapeProbability; //敵から逃げられる確率
  private int level; //敵のレベル
  private int maxHP; //敵の最大HP
  private Attribution attribution; //敵の属性
  private Item useItem; //敵の使用できるアイテム

  //オブジェクトの初期データを決定する
  Enemy(int x, int y, int z){
    maxHP = x;
    HP = maxHP;;
    attack = y;
    escapeProbability = z;
    attribution = new Attribution();
  }
  //初期データをレベルによって決定する
  Enemy(int x){
    level = x;
    int upStates[]= new int[2];
    for(int i=0;i<level;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    maxHP = upStates[0]*HP_UP;
    HP = maxHP;
    attack = upStates[1];
    attribution = new Attribution();
    useItem = new Item(-HP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "薬草");
    escapeProbability = (MAX_ESCAPE-x*ESCAPE_LINEAR);
  }
  void setName(String str){
    name = str;
  }
  //CPUのHPを計算するメソッド
  void HPCalc(int d){
    HP-=d;
    if(HP<DOWN_HP){
      HP=DOWN_HP;
    }
  }
  //CPUのステータスを返すメソッド
  int getHP(){
    return HP;
  }
  int getAttack(){
    return attack;
  }
  //CPUに対して逃げるを選択した際の成功確率を返す
  int getEscape(){
    return escapeProbability;
  }
  //属性を返す
  int getAttribution(){
    return attribution.getAttribution();
  }
  //レベルを返す
  int getLevel(){
    return level;
  }
  //さいだいHPを返す
  int getMaxHP(){
    return maxHP;
  }
  String getName(){
    return name;
  }
  int getItemCount(){
    return useItem.getItemCount();
  }
  //Itemクラスを読み取りアイテムの効果を返す
  int getItemEffect(){
    return useItem.getItemEffect();
  }
  //アイテムの名前を返す
  String getItemName(){
    return useItem.getItemName();
  }
  //アイテムの所持数を減らす
  int itemLost(){
    return useItem.itemLost();
  }
}
