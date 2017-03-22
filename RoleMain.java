import java.io.*;

class RoleMain {
  //�萔
  public static final int PL_HP = 200; //�v���C���[��HP
  public static final int PL_MP = 10; //�v���C���[��MP
  public static final int PL_AT = 20; //�v���C���[�̍U����
  public static final int CP_HP = 250; //CPU��HP
  public static final int CP_AT = 22; //CPU�̍U����
  public static final int CP_E = 60; //CPU���瓦���邱�Ƃ��ł���m��
  public static final int PLAYER_LEVEL_WIDTH = 20; //�v���C���[�̃��x����
  public static final int ENEMY_LEVEL_WIDTH = 35; //CPU�̃��x����
  public static final int PLAYER_LEVEL_LOWEST = 10; //�v���C��[���x���̍Œ�l
  public static final int ENEMY_LEVEL_LOWEST = 1; //CPU���x���̍Œ�l
  public static final int ATTACK_COMMAND = 1; //�U����I��
  public static final int SKILL_COMMAND = 2; //���Z��I��
  public static final int ITEM_COMMAND = 3; //�����I��
  public static final int ESCAPE_COMMAND = 4; //�������I��
  public static final int DAMAGE_WIDTH = 40; //�_���[�W�{���̐U�ꕝ
  public static final int DAMAGE_LOWEST = 80; //�_���[�W�̍Œ�{��
  public static final int PARALYSIS = 1; //��Ⴢ�t�^
  public static final int PARALYSIS_ATTACK_PROBABILITY = 20; //��ჍU�����s���m��
  public static final int YES = 1; //���Z�Ɠ���Ŏg�p����Ɖ�
  public static final int HUNDRED_PERCENT = 100; //�P�O�O�A���Ƃ��Ŏg��
  public static final int NO_ITEM = 0; //����ȉ��Ȃ瓹��g�p�ł��Ȃ�
  public static final int DOWN_HP = 0; //���̐����ȉ��ɂȂ�����|���
  public static final int PINCH_HP = 4; //�ő�l�����̐���=�Ђ�
  public static final int ATTRIBUTION_PLUS1 = 2; //����Ȃ瓾�ӂȑ���
  public static final int ATTRIBUTION_PLUS2 = -1; //��������ӂȑ���
  public static final int ATTRIBUTION_MINUS1 = -2; //���ȑ���
  public static final int ATTRIBUTION_MINUS2 = 1; //���ȑ���
  public static final double ATTRIBUTION_BUFF = 1.4; //���ӂȑ������̃{�[�i�X
  public static final double ATTRIBUTION_DEBUFF = 0.7; //���ȑ������̃{�[�i�X
  public static final double ATTRIBUTION_NOBUFF = 1.0; //�ʏ�̑������U��
  public static final int HEAL_ITEM = 0; //�񕜓���
  public static final int ATTACK_ITEM = 1; //�U������
  public static final int OTHER_ITEM = 2; //���̑�����
  public static final int HEAL_SKILL = 0; //�񕜓��Z
  public static final int ATTACK_SKILL = 1; //�U�����Z
  public static final int POWER_UP_SKILL = 2; //�������Z
  public static final int GET_HERB = 50; //�򑐂��l������m��
  public static final int MIN_HEAL = -50; //�Œ�񕜗�
  public static final int MAX_ITEM_GOODS = 100; //�����ł��铹��̍ő吔
  public static final int MAX_GET_ITEM = 10; //��x�Ɋl���ł���A�C�e���̍ő吔
  public static final int MIN_GET_ITEM = 1; //��x�Ɋl���ł���A�C�e���̍Œᐔ
  public static final int MAX_SKILLGOODS = 100; //�����ł���X�L���̍ő吔

  //�ϐ�
  public static int count; //�^�[����
  public static Item allItem[] = new Item[MAX_ITEM_GOODS-1]; //���ׂẴA�C�e��
  public static Skill allSkill[] = new Skill[MAX_SKILLGOODS-1]; //���ׂĂ̓��Z

