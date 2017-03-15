//CPU�̃X�e�[�^�X��ۑ�����N���X
class Enemy {
  private String enemyName;
  private int enemyHP;
  private int enemyAttack;
  private int escapeProbability;
  private Attribution enemyAttribution;
  private int enemyLevel;
  private Item enemyUseItem;
  private int enemyMaxHP;
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
        int rnd = (int)(Math.random()*3);
        upStates[j] += rnd;
      }
    }
    enemyMaxHP = upStates[0]*10;
    enemyHP = enemyMaxHP;
    enemyAttack = upStates[1];
    enemyAttribution = new Attribution();
    enemyUseItem = new Item(-enemyHP/5, 1, "��");
    escapeProbability = 60;
  }
  //CPU��HP���v�Z���郁�\�b�h
  void HPCalc(int d){
    enemyHP-=d;
    if(enemyHP<0){
      enemyHP=0;
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
