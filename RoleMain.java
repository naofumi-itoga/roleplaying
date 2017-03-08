import java.io.*;
class RoleMain {
  public static void main(String args[]){
    int damage;//�_���[�W�v�Z�p�ϐ�
    boolean actionFlag;//�s���������ǂ����̔���
    PlayerStatus ps = new PlayerStatus(100, 10, 20);
    EnemyStatus es1 = new EnemyStatus(150, 22, 60);
    Ability ab1 = new Ability(1.8, 2);

      do{
        statusDisplay(ps,es1);
        actionFlag=false;
        while(!actionFlag){
          System.out.println("�s����I�����Ă��������B\n1.�U�� 2.���Z 3.���� 4.����");
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//���͂��ꂽ�������󂯎��
            int re = Integer.parseInt(buf);//������int�^��
            if(re == 1){
              damage = damageCalc(ps.getAttack());//�_���[�W�v�Z
              System.out.println("�G��" + damage + "�̃_���[�W");
              es1.HPCalc(damage);
              actionFlag=true;
            }else if(re == 2){


            }else if(re == 3){

            }else if(re == 4){

            }else{
              System.out.println("1~4�̒�����I�����Ă�������");
            }
          }catch(Exception e){
          }
        };
    }while(es1.getHP()>0) ;

  }
//HP��MP��\�����郁�\�b�h
  public static void statusDisplay(PlayerStatus ps, EnemyStatus es){
    System.out.println("������HP:" + ps.getHP());
    System.out.println("������MP:" + ps.getMP());
    System.out.println("�G��HP:" + es.getHP());
  }
//�_���[�W�̌v�Z���s�����\�b�h
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;
    System.out.println(rand);
    return ((at*rand)/100);
  }
}
//�v���C���[�̃X�e�[�^�X��ۑ�����N���X
class PlayerStatus {
  private String playerName;
  private int playerHP;
  private int playerMP;
  private int playerAttack;

  PlayerStatus(int x,int y,int z){
    playerHP = x;
    playerMP = y;
    playerAttack = z;
  }
//���O�����߂郁�\�b�h
  void nameSet(String str){
    playerName=str;
    System.out.println(playerName);
  }
  //HP�̌v�Z���s�����\�b�h
  void HPCalc(int d){
    playerHP-=d;
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
}
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
//���Z�̏���ۑ����郁�\�b�h
class Ability{
  private double abilityBonus;
  private int abilityCost;

  Ability(double x, int y){
    abilityBonus = x;
    abilityCost = y;
  }
//���Z�̐��\��Ԃ����\�b�h
  double getAbilityBonus(){
    return abilityBonus;
  }
  int getAbilityCost(){
    return abilityCost;
  }
}
