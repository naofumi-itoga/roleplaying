//�v���C���[�̃X�e�[�^�X��ۑ�����N���X
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
//���O�����߂郁�\�b�h
  void nameSet(String str){
    playerName=str;
    System.out.println(playerName);
  }
  //HP�̌v�Z���s�����\�b�h
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
//�N���X�ɕۑ����ꂽ����Ԃ����\�b�h
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
