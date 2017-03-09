import java.io.*;

class RoleMain {
  //Main�A����̐���������Ȃ�
  public static void main(String args[]){
    boolean escapeSuccess=false;//�����邱�Ƃɐ����������ǂ���
    boolean actionFlag;//�s���������ǂ���
    PlayerStatus ps = new PlayerStatus(100, 10, 20);//�v���C���[�̃X�e�[�^�X
    EnemyStatus es1 = new EnemyStatus(175, 22, 60);//CPU�̃X�e�[�^�X
    Display di = new Display(ps, es1);//�R���\�[���̕`��֌W
    //�v���C���[�ƓG�A������HP���c���Ă��āA�����ɐ������Ă��Ȃ��ꍇ�J��Ԃ�
      while(es1.getHP()>0&&!escapeSuccess&&ps.getHP()>0){
        actionFlag=false;
        while(!actionFlag){//�s�����s���܂ŌJ��Ԃ�
          di.choiseAction();
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//���͂��ꂽ�������󂯎��
            int re = Integer.parseInt(buf);//������int�^��
            //1,2,3,4�̂Ȃɂ����͂��ꂽ��
            if(re == 1){
              //�ʏ�U���̏���
              actionFlag = normalAttack(ps, es1, di);
            }else if(re == 2){
              //���Z�̏���
              actionFlag = skillAttack(ps, es1, di);
            }else if(re == 3){
              //����̏���
              actionFlag = itemUse(ps, es1, di);
            }else if(re == 4){
              //������̏���
              actionFlag = true;
              escapeSuccess = escape(ps, es1, di);
            }else{
              System.out.println("1~4�̒�����I�����Ă�������");
            }
          }catch(Exception e){
          }
        }
        //�G��HP���c���Ă��ĂȂ��������ɐ������Ă��Ȃ��ꍇ�Ɏ��s
        if(es1.getHP()>0&&!escapeSuccess){
          enemyTurn(ps, es1, di);//�G�̍s���̏�����
        }
        di.statusDisplay(ps, es1);
    }
    di.result(ps, es1);
    System.out.println("owari");
  }

//�_���[�W�̌v�Z���s�����\�b�h
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~12�܂ł͈̗̔͂���
    return ((at*rand)/100);
  }
  //�X�L���ɂ��_���[�W�v�Z���s�����\�b�h
  public static int damageCalc(int at, double bt){
    int rand = (int)(Math.random()*40)+80;
    return (int)((at*bt*rand)/100);
  }

  //�ʏ�U���̔���
  public static boolean normalAttack(PlayerStatus ps, EnemyStatus es, Display di){
    int damage;//�_���[�W�v�Z�p�ϐ�
    damage = damageCalc(ps.getAttack());//�_���[�W�v�Z
    es.HPCalc(damage);
    //di.statusDisplay(ps, es);
    di.damageDisplay(damage,es);
    return true;
  }

  //���Z�ɂ��U���̔���
  public static boolean skillAttack(PlayerStatus ps, EnemyStatus es, Display di){
    System.out.println("���Z���g�p���܂���? ����MP" + ps.getSkillCost() + "\n1.YES 2.NO");
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();//���͂��ꂽ�������󂯎��
      int re = Integer.parseInt(buf);
      if(re == 1){
        //MP������MP�������Ă�����s���ł���
        if(ps.getMP()>=ps.getSkillCost()){
          int damage;//�_���[�W�v�Z�p�ϐ�
          damage = damageCalc(ps.getAttack(), ps.getSkillBonus());//�_���[�W�v�Z
          ps.MPCalc(ps.getSkillCost());
          es.HPCalc(damage);
          di.damageDisplay(damage,es);
          return true;
        }else{
          System.out.println("MP������Ȃ�");
        }
      }
    }catch(Exception e){
    }
    return false;
  }

  //������g�p���郁�\�b�h
  public static boolean itemUse(PlayerStatus ps, EnemyStatus es, Display di){
    System.out.println(ps.getItemName() + "���g�p���܂���?�@������:" + ps.getItemCount() + "\n1.YES 2.NO");
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();
      int re = Integer.parseInt(buf);
      if(re == 1){
        //��������Ă��邩�ǂ���
        if(ps.getItemCount()-1>=0){
          int damage=ps.getItemEffect();//�_���[�W�v�Z�p�ϐ�
          ps.itemLost();
          ps.HPCalc(damage);
          di.damageDisplay(damage,ps);
          return true;
        }else{
          System.out.println("�򑐂�����Ȃ�");
        }
      }
    }catch(Exception e){
    }
    return false;
  }

  //��������p
  public static boolean escape(PlayerStatus ps, EnemyStatus es, Display di){
    int rand = (int)(Math.random()*100);//0~100�܂ł̗���
    if(rand > es.getEscape()){
      System.out.println("�������s");
      return false;
    }else{
      System.out.println("��������");
      return true;
    }
  }

  //����̍s��
  public static void enemyTurn(PlayerStatus ps,EnemyStatus es, Display di){
    int damage;//�_���[�W�v�Z�p�ϐ�
    damage = damageCalc(es.getAttack());//�_���[�W�v�Z
    ps.HPCalc(damage);
    di.damageDisplay(damage,ps);
  }
}
