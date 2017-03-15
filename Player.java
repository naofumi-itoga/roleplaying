//�v���C���[�̃X�e�[�^�X��ۑ�����N���X
class Player {
  private String playerName;//�v���C���[�̖��O
  private int playerHP;//�v���C���[�̌��݂�HP
  private int playerMP;//�Ղꂢ��[�̌��݂�MP
  private int playerAttack;//�v���C���[�̍U����
  private Attribution playerAttribution;//����
  private Skill playerSkill[] = new Skill[99];//�����Ă���X�L��
  private Item playerItem[] = new Item[99];//�����Ă���A�C�e��
  private StateEffect playerState;//���̏�Ԉُ�
  private int playerLevel;//���x��
  private int playerMaxHP;//�ő�HP
  private int playerMaxMP;//�ő�MP
  private int itemGoods = 1;//���ݎ����Ă���A�C�e���̎��
  private int skillGoods = 1;
  public static final int HEALITEM = 0;//�񕜓���
  public static final int ATTACKITEM = 1;//�U������
  public static final int OTHERITEM =2;//���̑��̓���
  public static final int HEALSKILL = 0;//�񕜓��Z
  public static final int ATTACKSKILL = 1;//�U�����Z
  public static final int OTHERSKILL = 2;//���̑����Z
  //�I�u�W�F�N�g�̏����f�[�^�����肷��(���ڌ���)
  Player(int x,int y,int z){
    playerMaxHP = x;
    playerMaxMP = y;
    playerAttack = z;
    playerSkill[0] = new Skill(1.8, 2);
    playerItem[0] = new Item(-playerHP/5, 1, HEALITEM, "��");
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
    playerSkill[0] = new Skill(1.8, 2, ATTACKSKILL, "�X���b�V��");
    playerItem[0] = new Item(-playerMaxHP/5, 1, HEALITEM, "��");
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
  void setAttack(double x){
    playerAttack *= x;
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
  //���x����Ԃ�
  int getLevel(){
    return playerLevel;
  }
  //�ő�HP��Ԃ�
  int getMaxHP(){
    return playerMaxHP;
  }

  //Skill�N���X��ǂݎ�����MP��Ԃ�
  int getSkillCost(int x){
    return playerSkill[x].getSkillCost();
  }
  //Skill�N���X��ǂݎ��{����Ԃ�
  double getSkillBonus(int x){
    return playerSkill[x].getSkillBonus();
  }
  void setSkill(double x, int y,int z, String s){
    playerSkill[skillGoods] = new Skill(x, y, z, s);
    skillGoods++;
    if(skillGoods >= 100){
      skillGoods=99;
    }
  }
  //�X�L���̎�ސ���Ԃ�
  int getSkillGoods(){
    return skillGoods;
  }
  //�X�L���̖��O��Ԃ�
  String getSkillName(int x){
    return playerSkill[x].getSkillName();
  }
  //�X�L�����ǂ��������ʂ��Ԃ�
  int getSkillType(int x){
    return playerSkill[x].getSkillType();
  }

  //Item�N���X��ǂݎ��A�C�e���̏�������Ԃ�
  int getItemCount(int x){
    return playerItem[x].getItemCount();
  }
  //Item�N���X��ǂݎ��A�C�e���̌��ʂ�Ԃ�
  int getItemEffect(int x){
    return playerItem[x].getItemEffect();
  }
  //�A�C�e���̖��O��Ԃ�
  String getItemName(int x){
    return playerItem[x].getItemName();
  }
  //�A�C�e���̏����������炷
  int itemLost(int x){
    return playerItem[x].itemLost();
  }
  //�A�C�e���̏�������ς���
  void countChange(int x, int i){
    playerItem[i].countChange(x);
  }
  //�A�C�e����ǉ�����
  void setItem(int x, int y, int z, String s){
    playerItem[itemGoods] = new Item(x, y, z, s);
    itemGoods++;
    if(itemGoods >= 100){
      itemGoods=99;
    }
  }
  //�������Ă���A�C�e���̎�ސ���Ԃ�
  int getItemGoods(){
    return itemGoods;
  }
  //�ǂ��������A�C�e�����Ԃ�
  int getItemType(int x){
    return playerItem[x].getItemType();
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
}
