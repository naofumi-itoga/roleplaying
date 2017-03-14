//�v���C���[�̃X�e�[�^�X��ۑ�����N���X
class PlayerStatus {
  private String playerName;
  private int playerHP;
  private int playerMP;
  private int playerAttack;
  private Attribution playerAttribution;
  private Skill playerSkill;
  private Item playerItem;
  private StateEffect playerState;
  //�I�u�W�F�N�g�̏����f�[�^�����肷��
  PlayerStatus(int x,int y,int z){
    playerHP = x;
    playerMP = y;
    playerAttack = z;
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-60, 1, "��");
    playerAttribution = new Attribution();
    playerState = new StateEffect();
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
  //MP���v�Z���郁�\�b�h
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
  //Skikk�N���X��ǂݎ�����MP��Ԃ�
  int getSkillCost(){
    return playerSkill.getSkillCost();
  }
  //Skill�N���X��ǂݎ��{����Ԃ�
  double getSkillBonus(){
    return playerSkill.getSkillBonus();
  }
  //Item�N���X��ǂݎ��A�C�e���̏�������Ԃ�
  int getItemCount(){
    return playerItem.getItemCount();
  }
  //Item�N���X��ǂݎ��A�C�e���̌��ʂ�Ԃ�
  int getItemEffect(){
    return playerItem.getItemEffect();
  }
  //�A�C�e���̖��O��Ԃ�
  String getItemName(){
    return playerItem.getItemName();
  }
  //�A�C�e���̏����������炷
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
}
