//CPU�̃X�e�[�^�X��ۑ�����N���X
class EnemyStatus {
  private String enemyName;
  private int enemyHP;
  private int enemyAttack;
  private int escapeProbability;

  EnemyStatus(int x, int y, int z){
    enemyHP = x;
    enemyAttack = y;
    escapeProbability = z;
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
  int getEscape(){
    return escapeProbability;
  }
}
