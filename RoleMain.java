import java.io.*;

class RoleMain {
  public static final int PLHP = 200;//�v���C���[��HP
  public static final int PLMP = 10;//�v���C���[��MP
  public static final int PLAT = 20;//�v���C���[�̍U����
  public static final int CPHP = 250;//CPU��HP
  public static final int CPAT = 22;//CPU�̍U����
  public static final int CPE = 60;//CPU���瓦���邱�Ƃ��ł���m��
  public static final int DAMAGEWIDTH = 40;//�_���[�W�{���̐U�ꕝ
  public static final int DAMAGELOWEST = 80;//�_���[�W�̍Œ�{��
  public static final int PARALYSIS = 1;//��Ⴢ�t�^
  public static final int PLAYERLEVELWIDTH = 30;//�v���C���[�̃��x����
  public static final int ENEMYLEVELWIDTH = 35;//CPU�̃��x����
  public static final int LEVELLOWEST = 1;//���x���̍Œ�l
  public static final int DOWNHP = 0;//���̐����ȉ��ɂȂ�����|���
  public static final int HUNDREDPERCENT = 100;//�P�O�O�A���Ƃ��Ŏg��
  public static final int PARALYSISATTACKPROBABILITY = 20;//��ჍU�����s���m��
  public static final int ATTACKCOMMAND = 1;//�U����I��
  public static final int SKILLCOMMAND = 2;//���Z��I��
  public static final int ITEMCOMMAND = 3;//�����I��
  public static final int ESCAPECOMMAND = 4;//�������I��
  public static final int YES = 1;//���Z�Ɠ���Ŏg�p����Ɖ�
  public static final int NO_ITEM = 0;//����ȉ��Ȃ瓹��g�p�ł��Ȃ�
  public static final int PINCH_HP = 4;//�ő�l�����̐�������΂�
  public static final int ATTRIBUTION_PLUS1 = 2;//����Ȃ瓾�ӂȑ���
  public static final int ATTRIBUTION_PLUS2 = -1;//����
  public static final int ATTRIBUTION_MINUS1 = -2;//���
  public static final int ATTRIBUTION_MINUS2 = 1;//���
  public static final double ATTRIBUTION_BUFF = 2.0;//���ӂȎ��̃{�[�i�X
  public static final double ATTRIBUTION_DEBUFF = 0.5;//���Ȏ��̃{�[�i�X
  public static final double ATTRIBUTION_NOBUFF = 1.0;//�ʏ�̍U��
  public static final int HEALITEM = 0;//�񕜓���
  public static final int ATTACKITEM = 1;//�U������
  public static final int OTHERITEM = 2;//���̑�����
  public static final int HEALSKILL = 0;//�񕜓��Z
  public static final int ATTACKSKILL = 1;//�U�����Z
  public static final int OTHERSKILL = 2;//���̑����Z

  //Main�A����̐���������Ȃ�
  public static void main(String args[]){
    boolean escapeSuccess;//�����邱�Ƃɐ����������ǂ���
    boolean actionFlag;//�s���������ǂ���
    boolean continuation=true;
    //Player player = new Player(PLHP, PLMP, PLAT);//�v���C���[�̃X�e�[�^�X�쐬
    Player player = new Player((int)(Math.random()*PLAYERLEVELWIDTH)+LEVELLOWEST);//�v���C���[�̃��x���ō쐬
    //Enemy enemy1 = new Enemy(CPHP, CPAT, CPE);//CPU�̃X�e�[�^�X�쐬
    //Enemy enemy1 = new Enemy((int)(Math.random()*ENEMYLEVELWIDTH)+LEVELLOWEST);//CPU�̃��x���ō쐬
    //Display display = new Display(player, enemy1);//�R���\�[���̕`��֌W
    player.setSkill(8, 10, ATTACKSKILL, "�u���N���b�V��");
    player.setSkill(-2, 3, HEALSKILL, "����");
    player.setSkill(1.1, 5, OTHERSKILL, "�͗�");
    while(continuation){
      escapeSuccess=false;
      Enemy enemy1 = new Enemy((int)(Math.random()*ENEMYLEVELWIDTH)+LEVELLOWEST);//CPU�̃��x���ō쐬
      Display display = new Display(player, enemy1);//�R���\�[���̕`��֌W
      //�v���C���[�ƓG�A������HP���c���Ă��āA�����ɐ������Ă��Ȃ��ꍇ�J��Ԃ�
      while(enemy1.getHP() > DOWNHP && !escapeSuccess && player.getHP() > DOWNHP){
        actionFlag=false;
        if(beforeAttackEffect(player)){
          actionFlag=true;
        }
        while(!actionFlag){//�s�����s���܂ŌJ��Ԃ�
          display.choiseAction();
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//���͂��ꂽ�������󂯎��
            int re = Integer.parseInt(buf);//������int�^��
            //1,2,3,4�̂Ȃɂ����͂��ꂽ��
            switch(re){
              case (ATTACKCOMMAND):
                actionFlag = normalAttack(player, enemy1, display);
                break;
              case (SKILLCOMMAND):
                actionFlag = skillAttack(player, enemy1, display);
                break;
              case (ITEMCOMMAND):
                actionFlag = itemUse(player, enemy1, display);
                break;
              case (ESCAPECOMMAND):
                actionFlag = true;
                escapeSuccess = escape(player, enemy1, display);
                break;
              default:
                System.out.println("1~4�̒�����I�����Ă�������");
            }
            /*if(re == ATTACKCOMMAND){
              //�ʏ�U���̏���
              actionFlag = normalAttack(player, enemy1, display);
            }else if(re == SKILLCOMMAND){
              //���Z�̏���
              actionFlag = skillAttack(player, enemy1, display);
            }else if(re == ITEMCOMMAND){
              //����̏���
              actionFlag = itemUse(player, enemy1, display);
            }else if(re == ESCAPECOMMAND){
              //������̏���
              actionFlag = true;
              escapeSuccess = escape(player, enemy1, display);
            }else{
              System.out.println("1~4�̒�����I�����Ă�������");
            }*/
          }catch(Exception e){
            System.out.println("��������͂��Ă�������");
          }
        }
        //�G��HP���c���Ă��ĂȂ��������ɐ������Ă��Ȃ��ꍇ�Ɏ��s
        if(enemy1.getHP() > DOWNHP && !escapeSuccess){
          enemyTurn(player, enemy1, display);//�G�̍s���̏�����
        }
        display.statusDisplay(player, enemy1);
      }
      display.result(player, enemy1);
      gainItem(player, enemy1);
      if(player.getHP()>0){
        System.out.println("���֐i�݂܂����H1:YES, 2:NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine();//���͂��ꂽ�������󂯎��
          int re = Integer.parseInt(buf);
          if(re == YES){
            continuation = true;
          }else{
            continuation = false;
          }
        }catch(Exception e){
          System.out.println("��������͂��Ă�������");
        }
      }else{
        continuation = false;
      }
    }
    System.out.println("owari");
  }

