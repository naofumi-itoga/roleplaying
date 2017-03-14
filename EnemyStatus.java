//CPU�̃X�e�[�^�X��ۑ�����N���X
class EnemyStatus {
  private String enemyName;
  private int enemyHP;
  private int enemyAttack;
  private int escapeProbability;
  private Attribution enemyAttribution;
  private int enemyLevel;
  //�I�u�W�F�N�g�̏����f�[�^�����肷��
  EnemyStatus(int x, int y, int z){
    enemyHP = x;
    enemyAttack = y;
    escapeProbability = z;
    enemyAttribution = new Attribution();
  }
  EnemyStatus(int x){
    enemyLevel = x;
    int upStates[]= new int[2];
    for(int i=0;i<enemyLevel;i++){
      for(int j=0;j<upStates.length;j++){
        int rnd = (int)(Math.random()*3);
        System.out.println("���̐��オ����"+rnd);
        upStates[j] += rnd;
      }
    }
    enemyHP = upStates[0]*10;
    enemyAttack = upStates[1];
    enemyAttribution = new Attribution();
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
  int getAttribution(){
    return enemyAttribution.getAttribution();
  }
  int getLevel(){
    return enemyLevel;
  }
}
