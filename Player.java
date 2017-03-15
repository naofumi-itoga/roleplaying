//�v���C���[�̃X�e�[�^�X��ۑ�����N���X
class Player {
  private String playerName;//�v���C���[�̖��O
  private int playerHP;//�v���C���[�̌��݂�HP
  private int playerMP;//�Ղꂢ��[�̌��݂�MP
  private int playerAttack;//�v���C���[�̍U����
  private Attribution playerAttribution;//����
  private Skill playerSkill;//�����Ă���X�L��
  private Item playerItem;//�����Ă���A�C�e��
  private StateEffect playerState;//���̏�Ԉُ�
  private int playerLevel;//���x��
  private int playerMaxHP;//�ő�HP
  private int playerMaxMP;//�ő�MP
  //�I�u�W�F�N�g�̏����f�[�^�����肷��(���ڌ���)
  Player(int x,int y,int z){
    playerMaxHP = x;
    playerMaxMP = y;
    playerAttack = z;
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-playerHP/5, 1, "��");
    playerAttribution = new Attribution();
    playerState = new StateEffect();
    playerHP = playerMaxHP;
    playerMP = playerMaxMP;
  }
  //�I�u�W�F�N�g�̏����f�[�^�����肷��(���x���ɂ�茈��)
  Player(int x){
    playerLevel = x;
    int upStates[]= new int[3];
    for(int i=0;i<playerLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*3);
        upStates[j] += rnd;
      }
    }
    playerMaxHP = upStates[0]*10;
    playerMaxMP = upStates[1];
    playerAttack = upStates[2];
    playerSkill = new Skill(1.8, 2);
    playerItem = new Item(-playerMaxHP/5, 1, "��");
    playerAttribution = new Attribution();
    playerState = new StateEffect();
    playerHP = playerMaxHP;
    playerMP = playerMaxMP;
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
  //Skill�N���X��ǂݎ�����MP��Ԃ�
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
  int itemLost(){
    return playerItem.itemLost();
  }
  //������Ԃ�
  int getAttribution(){
    return playerAttribution.getAttribution();
  }
  //��Ԉُ��ݒ肷��
  void setStateEffect(int x){
     playerState.setStateEffect(x);
  }
  //��Ԉُ���m�F������i�߂�
  boolean getStateEffect(){
    return playerState.getStateEffect();
  }
  //��Ԉُ���m�F����
  boolean checkStateEffect(){
    return playerState.checkStateEffect();
  }
  //���x����Ԃ�
  int getLevel(){
    return playerLevel;
  }
  //�ő�HP��Ԃ�
  int getMaxHP(){
    return playerMaxHP;
  }

  void countChange(int x){
    playerItem.countChange(x);
  }
}