  //Main�A����̐���������Ȃ�
  public static void main(String args[]){
    //�o�Ă�����Z�A�A�C�e���̐ݒ�
    allItem[0] = new Item((int)(Math.random() * -HUNDRED_PERCENT)+MIN_HEAL, (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, HEAL_ITEM, "��");
    allItem[1] = new Item((int)(Math.random() * HUNDRED_PERCENT), (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, ATTACK_ITEM, "��");
    allSkill[0] = new Skill(1.8, 2, ATTACK_SKILL, "�X���b�V��");
    allSkill[1] = new Skill(8, 10, ATTACK_SKILL, "�u���N���b�V��");
    allSkill[2] = new Skill(-2, 3, HEAL_SKILL, "����");
    allSkill[3] = new Skill(1.3, 5, POWER_UP_SKILL, "�͗�");
    boolean escapeSuccess; //�����邱�Ƃɐ����������ǂ���
    boolean actionFlag; //�s���������ǂ���
    boolean continuation=true;
    //Player player = new Player(PL_HP, PL_MP, PL_AT);//�v���C���[�̃X�e�[�^�X�쐬
    Player player = new Player((int)(Math.random() * PLAYER_LEVEL_WIDTH) + PLAYER_LEVEL_LOWEST); //�v���C���[�̃��x���ō쐬
    //Enemy enemy1 = new Enemy(CP_HP, CP_AT, CP_E);//CPU�̃X�e�[�^�X�쐬
    //Enemy enemy1 = new Enemy((int)(Math.random()*ENEMY_LEVEL_WIDTH)+LEVELLOWEST);//CPU�̃��x���ō쐬
    //Display display = new Display(player, enemy1);//�R���\�[���̕`��֌W
/*    player.setSkill(1.8, 2, ATTACK_SKILL, "�X���b�V��");
    player.setItem(-player.getMaxHP()/5, 1, HEAL_ITEM, "��");
    player.setSkill(8, 10, ATTACK_SKILL, "�u���N���b�V��");
    player.setSkill(-2, 3, HEAL_SKILL, "����");
    player.setSkill(1.3, 5, POWER_UP_SKILL, "�͗�");*/
    //�v���C���[�̎g�p�ł�����̂Ƃ��āA���Z�Ɠ���Z�b�g
    player.setItem(allItem[0]);
    player.setSkill(allSkill[0]);
    player.setSkill(allSkill[1]);
    player.setSkill(allSkill[2]);
    player.setSkill(allSkill[3]);
    //�v���C���[��HP���O�ɂȂ邩�A�����邱�Ƃ���߂�܂Ń��[�v
    //���O����

    String nameBuf = null;
    do{
      System.out.println("�l�����ȉ��Ńv���C���[�̖��O����͂��Ă�������");
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        nameBuf = br.readLine(); //���͂��ꂽ�������󂯎��
        player.setName(nameBuf);
      }catch(Exception e){
      }
    }while(nameBuf.length() > 4 || nameBuf.isEmpty());

    while(continuation){
      escapeSuccess = false; //�������s���
      Enemy enemy1 = new Enemy((int)(Math.random() * ENEMY_LEVEL_WIDTH) + ENEMY_LEVEL_LOWEST); //CPU�̃��x���ō쐬
      enemy1.setName("�I�I�J�~");
      //Display display = new Display(player, enemy1); //�R���\�[���̕`��֌W
      Display display = new Display(player, enemy1); //�R���\�[���̕`��֌W
      //�v���C���[�ƓG�A������HP���c���Ă��āA�����ɐ������Ă��Ȃ��ꍇ�J��Ԃ�
      while(enemy1.getHP() > DOWN_HP && !escapeSuccess && player.getHP() > DOWN_HP){
    //    count++;

        //display.setLog(count + "�^�[����");
        actionFlag = false;
        if(beforeAttackEffect(player)){
          actionFlag = true;
        }
        while(!actionFlag){ //�s�����s���܂ŌJ��Ԃ�
          //display.choiseAction(); //�s���I���̕\��

          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine(); //���͂��ꂽ�������󂯎��
            int re = Integer.parseInt(buf); //������int�^��
            //1,2,3,4�̂Ȃɂ����͂��ꂽ���A����ɂ���čs�����ω�
            switch(re){
              case (ATTACK_COMMAND):
                actionFlag = normalAttack(player, enemy1, display); //�ʏ�U�����s��
                break;
              case (SKILL_COMMAND):
                actionFlag = skillAttack(player, enemy1, display); //���Z���g�p����
                break;
              case (ITEM_COMMAND):
                actionFlag = itemUse(player, enemy1, display); //������g�p����
                break;
              case (ESCAPE_COMMAND):
                actionFlag = true;
                escapeSuccess = escape(player, enemy1, display); //��������
                break;
              default:
                System.out.println("1~4�̒�����I�����Ă�������");
            }
            /*if(re == ATTACK_COMMAND){
              //�ʏ�U���̏���
              actionFlag = normalAttack(player, enemy1, display);
            }else if(re == SKILL_COMMAND){
              //���Z�̏���
              actionFlag = skillAttack(player, enemy1, display);
            }else if(re == ITEM_COMMAND){
              //����̏���
              actionFlag = itemUse(player, enemy1, display);
            }else if(re == ESCAPE_COMMAND){
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
        if(enemy1.getHP() > DOWN_HP && !escapeSuccess){
          enemyTurn(player, enemy1, display); //�G�̍s���̏�����
        }

        display.statusDisplay(player, enemy1); //�G��HP�̕\��
        display.choiseAction(); //�s���I���̕\��
        display.setLog("_____________");
      }
      display.result(player, enemy1); //�퓬���ʂ̕\��
      gainItem(player, enemy1); //�A�C�e�����l��
      //�v���C���[��HP������ꍇ�I�������o��
      if(player.getHP() > DOWN_HP){
        player.levelUp(enemy1.getExperience());
        System.out.println("���֐i�݂܂����H1:YES, 2:NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine(); //���͂��ꂽ�������󂯎��
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
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST;
    return (int)((at * bt * rand) / HUNDRED_PERCENT);
  }
  /*
  //�G�̍U��
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~120�܂ł͈̗̔͂���
    return (int)((at*rand)/100);
  }*/
  //�ʏ�U��+����
  public static int damageCalc(int at, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST;
    return (int)((at * rand * attributionBonus) / HUNDRED_PERCENT);
  }
  //�X�L���U��+����
  public static int damageCalc(int at, double bt, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST;
    return (int)((at * bt * rand * attributionBonus) / HUNDRED_PERCENT);
  }
  //�G�̍U��+����
  public static int damageCalc(int at, Enemy enemy, Player player){
    double attributionBonus = getAttributionBonus(enemy, player);
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST; //80~120�܂ł͈̗̔͂���
    return (int)((at * rand * attributionBonus) / HUNDRED_PERCENT);
  }

  //�ʏ�U����I�������ꍇ�̏���
  public static boolean normalAttack(Player player, Enemy enemy, Display display){
    int damage;//�_���[�W�v�Z�p�ϐ�
    damage = damageCalc(player.getAttack(), player, enemy); //�_���[�W�v�Z
    enemy.HPCalc(damage);
    display.setCenterLog(damage);
    display.setLog(display.damageDisplay(damage, enemy));
    return true;
  }

  //���Z��I�������ꍇ�̏���
  public static boolean skillAttack(Player player, Enemy enemy, Display display){
    //�v���C���[���������Ă���X�L���̐������J��Ԃ�
    for(int i = 0; i < player.getSkillGoods(); i++){
      System.out.println(player.getSkillName(i) + "���g�p���܂���? ����MP" + player.getSkillCost(i) + "\n1.YES 2.NO");
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        if(re == YES){
          //MP������MP�������Ă�����s���ł���
          if(player.getMP() >= player.getSkillCost(i)){
            //�X�L���ɂ���Č��ʂ�ς���
            switch(player.getSkillType(i)){
              //HP��
              case (HEAL_SKILL):
                int damage = damageCalc(player.getAttack(), player.getSkillBonus(i)); //�_���[�W�v�Z
                player.MPCalc(player.getSkillCost(i));
                if(player.getHP() - damage >= player.getMaxHP()){
                  damage = player.getHP() - player.getMaxHP();
                }
                player.HPCalc(damage);
                display.setCenterLog(damage);
                display.setLog(display.damageDisplay(damage, player));
                return true;
                //�G�Ƀ_���[�W
              case (ATTACK_SKILL):
                damage = damageCalc(player.getAttack(), player.getSkillBonus(i), player, enemy); //�_���[�W�v�Z
                player.MPCalc(player.getSkillCost(i));
                enemy.HPCalc(damage);
                display.setCenterLog(damage);
                display.setLog(display.damageDisplay(damage, enemy));
                return true;
                //�U���̓A�b�v
              case (POWER_UP_SKILL):
                player.MPCalc(player.getSkillCost(i));
                player.setAttack(player.getSkillBonus(i));
                return true;
              default:
                System.out.println("���ʂ͂Ȃ�����");
                return true;
            }
          }else{
            System.out.println("MP������Ȃ�");
            break;
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
    //�������Ă��铹��̐������J��Ԃ�
    for(int i = 0; i < player.getItemGoods(); i++){
      //����������A�C�e���͕\�����Ȃ�
      if(player.getItemCount(i) > NO_ITEM){
        System.out.println(player.getItemName(i) + "���g�p���܂���?�@������:" + player.getItemCount(i) + "\n1.YES 2.NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine();
          int re = Integer.parseInt(buf);
          if(re == YES){
            //��������Ă��邩�ǂ���
            if(player.itemLost(i) >= NO_ITEM){
              switch(player.getItemType(i)){
                //�񕜃A�C�e��
                case (HEAL_ITEM):
                  int damage = player.getItemEffect(i); //�_���[�W�v�Z�p�ϐ�
                  if(player.getHP() - damage >= player.getMaxHP()){
                    damage = player.getHP() - player.getMaxHP();
                  }
                  player.HPCalc(damage);
                  display.setLog(display.damageDisplay(damage,player));
                  return true;
                  //�U���A�C�e��
                case (ATTACK_ITEM):
                  damage=player.getItemEffect(i); //�_���[�W�v�Z�p�ϐ�
                  enemy.HPCalc(damage);
                  display.setLog(display.damageDisplay(damage, enemy));
                  return true;
                default:
                  System.out.println("���ʂ͂Ȃ�����");
                  return true;
              }
            }else{
              player.countChange(NO_ITEM, i);
              System.out.println("������������Ȃ�");
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
    int rand = (int)(Math.random() * HUNDRED_PERCENT); //0~100�܂ł̗���
    if(rand > enemy.getEscape()){
      System.out.println("�������s");
      return false;
    }else{
      System.out.println("��������");
      return true;
    }
  }

  //����̍s��
  public static void enemyTurn(Player player, Enemy enemy, Display display){
    //�򑐂��g�p�ł��邩�ǂ���
    if(enemy.getHP() <= enemy.getMaxHP() / PINCH_HP && enemy.itemLost() >= NO_ITEM){
      int damage = enemy.getItemEffect(); //�_���[�W�v�Z�p�ϐ�
      enemy.itemLost();
      if(enemy.getHP() - damage >= enemy.getMaxHP()){
        damage = enemy.getHP() - enemy.getMaxHP();
      }
      enemy.HPCalc(damage);
      display.setLog(display.damageDisplay(damage, enemy));
    }else{
      //�򑐂��g�p���Ȃ������ꍇ�m���Ŗ�ჍU��or�ʏ�U��
      int rand = (int)(Math.random() * HUNDRED_PERCENT);
      if(rand >= PARALYSIS_ATTACK_PROBABILITY){
        int damage; //�_���[�W�v�Z�p�ϐ�
        damage = damageCalc(enemy.getAttack(), enemy, player); //�_���[�W�v�Z
        player.HPCalc(damage);
        display.setLog(display.damageDisplay(damage, player));
      }else{
        if(!player.checkStateEffect()){
          player.setStateEffect(PARALYSIS);
          display.setLog("��ჍU����H�����");
        }else{
          display.setLog("��ჍU���͊O�ꂽ");
        }
      }
    }
  }

  //�����ɂ�鋭��
  public static double getAttributionBonus(Player player, Enemy enemy){
    if(player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_PLUS1 || player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS1 ||player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS2){
      return ATTRIBUTION_DEBUFF;
    }else{
      return ATTRIBUTION_NOBUFF;
    }
  }
  //�����ɂ�鋭��i�G�j
  public static double getAttributionBonus(Enemy enemy, Player player){
    if(enemy.getAttribution() - player.getAttribution() == ATTRIBUTION_PLUS1 || enemy.getAttribution() - player.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(enemy.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS1 || enemy.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS2){
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
    //�G��|���ăo�g�����I�����̂�
    if(enemy.getHP() <= DOWN_HP){
      //�T�O���̊m���Ŗ򑐁A����ȊO�̏ꍇ�͐�
      if((int)(Math.random() * HUNDRED_PERCENT) >= GET_HERB){
        player.setItem((int)(Math.random() * -HUNDRED_PERCENT)+MIN_HEAL, (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, HEAL_ITEM, "��");
      }else{
        player.setItem((int)(Math.random()*HUNDRED_PERCENT), (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, HEAL_ITEM, "��");
      }
      System.out.println(player.getItemName(player.getItemGoods() - 1) + "��" + player.getItemCount(player.getItemGoods() - 1) + "��ɓ��ꂽ");
    }
  }

/*  public static void loop(){
    for(int i = 0; i<MAX_ITEMGOODS; i++){
      if(!(allItem[i] == null)){
        System.out.println(i);
      }else{
        System.out.println("asa");
        break;
      }
    }
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();//���͂��ꂽ�������󂯎��
      int re = Integer.parseInt(buf);//������int�^��
    }catch(Exception e){
      System.out.println("��������͂��Ă�������");
    }
  }*/
}
