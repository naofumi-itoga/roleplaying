//���Z�̏���ۑ����郁�\�b�h
class Skill{
  private double skillBonus;
  private int skillCost;
  private String skillName;

  //���Z�̏������肷��
  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
  //���O����͂���ꍇ�͂�����
  Skill(double x, int y, String s){
    skillBonus = x;
    skillCost = y;
    skillName = s;
  }
//���Z�̐��\��Ԃ����\�b�h
  double getSkillBonus(){
    return skillBonus;
  }
  //���Z�ŏ����MP��Ԃ�
  int getSkillCost(){
    return skillCost;
  }
}
