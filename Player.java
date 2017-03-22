//プレイヤーのステータスを保存するクラス
class Player {
  //定数
  public static final int MAX_UP = 3; //能力の1レベルごとに最大上がる量
  public static final int HP_UP = 10; //ほかの能力に比べ、HPがどの程度上がりやすいか
  public static final int HEAL_ITEM = 0; //回復道具
  public static final int ATTACK_ITEM = 1; //攻撃道具
  public static final int OTHER_ITEM =2; //その他の道具
  public static final int HEAL_HERB = 2; //薬草の回復量
  public static final int HAVE_HERB = 1; //所持している薬草の数
  public static final int HEAL_SKILL = 0; //回復特技
  public static final int ATTACK_SKILL = 1; //攻撃特技
  public static final int POWER_UP_SKILL = 2; //その他特技
  public static final int MAX_ITEMGOODS = 100; //所持できる道具の最大数
  public static final int MAX_SKILLGOODS = 100; //所持できるスキルの最大数
  public static final int DOWN_HP = 0; //この数値以下になったら倒れる
  public static final int NO_MP = 0; //MPをこの数値以下にできない
  //変数
  private String name; //プレイヤーの名前
  private int HP; //プレイヤーの現在のHP
  private int MP; //ぷれいやーの現在のMP
  private int attack; //プレイヤーの攻撃力
  private int level; //レベル
  private int maxHP; //最大HP
  private int maxMP; //最大MP
  private int itemGoods = 0; //現在持っているアイテムの種類
  private int skillGoods = 0; //現在所持しているスキルの数
  private Attribution attribution; //属性
  private StateEffect state; //今の状態異常
  private Skill skill[] = new Skill[99]; //持っているスキル
  private Item item[] = new Item[99]; //持っているアイテム



  //オブジェクトの初期データを決定する(直接決定)
  Player(int x,int y,int z){
    maxHP = x;
    maxMP = y;
    attack = z;
    skill[0] = new Skill(1.8, 2);
    item[0] = new Item(-maxHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "薬草");
    attribution = new Attribution();
    state = new StateEffect();
    HP = maxHP;
    MP = maxMP;
  }
  //オブジェクトの初期データを決定する(レベルにより決定)
  Player(int x){
    level = x;
    int upStates[]= new int[3];
    for(int i=0;i<level;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    maxHP = upStates[0]*HP_UP;
    maxMP = upStates[1];
    attack = upStates[2];
    attribution = new Attribution();
    state = new StateEffect();
    HP = maxHP;
    MP = maxMP;
    item[0] = new Item(-maxHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "薬草");
    itemGoods++;
  }
//名前を決めるメソッド
  void setName(String str){
    name=str;
  }
  //HPの計算を行うメソッド
  void HPCalc(int d){
    HP-=d;
    if(HP<DOWN_HP){
      HP=DOWN_HP;
    }
  }
  //MPを計算するメソッド
  void MPCalc(int d){
    MP-=d;
    if(MP<NO_MP){
      MP=NO_MP;
    }
  }
  void setAttack(double x){
    attack *= x;
  }
//クラスに保存された情報を返すメソッド
  int getHP(){
    return HP;
  }
  int getMP(){
    return MP;
  }
  int getAttack(){
    return attack;
  }
  //レベルを返す
  int getLevel(){
    return level;
  }
  //最大HPを返す
  int getMaxHP(){
    return maxHP;
  }
  int getMaxMP(){
    return maxMP;
  }
  String getName(){
    return name;
  }

  //Skillクラスを読み取り消費MPを返す
  int getSkillCost(int x){
    return skill[x].getSkillCost();
  }
  //Skillクラスを読み取り倍率を返す
  double getSkillBonus(int x){
    return skill[x].getSkillBonus();
  }
  void setSkill(double x, int y,int z, String s){
    skill[skillGoods] = new Skill(x, y, z, s);
    skillGoods++;
    if(skillGoods >= MAX_SKILLGOODS){
      skillGoods = MAX_SKILLGOODS-1;
    }
  }
  void setSkill(Skill s){
    skill[skillGoods] = s;
    skillGoods++;
    if(skillGoods >= MAX_SKILLGOODS){
      skillGoods = MAX_SKILLGOODS-1;
    }
  }
  //スキルの種類数を返す
  int getSkillGoods(){
    return skillGoods;
  }
  //スキルの名前を返す
  String getSkillName(int x){
    return skill[x].getSkillName();
  }
  //スキルがどういう効果か返す
  int getSkillType(int x){
    return skill[x].getSkillType();
  }

  //Itemクラスを読み取りアイテムの所持数を返す
  int getItemCount(int x){
    return item[x].getItemCount();
  }
  //Itemクラスを読み取りアイテムの効果を返す
  int getItemEffect(int x){
    return item[x].getItemEffect();
  }
  //アイテムの名前を返す
  String getItemName(int x){
    return item[x].getItemName();
  }
  //アイテムの所持数を減らす
  int itemLost(int x){
    return item[x].itemLost();
  }
  //アイテムの所持数を変える
  void countChange(int x, int i){
    item[i].countChange(x);
  }
  //アイテムを追加する
  void setItem(int x, int y, int z, String s){
    item[itemGoods] = new Item(x, y, z, s);
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS-1;
    }
  }
  void setItem(Item i){
    item[itemGoods] = i;
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS-1;
    }
  }
  void setItem(Item i, int x){
    item[itemGoods] = i;
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS;
    }
  }
  //所持しているアイテムの種類数を返す
  int getItemGoods(){
    return itemGoods;
  }
  //どういったアイテムか返す
  int getItemType(int x){
    return item[x].getItemType();
  }

  //属性を返す
  int getAttribution(){
    return attribution.getAttribution();
  }
  //状態異常を設定する
  void setStateEffect(int x){
     state.setStateEffect(x);
  }
  //状態異常を確認しつつ一歩進める
  boolean getStateEffect(){
    return state.getStateEffect();
  }
  //状態異常を確認する
  boolean checkStateEffect(){
    return state.checkStateEffect();
  }
}
