//�v���C���[�̃X�e�[�^�X��ۑ�����N���X
class Player {
  //�萔
  public static final int MAX_UP = 3; //�\�͂�1���x�����Ƃɍő�オ���
  public static final int HP_UP = 10; //�ق��̔\�͂ɔ�ׁAHP���ǂ̒��x�オ��₷����
  public static final int HEAL_ITEM = 0; //�񕜓���
  public static final int ATTACK_ITEM = 1; //�U������
  public static final int OTHER_ITEM =2; //���̑��̓���
  public static final int HEAL_HERB = 2; //�򑐂̉񕜗�
  public static final int HAVE_HERB = 1; //�������Ă���򑐂̐�
  public static final int HEAL_SKILL = 0; //�񕜓��Z
  public static final int ATTACK_SKILL = 1; //�U�����Z
  public static final int POWER_UP_SKILL = 2; //���̑����Z
  public static final int MAX_ITEMGOODS = 100; //�����ł��铹��̍ő吔
  public static final int MAX_SKILLGOODS = 100; //�����ł���X�L���̍ő吔
  public static final int DOWN_HP = 0; //���̐��l�ȉ��ɂȂ�����|���
  public static final int NO_MP = 0; //MP�����̐��l�ȉ��ɂł��Ȃ�
  //�ϐ�
  private String name; //�v���C���[�̖��O
  private int HP; //�v���C���[�̌��݂�HP
  private int MP; //�Ղꂢ��[�̌��݂�MP
  private int attack; //�v���C���[�̍U����
  private int level; //���x��
  private int maxHP; //�ő�HP
  private int maxMP; //�ő�MP
  private int itemGoods = 0; //���ݎ����Ă���A�C�e���̎��
  private int skillGoods = 0; //���ݏ������Ă���X�L���̐�
  private Attribution attribution; //����
  private StateEffect state; //���̏�Ԉُ�
  private Skill skill[] = new Skill[99]; //�����Ă���X�L��
  private Item item[] = new Item[99]; //�����Ă���A�C�e��



  //�I�u�W�F�N�g�̏����f�[�^�����肷��(���ڌ���)
  Player(int x,int y,int z){
    maxHP = x;
    maxMP = y;
    attack = z;
    skill[0] = new Skill(1.8, 2);
    item[0] = new Item(-maxHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "��");
    attribution = new Attribution();
    state = new StateEffect();
    HP = maxHP;
    MP = maxMP;
  }
  //�I�u�W�F�N�g�̏����f�[�^�����肷��(���x���ɂ�茈��)
  Player(int x){
    level = x;
    int upStates[]= new int[3];
    for(int i=0;i<level;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    maxHP = upStates[0]*HP_UP;
    maxMP = upStates[1];
    attack = upStates[2];
    attribution = new Attribution();
    state = new StateEffect();
    HP = maxHP;
    MP = maxMP;
    item[0] = new Item(-maxHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "��");
    itemGoods++;
  }
//���O�����߂郁�\�b�h
  void setName(String str){
    name=str;
  }
  //HP�̌v�Z���s�����\�b�h
  void HPCalc(int d){
    HP-=d;
    if(HP<DOWN_HP){
      HP=DOWN_HP;
    }
  }
  //MP���v�Z���郁�\�b�h
  void MPCalc(int d){
    MP-=d;
    if(MP<NO_MP){
      MP=NO_MP;
    }
  }
  void setAttack(double x){
    attack *= x;
  }
//�N���X�ɕۑ����ꂽ����Ԃ����\�b�h
  int getHP(){
    return HP;
  }
  int getMP(){
    return MP;
  }
  int getAttack(){
    return attack;
  }
  //���x����Ԃ�
  int getLevel(){
    return level;
  }
  //�ő�HP��Ԃ�
  int getMaxHP(){
    return maxHP;
  }
  int getMaxMP(){
    return maxMP;
  }
  String getName(){
    return name;
  }

  //Skill�N���X��ǂݎ�����MP��Ԃ�
  int getSkillCost(int x){
    return skill[x].getSkillCost();
  }
  //Skill�N���X��ǂݎ��{����Ԃ�
  double getSkillBonus(int x){
    return skill[x].getSkillBonus();
  }
  void setSkill(double x, int y,int z, String s){
    skill[skillGoods] = new Skill(x, y, z, s);
    skillGoods++;
    if(skillGoods >= MAX_SKILLGOODS){
      skillGoods = MAX_SKILLGOODS-1;
    }
  }
  void setSkill(Skill s){
    skill[skillGoods] = s;
    skillGoods++;
    if(skillGoods >= MAX_SKILLGOODS){
      skillGoods = MAX_SKILLGOODS-1;
    }
  }
  //�X�L���̎�ސ���Ԃ�
  int getSkillGoods(){
    return skillGoods;
  }
  //�X�L���̖��O��Ԃ�
  String getSkillName(int x){
    return skill[x].getSkillName();
  }
  //�X�L�����ǂ��������ʂ��Ԃ�
  int getSkillType(int x){
    return skill[x].getSkillType();
  }

  //Item�N���X��ǂݎ��A�C�e���̏�������Ԃ�
  int getItemCount(int x){
    return item[x].getItemCount();
  }
  //Item�N���X��ǂݎ��A�C�e���̌��ʂ�Ԃ�
  int getItemEffect(int x){
    return item[x].getItemEffect();
  }
  //�A�C�e���̖��O��Ԃ�
  String getItemName(int x){
    return item[x].getItemName();
  }
  //�A�C�e���̏����������炷
  int itemLost(int x){
    return item[x].itemLost();
  }
  //�A�C�e���̏�������ς���
  void countChange(int x, int i){
    item[i].countChange(x);
  }
  //�A�C�e����ǉ�����
  void setItem(int x, int y, int z, String s){
    item[itemGoods] = new Item(x, y, z, s);
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS-1;
    }
  }
  void setItem(Item i){
    item[itemGoods] = i;
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS-1;
    }
  }
  void setItem(Item i, int x){
    item[itemGoods] = i;
    itemGoods++;
    if(itemGoods >= MAX_ITEMGOODS){
      itemGoods = MAX_ITEMGOODS;
    }
  }
  //�������Ă���A�C�e���̎�ސ���Ԃ�
  int getItemGoods(){
    return itemGoods;
  }
  //�ǂ��������A�C�e�����Ԃ�
  int getItemType(int x){
    return item[x].getItemType();
  }

  //������Ԃ�
  int getAttribution(){
    return attribution.getAttribution();
  }
  //��Ԉُ��ݒ肷��
  void setStateEffect(int x){
     state.setStateEffect(x);
  }
  //��Ԉُ���m�F������i�߂�
  boolean getStateEffect(){
    return state.getStateEffect();
  }
  //��Ԉُ���m�F����
  boolean checkStateEffect(){
    return state.checkStateEffect();
  }
}
