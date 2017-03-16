//CPU�̃X�e�[�^�X��ۑ�����N���X
class Enemy {
  private String enemyName;//�G�̖��O
  private int enemyHP;//�G��HP
  private int enemyAttack;//�G�̍U����
  private int escapeProbability;//�G���瓦������m��
  private Attribution enemyAttribution;//�G�̑���
  private int enemyLevel;//�G�̃��x��
  private Item enemyUseItem;//�G�̎g�p�ł���A�C�e��
  private int enemyMaxHP;//�G�̍ő�HP
  public static final int HEAL_ITEM = 0;//�G�̉񕜓���
  public static final int ATTACK_ITEM = 1;//�G�̍U������
  public static final int OTHER_ITEM = 2;//�G�̂��̑��̓���
  public static final int HEAL_HERB = 5;//�򑐂̉񕜗�
  public static final int HAVE_HERB = 1;//�G���������Ă���򑐂̐�
  public static final int MAX_UP = 3;//���x���A�b�v���̔\�͂̍ő�㏸�l
  public static final int HP_UP = 10;//�ق��̔\�͂ɔ�ׁAHP���ǂ̒��x�オ��₷����
  public static final int MAX_ESCAPE = 100;//�ő�̓����邱�Ƃ��ł���m��
  public static final int ESCAPE_LINEAR = 2;//���x�������ꁁ�������Ȃ��m��
  public static final int DOWN_HP = 0;//�|���HP
  //�I�u�W�F�N�g�̏����f�[�^�����肷��
  Enemy(int x, int y, int z){
    enemyMaxHP = x;
    enemyHP = enemyMaxHP;;
    enemyAttack = y;
    escapeProbability = z;
    enemyAttribution = new Attribution();
  }
  //�����f�[�^�����x���ɂ���Č��肷��
  Enemy(int x){
    enemyLevel = x;
    int upStates[]= new int[2];
    for(int i=0;i<enemyLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*MAX_UP);
        upStates[j] += rnd;
      }
    }
    enemyMaxHP = upStates[0]*HP_UP;
    enemyHP = enemyMaxHP;
    enemyAttack = upStates[1];
    enemyAttribution = new Attribution();
    enemyUseItem = new Item(-enemyHP/HEAL_HERB, HAVE_HERB, HEAL_ITEM, "��");
    escapeProbability = (MAX_ESCAPE-x*ESCAPE_LINEAR);
  }
  //CPU��HP���v�Z���郁�\�b�h
  void HPCalc(int d){
    enemyHP-=d;
    if(enemyHP<DOWN_HP){
      enemyHP=DOWN_HP;
    }
  }
  //CPU�̃X�e�[�^�X��Ԃ����\�b�h
  int getHP(){
    return enemyHP;
  }
  int getAttack(){
    return enemyAttack;
  }
  //CPU�ɑ΂��ē������I�������ۂ̐����m����Ԃ�
  int getEscape(){
    return escapeProbability;
  }
  //������Ԃ�
  int getAttribution(){
    return enemyAttribution.getAttribution();
  }
  //���x����Ԃ�
  int getLevel(){
    return enemyLevel;
  }
  //��������HP��Ԃ�
  int getMaxHP(){
    return enemyMaxHP;
  }
  int getItemCount(){
    return enemyUseItem.getItemCount();
  }
  //Item�N���X��ǂݎ��A�C�e���̌��ʂ�Ԃ�
  int getItemEffect(){
    return enemyUseItem.getItemEffect();
  }
  //�A�C�e���̖��O��Ԃ�
  String getItemName(){
    return enemyUseItem.getItemName();
  }
  //�A�C�e���̏����������炷
  int itemLost(){
    return enemyUseItem.itemLost();
  }
}
