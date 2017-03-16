//���Z�̏���ۑ����郁�\�b�h
class Skill{
  //�萔
  public static final int HEAL_SKILL = 0; //�񕜓��Z
  public static final int ATTACK_SKILL = 1; //�U�����Z
  public static final int OTHER_SKILL = 2; //���̑����Z
  //�ϐ�
  private double skillBonus; //�X�L���̔{��
  private int skillCost; //�X�L���̃R�X�g
  private String skillName; //�X�L���̖��O
  private int skillType; //���̓��Z�̎��


  //���Z�̏������肷��
  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
  //���O����͂���ꍇ�͂�����
  Skill(double x, int y, int z, String s){
    skillBonus = x;
    skillCost = y;
    skillName = s;
    skillType = z;
  }
//���Z�̐��\��Ԃ����\�b�h
  double getSkillBonus(){
    return skillBonus;
  }
  //���Z�ŏ����MP��Ԃ�
  int getSkillCost(){
    return skillCost;
  }
  //�X�L���̖��O��Ԃ�
  String getSkillName(){
    return skillName;
  }
  //�X�L�����ǂ��������ʂ��Ԃ��B
  int getSkillType(){
    return skillType;
  }
}
