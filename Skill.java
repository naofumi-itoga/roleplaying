//特技の情報を保存するメソッド
class Skill{
  private double skillBonus;
  private int skillCost;
  private String skillName;

  //特技の情報を決定する
  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
  //名前を入力する場合はこちら
  Skill(double x, int y, String s){
    skillBonus = x;
    skillCost = y;
    skillName = s;
  }
//特技の性能を返すメソッド
  double getSkillBonus(){
    return skillBonus;
  }
  //特技で消費するMPを返す
  int getSkillCost(){
    return skillCost;
  }
}
