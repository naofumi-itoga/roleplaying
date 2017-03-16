//プレイヤーのステータスを保存するクラス
class Player {
  private String playerName;//プレイヤーの名前
  private int playerHP;//プレイヤーの現在のHP
  private int playerMP;//ぷれいやーの現在のMP
  private int playerAttack;//プレイヤーの攻撃力
  private Attribution playerAttribution;//属性
  private Skill playerSkill[] = new Skill[99];//持っているスキル
  private Item playerItem[] = new Item[99];//持っているアイテム
  private StateEffect playerState;//今の状態異常
  private int playerLevel;//レベル
  private int playerMaxHP;//最大HP
  private int playerMaxMP;//最大MP
  public static final int MAX_UP = 3;
  public static final int HP_UP = 10;//ほかの能力に比べ、HPがどの程度上がりやすいか
  private int itemGoods = 0;//現在持っているアイテムの種類
  private int skillGoods = 0;
  public static final int HEAL_ITEM = 0;//回復道具
  public static final int ATTACK_ITEM = 1;//攻撃道具
  public static final int OTHER_ITEM =2;//その他の道具
  public static final int HEAL_HERB = 2;//薬草の回復量
  public static final int HAVE_HERB = 1;//所持している薬草の数
  public static final int HEAL_SKILL = 0;//回復特技
  public static final int ATTACK_SKILL = 1;//攻撃特技
  public static final int POWER_UP_SKILL = 2;//その他特技
  public static final int MAX_ITEMGOODS = 100;//所持できる道具の最大数
  public static final int MAX_SKILLGOODS = 100;//所持できるスキルの最大数
  public static final int DOWN_HP = 0;
  public static final int NO_MP = 0;

  //オブジェクトの初期データを決定する(直接決定)
  Player(int x,int y,int z){
    playerMaxHP = x;
    playerMaxMP = y;
    playerAttack = z;
    playerSkill[0] = new Skill(1.8, 2);
    playerItem[0] = new Item(-playerMaxHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "薬草");
    playerAttribution = new Attribution();
    playerState = new StateEffect();
    playerHP = playerMaxHP;
    playerMP = playerMaxMP;
  }
  //オブジェクトの初期データを決定する(レベルにより決定)
  Player(int x){
    playerLevel = x;
    int upStates[]= new int[3];
    for(int i=0;i<playerLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    playerMaxHP = upStates[0]*HP_UP;
    playerMaxMP = upStates[1];
    playerAttack = upStates[2];
    playerAttribution = new Attribution();
    playerState = new StateEffect();
    playerHP = playerMaxHP;
    playerMP = playerMaxMP;
    playerItem[0] = new Item(-playerMaxHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "薬草");
    itemGoods++;
  }
//名前を決めるメソッド
  void setName(String str){
    playerName=str;
    System.out.println(playerName);
  }
  //HPの計算を行うメソッド
  void HPCalc(int d){
    playerHP-=d;
    if(playerHP<DOWN_HP){
      playerHP=DOWN_HP;
    }
  }
  //MPを計算するメソッド
  void MPCalc(int d){
    playerMP-=d;
    if(playerMP<NO_MP){
      playerMP=NO_MP;
    }
  }
  void setAttack(double x){
    playerAttack *= x;
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
  //レベルを返す
  int getLevel(){
    return playerLevel;
  }
  //最大HPを返す
  int getMaxHP(){
    return playerMaxHP;
  }

  //Skillクラスを読み取り消費MPを返す
  int getSkillCost(int x){
    return playerSkill[x].getSkillCost();
  }
  //Skillクラスを読み取り倍率を返す
  double getSkillBonus(int x){
    return playerSkill[x].getSkillBonus();
  }
  void setSkill(double x, int y,int z, String s){
    playerSkill[skillGoods] = new Skill(x, y, z, s);
    skillGoods++;
    if(skillGoods >= MAX_SKILLGOODS){
      skillGoods = MAX_SKILLGOODS-1;
    }
  }
  void setSkill(Skill s){
    playerSkill[skillGoods] = s;
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
    return playerSkill[x].getSkillName();
  }
  //スキルがどういう効果か返す
  int getSkillType(int x){
    return playerSkill[x].getSkillType();
  }

  //Itemクラスを読み取りアイテムの所持数を返す
  int getItemCount(int x){
    return playerItem[x].getItemCount();
  }
  //Itemクラスを読み取りアイテムの効果を返す
  int getItemEffect(int x){
    return playerItem[x].getItemEffect();
  }
  //アイテムの名前を返す
  String getItemName(int x){
    return playerItem[x].getItemName();
  }
  //アイテムの所持数を減らす
  int itemLost(int x){
    return playerItem[x].itemLost();
  }
  //アイテムの所持数を変える
  void countChange(int x, int i){
    playerItem[i].countChange(x);
  }
  //アイテムを追加する
  void setItem(int x, int y, int z, String s){
    playerItem[itemGoods] = new Item(x, y, z, s);
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS-1;
    }
  }
  void setItem(Item i){
    playerItem[itemGoods] = i;
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS-1;
    }
  }
  void setItem(Item i, int x){
    playerItem[itemGoods] = i;
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
    return playerItem[x].getItemType();
  }

  //属性を返す
  int getAttribution(){
    return playerAttribution.getAttribution();
  }
  //状態異常を設定する
  void setStateEffect(int x){
     playerState.setStateEffect(x);
  }
  //状態異常を確認しつつ一歩進める
  boolean getStateEffect(){
    return playerState.getStateEffect();
  }
  //状態異常を確認する
  boolean checkStateEffect(){
    return playerState.checkStateEffect();
  }
}
