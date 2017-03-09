//プレイヤーのステータスを保存するクラス
class PlayerStatus {
  private String playerName;
  private int playerHP;
  private int playerMP;
  private int playerAttack;
  Skill playerSkill;
  Item playerItem;
  //オブジェクトの初期データを決定する
  PlayerStatus(int x,int y,int z){
    playerHP = x;
    playerMP = y;
    playerAttack = z;
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-60, 1, "薬草");
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
}
