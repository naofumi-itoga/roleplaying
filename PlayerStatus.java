//プレイヤーのステータスを保存するクラス
class PlayerStatus {
  private String playerName;
  private int playerHP;
  private int playerMP;
  private int playerAttack;
  private Attribution playerAttribution;
  private Skill playerSkill;
  private Item playerItem;
  private StateEffect playerState;
  private int playerLevel;
  private int playerMaxHP;
  private int playerMaxMP;
  //オブジェクトの初期データを決定する(直接決定)
  PlayerStatus(int x,int y,int z){
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
  PlayerStatus(int x){
    playerLevel = x;
    int upStates[]= new int[3];
    for(int i=0;i<playerLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*3);
        System.out.println("この数上がった"+rnd);
        upStates[j] += rnd;
      }
    }
    playerMaxHP = upStates[0]*10;
    playerMaxMP = upStates[1];
    playerAttack = upStates[2];
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-playerHP/5, 1, "薬草");
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
  //Skikkクラスを読み取り消費MPを返す
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
  void itemLost(){
    playerItem.itemLost();
  }
  int getAttribution(){
    return playerAttribution.getAttribution();
  }
  void setStateEffect(int x){
     playerState.setStateEffect(x);
  }

  boolean getStateEffect(){
    return playerState.getStateEffect();
  }
  boolean checkStateEffect(){
    return playerState.checkStateEffect();
  }
  int getLevel(){
    return playerLevel;
  }
}
