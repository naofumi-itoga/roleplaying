//プレイヤーのステータスを保存するクラス
class Player {
  private String playerName;//プレイヤーの名前
  private int playerHP;//プレイヤーの現在のHP
  private int playerMP;//ぷれいやーの現在のMP
  private int playerAttack;//プレイヤーの攻撃力
  private Attribution playerAttribution;//属性
  private Skill playerSkill;//持っているスキル
  private Item playerItem;//持っているアイテム
  private StateEffect playerState;//今の状態異常
  private int playerLevel;//レベル
  private int playerMaxHP;//最大HP
  private int playerMaxMP;//最大MP
  //オブジェクトの初期データを決定する(直接決定)
  Player(int x,int y,int z){
    playerMaxHP = x;
    playerMaxMP = y;
    playerAttack = z;
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-playerHP/5, 1, "薬草");
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
        int rnd = (int)(Math.random()*3);
        upStates[j] += rnd;
      }
    }
    playerMaxHP = upStates[0]*10;
    playerMaxMP = upStates[1];
    playerAttack = upStates[2];
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-playerMaxHP/5, 1, "薬草");
    playerAttribution = new Attribution();
    playerState = new StateEffect();
    playerHP = playerMaxHP;
    playerMP = playerMaxMP;
  }
//名前を決めるメソッド
  void nameSet(String str){
    playerName=str;
    System.out.println(playerName);
  }
  //HPの計算を行うメソッド
  void HPCalc(int d){
    playerHP-=d;
    if(playerHP<0){
      playerHP=0;
    }
  }
  //MPを計算するメソッド
  void MPCalc(int d){
    playerMP-=d;
    if(playerMP<0){
      playerMP=0;
    }
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
  //Skillクラスを読み取り消費MPを返す
  int getSkillCost(){
    return playerSkill.getSkillCost();
  }
  //Skillクラスを読み取り倍率を返す
  double getSkillBonus(){
    return playerSkill.getSkillBonus();
  }
  //Itemクラスを読み取りアイテムの所持数を返す
  int getItemCount(){
    return playerItem.getItemCount();
  }
  //Itemクラスを読み取りアイテムの効果を返す
  int getItemEffect(){
    return playerItem.getItemEffect();
  }
  //アイテムの名前を返す
  String getItemName(){
    return playerItem.getItemName();
  }
  //アイテムの所持数を減らす
  int itemLost(){
    return playerItem.itemLost();
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
  //レベルを返す
  int getLevel(){
    return playerLevel;
  }
  //最大HPを返す
  int getMaxHP(){
    return playerMaxHP;
  }

  void countChange(int x){
    playerItem.countChange(x);
  }
}
