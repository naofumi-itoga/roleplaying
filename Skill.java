//特技の情報を保存するメソッド
class Skill{
  private double skillBonus;
  private int skillCost;

  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
//特技の性能を返すメソッド
  double getSkillBonus(){
    return skillBonus;
  }
  int getSkillCost(){
    return skillCost;
  }
}
