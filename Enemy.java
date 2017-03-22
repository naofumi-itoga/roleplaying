//CPU�̃X�e�[�^�X��ۑ�����N���X
class Enemy {
  //�萔
  public static final int HEAL_ITEM = 0; //�G�̉񕜓���
  public static final int ATTACK_ITEM = 1; //�G�̍U������
  public static final int OTHER_ITEM = 2; //�G�̂��̑��̓���
  public static final int HEAL_HERB = 5; //�򑐂̉񕜗�
  public static final int HAVE_HERB = 1; //�G���������Ă���򑐂̐�
  public static final int MAX_UP = 3; //���x���A�b�v���̔\�͂̍ő�㏸�l
  public static final int HP_UP = 10; //�ق��̔\�͂ɔ�ׁAHP���ǂ̒��x�オ��₷����
  public static final int MAX_ESCAPE = 100; //�ő�̓����邱�Ƃ��ł���m��
  public static final int ESCAPE_LINEAR = 2; //���x�������ꁁ�������Ȃ��m��
  public static final int DOWN_HP = 0; //�|���HP
  //�ϐ�
  private String name; //�G�̖��O
  private int HP; //�G��HP
  private int attack; //�G�̍U����
  private int escapeProbability; //�G���瓦������m��
  private int level; //�G�̃��x��
  private int maxHP; //�G�̍ő�HP
  private Attribution attribution; //�G�̑���
  private Item useItem; //�G�̎g�p�ł���A�C�e��

  //�I�u�W�F�N�g�̏����f�[�^�����肷��
  Enemy(int x, int y, int z){
    maxHP = x;
    HP = maxHP;;
    attack = y;
    escapeProbability = z;
    attribution = new Attribution();
  }
  //�����f�[�^�����x���ɂ���Č��肷��
  Enemy(int x){
    level = x;
    int upStates[]= new int[2];
    for(int i=0;i<level;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    maxHP = upStates[0]*HP_UP;
    HP = maxHP;
    attack = upStates[1];
    attribution = new Attribution();
    useItem = new Item(-HP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "��");
    escapeProbability = (MAX_ESCAPE-x*ESCAPE_LINEAR);
  }
  void setName(String str){
    name = str;
  }
  //CPU��HP���v�Z���郁�\�b�h
  void HPCalc(int d){
    HP-=d;
    if(HP<DOWN_HP){
      HP=DOWN_HP;
    }
  }
  //CPU�̃X�e�[�^�X��Ԃ����\�b�h
  int getHP(){
    return HP;
  }
  int getAttack(){
    return attack;
  }
  //CPU�ɑ΂��ē������I�������ۂ̐����m����Ԃ�
  int getEscape(){
    return escapeProbability;
  }
  //������Ԃ�
  int getAttribution(){
    return attribution.getAttribution();
  }
  //���x����Ԃ�
  int getLevel(){
    return level;
  }
  //��������HP��Ԃ�
  int getMaxHP(){
    return maxHP;
  }
  String getName(){
    return name;
  }
  int getItemCount(){
    return useItem.getItemCount();
  }
  //Item�N���X��ǂݎ��A�C�e���̌��ʂ�Ԃ�
  int getItemEffect(){
    return useItem.getItemEffect();
  }
  //�A�C�e���̖��O��Ԃ�
  String getItemName(){
    return useItem.getItemName();
  }
  //�A�C�e���̏����������炷
  int itemLost(){
    return useItem.itemLost();
  }
}
