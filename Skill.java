//���Z�̏���ۑ����郁�\�b�h
class Skill{
  private double skillBonus;
  private int skillCost;
  private String skillName;
  public static final int HEALSKILL = 0;//�񕜓��Z
  public static final int ATTACKSKILL = 1;//�U�����Z
  public static final int OTHERSKILL = 2;//���̑����Z
  private int skillType;//���̓��Z�̎��

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
  String getSkillName(){
    return skillName;
  }
}