//�_���[�W�̌v�Z���s�����\�b�h
/*  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~12�܂ł͈̗̔͂���
    return ((at*rand)/100);
  }*/
  //�X�L���ɂ��_���[�W�v�Z���s�����\�b�h
  public static int damageCalc(int at, double bt){
    int rand = (int)(Math.random()*40)+80;
    return (int)((at*bt*rand)/100);
  }
  /*
  //�G�̍U��
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~12�܂ł͈̗̔͂���
    return (int)((at*rand)/100);
  }*/
  //�ʏ�U���F����
  public static int damageCalc(int at, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random()*DAMAGEWIDTH)+DAMAGELOWEST;
    return (int)((at*rand*attributionBonus)/HUNDREDPERCENT);
  }
  //�X�L���U���F����
  public static int damageCalc(int at, double bt, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random()*DAMAGEWIDTH)+DAMAGELOWEST;
    return (int)((at*bt*rand*attributionBonus)/HUNDREDPERCENT);
  }
  //�G�̍U���F����
  public static int damageCalc(int at, Enemy enemy, Player player){
    double attributionBonus = getAttributionBonus(enemy, player);
    int rand = (int)(Math.random()*DAMAGEWIDTH)+DAMAGELOWEST;//80~12�܂ł͈̗̔͂���
    return (int)((at*rand*attributionBonus)/HUNDREDPERCENT);
  }

  //�ʏ�U���̔���
  public static boolean normalAttack(Player player, Enemy enemy, Display display){
    int damage;//�_���[�W�v�Z�p�ϐ�
    damage = damageCalc(player.getAttack(), player, enemy);//�_���[�W�v�Z
    enemy.HPCalc(damage);
    display.damageDisplay(damage,enemy);
    return true;
  }

  //���Z�ɂ��U���̔���
  public static boolean skillAttack(Player player, Enemy enemy, Display display){
    for(int i = 0; i<player.getSkillGoods(); i++){
      System.out.println(player.getSkillName(i) + "���g�p���܂���? ����MP" + player.getSkillCost(i) + "\n1.YES 2.NO");
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine();//���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        if(re == YES){
          //MP������MP�������Ă�����s���ł���

          if(player.getMP() >= player.getSkillCost(i)){
            switch(player.getSkillType(i)){
              case (HEALSKILL):
                int damage = damageCalc(player.getAttack(), player.getSkillBonus(i));//�_���[�W�v�Z
                player.MPCalc(player.getSkillCost(i));
                if(player.getHP()-damage >= player.getMaxHP()){
                  damage = player.getHP()-player.getMaxHP();
                }
                player.HPCalc(damage);
                display.damageDisplay(damage,player);
                return true;
              case (ATTACKSKILL):
                damage = damageCalc(player.getAttack(), player.getSkillBonus(i), player, enemy);//�_���[�W�v�Z
                player.MPCalc(player.getSkillCost(i));
                enemy.HPCalc(damage);
                display.damageDisplay(damage,enemy);
                return true;
              case (OTHERSKILL):
                player.setAttack(player.getSkillBonus(i));
                return true;
              default:
                System.out.println("���ʂ͂Ȃ�����");
                return true;
            }
          }else{
            System.out.println("MP������Ȃ�");
          }
        }
      }catch(Exception e){
        System.out.println("��������͂��Ă�������");
      }
    }
    return false;
  }

  //������g�p���郁�\�b�h
  public static boolean itemUse(Player player, Enemy enemy, Display display){
    for(int i = 0; i<player.getItemGoods(); i++){
      if(player.getItemCount(i) > 0){
        System.out.println(player.getItemName(i) + "���g�p���܂���?�@������:"
                        + player.getItemCount(i) + "\n1.YES 2.NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine();
          int re = Integer.parseInt(buf);
          if(re == YES){
            //��������Ă��邩�ǂ���
            if(player.itemLost(i) >= NO_ITEM){
              switch(player.getItemType(i)){
                case (HEALITEM):
                  int damage=player.getItemEffect(i);//�_���[�W�v�Z�p�ϐ�
                  if(player.getHP()-damage >= player.getMaxHP()){
                    damage = player.getHP()-player.getMaxHP();
                  }
                  player.HPCalc(damage);
                  display.damageDisplay(damage,player);
                  return true;
                case (ATTACKITEM):
                  damage=player.getItemEffect(i);//�_���[�W�v�Z�p�ϐ�
                  enemy.HPCalc(damage);
                  display.damageDisplay(damage,enemy);
                  return true;
                default:
                  System.out.println("���ʂ͂Ȃ�����");
                  return true;
              }
            }else{
              player.countChange(NO_ITEM, i);
              System.out.println("�򑐂�����Ȃ�");
              return false;
            }
          }
        }catch(Exception e){
          System.out.println("��������͂��Ă�������");
          return false;
        }
      }
    }
    return false;
  }

  //��������p
  public static boolean escape(Player player, Enemy enemy, Display display){
    int rand = (int)(Math.random()*HUNDREDPERCENT);//0~100�܂ł̗���
    if(rand > enemy.getEscape()){
      System.out.println("�������s");
      return false;
    }else{
      System.out.println("��������");
      return true;
    }
  }

  //����̍s��
  public static void enemyTurn(Player player,Enemy enemy, Display display){
    //�򑐂��g�p�ł��邩�ǂ���
    if(enemy.getHP() <= enemy.getMaxHP()/PINCH_HP && enemy.itemLost() >= NO_ITEM){
      int damage=enemy.getItemEffect();//�_���[�W�v�Z�p�ϐ�
      enemy.itemLost();
      if(enemy.getHP()-damage>=enemy.getMaxHP()){
        damage = enemy.getHP()-enemy.getMaxHP();
      }
      enemy.HPCalc(damage);
      display.damageDisplay(damage,enemy);
    }else{
      int rand = (int)(Math.random()*HUNDREDPERCENT);
      if(rand>=PARALYSISATTACKPROBABILITY){
        int damage;//�_���[�W�v�Z�p�ϐ�
        damage = damageCalc(enemy.getAttack(), enemy, player);//�_���[�W�v�Z
        player.HPCalc(damage);
        display.damageDisplay(damage,player);
      }else{
        if(!player.checkStateEffect()){
          player.setStateEffect(PARALYSIS);
          System.out.println("��ჍU����H�����");
        }else{
          System.out.println("���łɖ�Ⴢ��Ă������ߖ�ჍU����H���Ȃ�����");
        }
      }
    }
  }

  //�����ɂ�鋭��
  public static double getAttributionBonus(Player player, Enemy enemy){
    if(player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_PLUS1
        ||player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS1
        ||player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS2){
      return ATTRIBUTION_DEBUFF;
    }else{
      return ATTRIBUTION_NOBUFF;
    }
  }
  //�����ɂ�鋭��i�G�j
  public static double getAttributionBonus(Enemy enemy, Player player){
    if(enemy.getAttribution()-player.getAttribution() == ATTRIBUTION_PLUS1
        ||enemy.getAttribution()-player.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(enemy.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS1
        ||enemy.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS2){
      return ATTRIBUTION_DEBUFF;
    }else{
      return ATTRIBUTION_NOBUFF;
    }
  }
  //��Ⴢɂ������Ă��邩�A�������Ă����ꍇ�̓^�[�����΂�
  public static boolean beforeAttackEffect(Player player){
    if(player.getStateEffect()){
      return true;
    }
    return false;
  }
  //�A�C�e���l��
  public static void gainItem(Player player, Enemy enemy){
    if(enemy.getHP()<=0){
      String str;
      if((int)(Math.random()*HUNDREDPERCENT)>=50){
        str = "��";
        player.setItem((int)(Math.random()*-HUNDREDPERCENT), (int)(Math.random()*10)+1,
                                                          HEALITEM, str);
      }else{
        str = "��";
        player.setItem((int)(Math.random()*HUNDREDPERCENT), (int)(Math.random()*5)+1,
                                                          ATTACKITEM, str);
      }
      System.out.println(player.getItemName(player.getItemGoods()-1) + "��" +
                 player.getItemCount(player.getItemGoods()-1) + "��ɓ��ꂽ");
    }
  }
}
