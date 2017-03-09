//プレイヤーのステータスを保存するクラス
class PlayerStatus {
  private String playerName;
  private int playerHP;
  private int playerMP;
  private int playerAttack;
  Skill playerSkill;
  Item playerItem;

  PlayerStatus(int x,int y,int z){
    playerHP = x;
    playerMP = y;
    playerAttack = z;
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-40, 1);
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
  int getSkillCost(){
    return playerSkill.getSkillCost();
  }
  double getSkillBonus(){
    return playerSkill.getSkillBonus();
  }
}
