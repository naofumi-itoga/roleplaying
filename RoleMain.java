import java.io.*;
class RoleMain {
  public static void main(String args[]){

    boolean actionFlag;//�s���������ǂ����̔���
    PlayerStatus ps = new PlayerStatus(100, 10, 20);
    EnemyStatus es1 = new EnemyStatus(200, 22, 60);
    Skill sk1 = new Skill(1.8, 2);
    Item it = new Item(-40, 1);
    Display di = new Display(ps, es1);
      do{

        actionFlag=false;
        while(!actionFlag){
          di.choiseAction();
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//���͂��ꂽ�������󂯎��
            int re = Integer.parseInt(buf);//������int�^��
            if(re == 1){
              actionFlag = normalAttack(ps, es1, di);
            }else if(re == 2){
              actionFlag = skillAttack(ps, es1, di);
            }else if(re == 3){

            }else if(re == 4){

            }else{
              System.out.println("1~4�̒�����I�����Ă�������");
            }
           di.statusDisplay(ps, es1);
          }catch(Exception e){
          }
        };
    }while(es1.getHP()>0);

  }

//�_���[�W�̌v�Z���s�����\�b�h
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;
//    System.out.println(rand);
    return ((at*rand)/100);
  }
  public static int damageCalc(int at, double bt){
    int rand = (int)(Math.random()*40)+80;
//    System.out.println(rand);
    return (int)((at*bt*rand)/100);
  }
  public static boolean normalAttack(PlayerStatus ps, EnemyStatus es, Display di){
    int damage;//�_���[�W�v�Z�p�ϐ�
    damage = damageCalc(ps.getAttack());//�_���[�W�v�Z
    es.HPCalc(damage);
    //di.statusDisplay(ps, es);
    di.damageDisplay(damage);
    return true;
  }
  public static boolean skillAttack(PlayerStatus ps, EnemyStatus es, Display di){
    System.out.println("���Z���g�p���܂���?����MP" + ps.getSkillCost());
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();//���͂��ꂽ�������󂯎��
      int re = Integer.parseInt(buf);
      if(re == 1){
        if(ps.getMP()>=ps.getSkillCost()){
          int damage;//�_���[�W�v�Z�p�ϐ�
          damage = damageCalc(ps.getAttack(), ps.getSkillBonus());//�_���[�W�v�Z
          ps.MPCalc(ps.getSkillCost());
          es.HPCalc(damage);
      //  di.statusDisplay(ps, es);
          di.damageDisplay(damage);
          return true;
        //actionFlag = skillAttack(ps, es1, di);
        }else{
          System.out.println("MP������Ȃ�");
        }
      }
    }catch(Exception e){
    }
    return false;
  }
}
