//���Z�̏���ۑ����郁�\�b�h
class Skill{
  private double skillBonus;
  private int skillCost;

  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
//���Z�̐��\��Ԃ����\�b�h
  double getSkillBonus(){
    return skillBonus;
  }
  int getSkillCost(){
    return skillCost;
  }
}
