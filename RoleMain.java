import java.io.*;
import java.util.*;

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
  public static final int NO = 2; //���Z�⓹��Ȃǂ̓���łm�n
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
  public static final int POWER_UP_ITEM = 2; //�U���㏸����
  public static final int POWER_DOWN_ITEM = 3; //�U�����~����
  public static final int OTHER_ITEM = 4; //���̑�����
  public static final int HEAL_SKILL = 0; //�񕜓��Z
  public static final int ATTACK_SKILL = 1; //�U�����Z
  public static final int POWER_UP_SKILL = 2; //�������Z
  public static final int GET_HERB = 80; //�򑐂��l������m��
  public static final int GET_STONE = 60; //�΂��l������m��
  public static final int GET_RARE = 40; //���̓G�ŗL�̃A�C�e�����l������m��
  public static final int NO_DROP = 20; //�A�C�e�����l���ł��Ȃ��m��
  public static final int MIN_HEAL = -50; //�Œ�񕜗�
  public static final int MAX_ITEM_GOODS = 100; //�����ł��铹��̍ő吔
  public static final int MAX_GET_ITEM = 10; //��x�Ɋl���ł���A�C�e���̍ő吔
  public static final int MIN_GET_ITEM = 1; //��x�Ɋl���ł���A�C�e���̍Œᐔ
  public static final int MAX_SKILLGOODS = 100; //�����ł���X�L���̍ő吔
  public static final boolean LOOP = true; //while�����[�v������
  public static final String RIGHT_CHARACTER = "���������͂��Ă�������"; //���������͂��s���Ȃ��������ɕ\��
  public static final String RIGHT_NUMBER = "��������͂��Ă�������"; //�����������̓��͂��s���Ȃ������Ƃ��ɕ\��
  public static final int RETURN = 0; //���Z�⓹��Ŗ߂��I��
  public static final int INN = 1; //�h��I��
  public static final int CURIO_SHOP = 2; //�����I��
  public static final int DUNGEON = 3; //�_���W������I��
  public static final int END = 4; //�I����I��
  public static final int GO_RIGHT = 1; //�E�֐i��
  public static final int GO_STRAIGHT = 2; //��֐i��
  public static final int GO_LEFT = 3; //���֐i��
  public static final int TURN_BACK = 4; //���֐i��
  public static final String DUNGEON_NAMES[] = {"����", "���A"};
  public static final int TOTAL_DUNGEON = 2; //�_���W�����̑���

  //�ϐ�
  public static List<Item> allItem = new ArrayList<Item>(); //���ׂẴA�C�e��
  public static List<Skill> allSkill = new ArrayList<Skill>(); //���ׂĂ̓��Z

  //Main�A����̐���������Ȃ�
  public static void main(String args[]){
    //�o�Ă�����Z�A�A�C�e���̐ݒ�
    allItem.add(new Item(-(HUNDRED_PERCENT)+MIN_HEAL, MAX_GET_ITEM, HEAL_ITEM, "�K��"));
    allItem.add(new Item(150, MIN_GET_ITEM, ATTACK_ITEM, "�����i�C�t"));
    allItem.add(new Item(2000, MIN_GET_ITEM, HEAL_ITEM, "�G���N�T�["));
    allItem.add(new Item(2, MIN_GET_ITEM, POWER_DOWN_ITEM, "�X����"));
    allItem.add(new Item(2, MIN_GET_ITEM, POWER_UP_ITEM, "�킢�̃h����"));
    allSkill.add(new Skill(1.8, 2, ATTACK_SKILL, "�X���b�V��"));
    allSkill.add(new Skill(5, 10, ATTACK_SKILL, "�u���N���b�V��"));
    allSkill.add(new Skill(-2, 5, HEAL_SKILL, "����"));
    allSkill.add(new Skill(1.3, 5, POWER_UP_SKILL, "�͗�"));
    allSkill.add(new Skill(-1.5, 2, HEAL_SKILL, "�����̕�"));
    allSkill.add(new Skill(8, 20, ATTACK_SKILL, "��"));
    allSkill.add(new Skill(2.5, 20, POWER_UP_SKILL, "�o�[�X�g"));
    allSkill.add(new Skill(-5, 20, HEAL_SKILL, "���z"));

    //Player player = new Player(PL_HP, PL_MP, PL_AT);//�v���C���[�̃X�e�[�^�X�쐬
    //Player player = new Player((int)(Math.random() * PLAYER_LEVEL_WIDTH) + PLAYER_LEVEL_LOWEST); //�v���C���[�̃��x���ō쐬
    Player player = new Player(99);
    //�v���C���[�̎g�p�ł�����̂Ƃ��āA���Z�Ɠ���Z�b�g
    player.setSkill(allSkill.get(0));
    player.setSkill(allSkill.get(1));
    player.setSkill(allSkill.get(2));
    player.setSkill(allSkill.get(3));
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
    Display display = new Display(player); //�R���\�[���̕`��֌W
    //�_���W�����̍쐬
    Dungeon dungeons = new Dungeon();
    //���߂͊X��
    dungeons = town(player, display);

    while(dungeons != null){
      //�o�g���ɓ���
      int dungeonEvent = goToDungeon(display, dungeons);
      switch(dungeonEvent){
        case 1:
          dungeons = battle(player, display, dungeons);
        case 2:
      }
      if(dungeons.getNowX() == dungeons.getGoalX() && dungeons.getNowY() == dungeons.getGoalY()){
        System.out.println("�Ő[���ɂ��ǂ蒅����");
        boolean ableToGet = player.setItem(dungeons.getTreasure());
        if(ableToGet){
          System.out.println("�������ɓ��ꂽ");
        }else{
          System.out.println("�������ɓ���邱�Ƃ��ł��Ȃ�����");
        }
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        }catch(Exception e){
        }
        dungeons = town(player, display);
      }
    }
    System.out.println("owari");
  }

  //�퓬�������s�����\�b�h
  public static Dungeon battle(Player player, Display display, Dungeon dungeons){

    boolean escapeSuccess = false; //�����邱�Ƃɐ����������ǂ���
    boolean actionFlag; //�s���������ǂ���
    boolean enableInput = true;
    System.out.println(dungeons.getAverageLevel());
    //Enemy enemy = new Enemy((int)(Math.random() * ENEMY_LEVEL_WIDTH) + ENEMY_LEVEL_LOWEST); //CPU�̃��x���ō쐬
    Enemy enemy = new Enemy(dungeons.getAverageLevel() * ((int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST) / 100);//Dungeon���傤�ق�����G���쐬
    enemy.setDropItem(dungeons.getEnemyDropItem());
    enemy.setName(dungeons.getEnemyName());
    display.setCenterLog(null);
    //�v���C���[�ƓG�A������HP���c���Ă��āA�����ɐ������Ă��Ȃ��ꍇ�J��Ԃ�
    while(enemy.getHP() > DOWN_HP && !escapeSuccess && player.getHP() > DOWN_HP){
      actionFlag = false;
      if(beforeAttackEffect(player)){
        actionFlag = true;
      }
      while(!actionFlag){ //�s�����s���܂ŌJ��Ԃ�
        enableInput = false;
        display.statusDisplay(player, enemy); //�G��HP�̕\��
        display.choiseAction(); //�s���I���̕\��
        System.out.println(dungeons.getDepth());
        //display.choiseAction(); //�s���I���̕\��
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine(); //���͂��ꂽ�������󂯎��
            int re = Integer.parseInt(buf); //������int�^��
            //1,2,3,4�̂Ȃɂ����͂��ꂽ���A����ɂ���čs�����ω�
            switch(re){
              case (ATTACK_COMMAND):
                actionFlag = normalAttack(player, enemy, display); //�ʏ�U�����s��
                enableInput = true;
                break;
              case (SKILL_COMMAND):
                actionFlag = skillAttack(player, enemy, display); //���Z���g�p����
                enableInput = true;
                break;
              case (ITEM_COMMAND):
                actionFlag = itemUse(player, enemy, display); //������g�p����
                enableInput = true;
                break;
              case (ESCAPE_COMMAND):
                actionFlag = true;
                escapeSuccess = escape(player, enemy, display); //��������
                enableInput = true;
                break;
              default:
                display.setCenterLog(RIGHT_CHARACTER);
              }
          /*if(re == ATTACK_COMMAND){
            //�ʏ�U���̏���
            actionFlag = normalAttack(player, enemy, display);
          }else if(re == SKILL_COMMAND){
            //���Z�̏���
            actionFlag = skillAttack(player, enemy, display);
          }else if(re == ITEM_COMMAND){
            //����̏���
            actionFlag = itemUse(player, enemy, display);
          }else if(re == ESCAPE_COMMAND){
            //������̏���
            actionFlag = true;
            escapeSuccess = escape(player, enemy, display);
          }else{
            System.out.println("1~4�̒�����I�����Ă�������");
          }*/
          }catch(Exception e){
            display.setCenterLog(RIGHT_NUMBER);
            enableInput = false;
          }
      }
      //�G��HP���c���Ă��ĂȂ��������ɐ������Ă��Ȃ��ꍇ�Ɏ��s
      if(enemy.getHP() > DOWN_HP && !escapeSuccess){
        enemyTurn(player, enemy, display); //�G�̍s���̏�����
      }
      display.setLog("_____________");
    }
    display.statusDisplay(player, enemy); //�G��HP�̕\��
    display.choiseAction(); //�s���I���̕\��
    display.result(player, enemy); //�퓬���ʂ̕\��
    //�v���C���[��HP������ꍇ�I�������o��
    if(player.getHP() > DOWN_HP){
      //�����ɐ������Ă��Ȃ��������l��
      if(!escapeSuccess){
        if(player.levelUp(enemy.getExperience())){
          switch(player.getLevel()){
            case 100:
              player.setSkill(allSkill.get(4));
              break;
            case 101:
              player.setSkill(allSkill.get(5));
              break;
            case 102:
              player.setSkill(allSkill.get(6));
              break;
            case 103:
              player.setSkill(allSkill.get(7));
              break;
          }
        }
        gainItem(player, enemy); //�A�C�e�����l��
      }
      System.out.println("���֐i�݂܂����H1:YES, 2:NO");
      //���������͂��Ȃ����܂ŌJ��Ԃ�
      while(LOOP){
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine(); //���͂��ꂽ�������󂯎��
          int re = Integer.parseInt(buf);
          if(re == YES){
            //continuation = true;
            return dungeons;
            //break;
          }else if(re == NO){
            display.clearDisplay();
            //continuation = town(player, display);
            return town(player, display);
            //break;
          }else{
            System.out.println(RIGHT_CHARACTER);
          }
        }catch(Exception e){
          System.out.println(RIGHT_NUMBER);
        }
      }
    }else{
      //continuation = false;
      return null;
    }
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
  /*public static boolean skillAttack(Player player, Enemy enemy, Display display){
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
  }*/
  //���Z��I�������ꍇ�̏���(�ꗗ�\����)
  public static boolean skillAttack(Player player, Enemy enemy, Display display){
    display.skillDisplay(player);
    while(LOOP){
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        if(re == RETURN){
          return false;
        }else if(re <= player.getSkillGoods()){
          return skillResult(player, display, enemy, re-1);
        }
        System.out.println(RIGHT_CHARACTER);
      }catch(Exception e){
        System.out.println(RIGHT_NUMBER);
      }
    }
  }
  //�X�L���̌��ʔ���(�ꗗ�\���̏ꍇ)
  public static boolean skillResult(Player player, Display display, Enemy enemy, int i){
    //MP�͑���Ă��邩
    if(player.getMP() >= player.getSkillCost(i)){
      display.setCenterLog(null);
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
          display.setLog(player.getSkillName(i) + "�𔭓�");
          display.setLog(display.damageDisplay(damage, player));
          return true;
        //�G�Ƀ_���[�W
        case (ATTACK_SKILL):
          damage = damageCalc(player.getAttack(), player.getSkillBonus(i), player, enemy); //�_���[�W�v�Z
          player.MPCalc(player.getSkillCost(i));
          enemy.HPCalc(damage);
          display.setCenterLog(damage);
          display.setLog(player.getSkillName(i) + "�𔭓�");
          display.setLog(display.damageDisplay(damage, enemy));
          return true;
        //�U���̓A�b�v
        case (POWER_UP_SKILL):
          player.MPCalc(player.getSkillCost(i));
          player.setAttack(player.getSkillBonus(i));
          display.setLog(player.getSkillName(i) + "�𔭓�");
          return true;
        default:
          display.setLog(player.getSkillName(i) + "�𔭓�");
          display.setLog("���ʂ͂Ȃ�����");
          return true;
      }
    }else{
      display.setCenterLog("MP������Ȃ�");
      return false;
    }
  }

  //������g�p���郁�\�b�h
  /*public static boolean itemUse(Player player, Enemy enemy, Display display){
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
            if(player.getItemCount(i) > NO_ITEM){
              switch(player.getItemType(i)){
                //�񕜃A�C�e��
                case (HEAL_ITEM):
                  int damage = player.getItemEffect(i); //�_���[�W�v�Z�p�ϐ�
                  if(player.getHP() - damage >= player.getMaxHP()){
                    damage = player.getHP() - player.getMaxHP();
                  }
                  player.HPCalc(damage);
                  display.setLog(display.damageDisplay(damage,player));
                  player.itemLost(i);
                  return true;
                  //�U���A�C�e��
                case (ATTACK_ITEM):
                  damage=player.getItemEffect(i); //�_���[�W�v�Z�p�ϐ�
                  enemy.HPCalc(damage);
                  display.setLog(display.damageDisplay(damage, enemy));
                  player.itemLost(i);
                  return true;
                default:
                  System.out.println("���ʂ͂Ȃ�����");
                  player.itemLost(i);
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
  }*/
  //����g�p�i�ꗗ�\���j
  public static boolean itemUse(Player player, Enemy enemy, Display display){
    display.setCenterLog(null);
    while(LOOP){
      display.itemDisplay(player);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        //�O�����͂��ꂽ���ʂ�߂�
        if(re == RETURN){
          return false;
          //���͂��ꂽ��������ސ��ȓ��ŁA�Ȃ����ŏ��������O�łȂ���Γ���g�p
        }else if(re <= player.getItemGoods() && player.getItemCount(re - 1) > NO_ITEM){
          return itemResult(player, display, enemy, re - 1);
        }else if(re <= player.getItemGoods() && player.getItemCount(re - 1) <= NO_ITEM){
          display.setCenterLog("�A�C�e���������Ă��Ȃ�����");
        }else{
          display.setCenterLog(RIGHT_CHARACTER);
        }
      }catch(Exception e){
        display.setCenterLog(RIGHT_NUMBER);
      }
    }
  }
  //����̌��ʔ���i�ꗗ�\���p�j
  public static boolean itemResult(Player player, Display display, Enemy enemy, int i){
    //��ނɂ���Č��ʂ�ς���
    display.setCenterLog(null);
    switch(player.getItemType(i)){
      //�񕜃A�C�e��
      case (HEAL_ITEM):
        int damage = player.getItemEffect(i); //�_���[�W�v�Z�p�ϐ�
        if(player.getHP() - damage >= player.getMaxHP()){
          damage = player.getHP() - player.getMaxHP();
        }
        player.HPCalc(damage);
        display.setLog(player.getItemName(i) + "���g�p");
        display.setLog(display.damageDisplay(damage,player));
        player.itemLost(i);
        return true;
      //�U���A�C�e��
      case (ATTACK_ITEM):
        damage=player.getItemEffect(i); //�_���[�W�v�Z�p�ϐ�
        enemy.HPCalc(damage);
        display.setLog(player.getItemName(i) + "���g�p");
        display.setLog(display.damageDisplay(damage, enemy));
        player.itemLost(i);
        return true;
      case (POWER_UP_ITEM):
        player.setAttack(player.getItemEffect(i));
        display.setLog(player.getItemName(i) + "���g�p");
        player.itemLost(i);
        return true;
      case(POWER_DOWN_ITEM):
      enemy.setAttack(player.getItemEffect(i));
      display.setLog(player.getItemName(i) + "���g�p");
      player.itemLost(i);
      return true;
      default:
        display.setLog(player.getItemName(i) + "���g�p");
        display.setLog("���ʂ͂Ȃ�����");
        return true;
      }
    }

  //��������p
  public static boolean escape(Player player, Enemy enemy, Display display){
    int rand = (int)(Math.random() * HUNDRED_PERCENT); //0~100�܂ł̗���
    if(rand > enemy.getEscape()){
      display.setCenterLog("�������s");
      return false;
    }else{
      display.setCenterLog("��������");
      return true;
    }
  }

  //����̍s��
  public static void enemyTurn(Player player, Enemy enemy, Display display){
    //�򑐂��g�p�ł��邩�ǂ���
    if(enemy.getHP() <= enemy.getMaxHP() / PINCH_HP && enemy.getItemCount() > NO_ITEM){
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
    //�T�O���̊m���Ŗ򑐁A����ȊO�̏ꍇ�͐�
    boolean ableToGet = false;
    int effect;
    int count = 0;
    int type;
    String str = "";
    int rnd = (int)(Math.random() * HUNDRED_PERCENT);
    if(rnd >= GET_HERB){
      effect = (int)(Math.random() * -HUNDRED_PERCENT) + MIN_HEAL;
      count = (int)(Math.random() * MAX_GET_ITEM) + MIN_GET_ITEM;
      type = HEAL_ITEM;
      str = "��";
      ableToGet = player.setItem(effect, count, type, str);
    }else if(rnd >= GET_STONE){
      effect = (int)(Math.random() * HUNDRED_PERCENT) + MIN_HEAL;
      count = (int)(Math.random() * MAX_GET_ITEM) + MIN_GET_ITEM;
      type = ATTACK_ITEM;
      str = "��";
      ableToGet = player.setItem(effect, count, type, str);
    }else if(rnd >= GET_RARE){
      effect = enemy.getDropItemEffect();
      count = enemy.getDropItemCount();
      type = enemy.getDropItemType();
      str = enemy.getDropItemName();
      ableToGet = player.setItem(effect, count, type, str);
    }else if(rnd >= NO_DROP){
      switch(rnd % 5){
        case 0:
          effect = allItem.get(0).getItemEffect();
          count = allItem.get(0).getItemCount();
          type = allItem.get(0).getItemType();
          str = allItem.get(0).getItemName();
          break;
        case 1:
          effect = allItem.get(1).getItemEffect();
          count = allItem.get(1).getItemCount();
          type = allItem.get(1).getItemType();
          str = allItem.get(1).getItemName();
          break;
        case 2:
          effect = allItem.get(2).getItemEffect();
          count = allItem.get(2).getItemCount();
          type = allItem.get(2).getItemType();
          str = allItem.get(2).getItemName();
          break;
        case 3:
          effect = allItem.get(3).getItemEffect();
          count = allItem.get(3).getItemCount();
          type = allItem.get(3).getItemType();
          str = allItem.get(3).getItemName();
          break;
        case 4:
          effect = allItem.get(4).getItemEffect();
          count = allItem.get(4).getItemCount();
          type = allItem.get(4).getItemType();
          str = allItem.get(4).getItemName();
          break;
        default:
          effect = allItem.get(5).getItemEffect();
          count = allItem.get(5).getItemCount();
          type = allItem.get(5).getItemType();
          str = allItem.get(5).getItemName();
          break;
      }
      ableToGet = player.setItem(effect, count, type, str);
    }
    if(ableToGet){
      System.out.println(str + "��" + count + "��ɓ��ꂽ");
    }else{
      System.out.println("�������ɓ���邱�Ƃ��ł��Ȃ�����");
    }
  }

  //�퓬�̍��Ԃɓ�����w��������x�񂾂�
  public static Dungeon town(Player player, Display display){
    display.setCenterLog(null);
    String choises[] = {"�h", "���", "�_���W����", "�I������"};
      while(LOOP){
        display.townDisplay(player.getMoney(), choises);
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine(); //���͂��ꂽ�������󂯎��
          int re = Integer.parseInt(buf);
          switch(re){
            case INN:
              inn(player, display);
              break;
            case CURIO_SHOP:
              curioShop(player, display);
              break;
            case DUNGEON:
              return dungeonChoise(display);
            case END:
              return null;
            default:
              display.setCenterLog(RIGHT_CHARACTER);
          }
        }catch(Exception e){
          display.setCenterLog(RIGHT_NUMBER);
        }
    }
  }

  //�h ����������΂g�o���񕜂ł���
  public static void inn(Player player, Display display){
    String choises[] = {"�x��", "�h����o��"};
    display.setCenterLog("�h�ɒ�����");
    //���܂邩�A��܂Ń��[�v
    while(LOOP){
      display.townDisplay(player.getMoney(), choises);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        //���܂邩�A�邩
        if(re == 1){
          System.out.println("�ꔑ500en�ƂȂ��Ă���܂�\n1.YES 2.NO");
          buf = br.readLine(); //���͂��ꂽ�������󂯎��
          re = Integer.parseInt(buf);
          //�����𕥂��Ă�������
          if(re == YES){
            //�����͑���Ă��邩
            if(player.getMoney() >= 500){
              System.out.println("�h�ŋx��Ŕ��������\n�g�o�Ƃl�o���񕜂���\n�u�܂����炵�Ă��������v\n");
              player.healCompleteRecovery();
              player.changeMoney(-500);
              display.setCenterLog(null);
              buf = br.readLine(); //���������͂����܂ŃX�g�b�v
              break;
            }else{
              display.setCenterLog("����������Ȃ�����");
            }
          }else if(re == NO){
            display.setCenterLog("���܂邱�Ƃ���߂�");
          }else{
            display.setCenterLog(RIGHT_CHARACTER);
          }
        }else if(re == 2){
          display.setCenterLog("���������ɋA����");
          break;
        }else{
          display.setCenterLog(RIGHT_CHARACTER);
        }
      }catch(Exception e){
          display.setCenterLog(RIGHT_NUMBER);
      }
    }
  }
  //����A����𔃂����蔄������
  public static void curioShop(Player player, Display display){
    String choises[] = {"����", "����", "�X����o��"};
    display.setCenterLog("����ɒ�����");
    //�����Ă���A�C�e���̌���
    List<Item> shopItem = new ArrayList<Item>();
    for(int i = (int)(Math.random() * 9); i < 9; i++){
      int effect;
      int count;
      int type;
      String str;
      if((int)(Math.random() * HUNDRED_PERCENT) >= GET_HERB){
        effect = (int)(Math.random() * -HUNDRED_PERCENT) + MIN_HEAL;
        count = (int)(Math.random() * MAX_GET_ITEM) + MIN_GET_ITEM;
        type = HEAL_ITEM;
        str = "��";
      }else{
        effect = (int)(Math.random() * HUNDRED_PERCENT);
        count = (int)(Math.random() * MAX_GET_ITEM) + MIN_GET_ITEM;
        type = ATTACK_ITEM;
        str = "��";
      }
      shopItem.add(new Item(effect, count, type, str));
    }
    //�A��܂Ń��[�v
    do{
      display.townDisplay(player.getMoney(), choises);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        //���������邩�A�邩
        switch(re){
          case 1:
            buy(player, display, shopItem);
            continue;
          case 2:
            sell(player, display);
            continue;
          case 3:
            display.setCenterLog("�������A���Ă���");
            break;
          default:
            display.setCenterLog(RIGHT_CHARACTER);
            continue;
        }
        break;
        //�������͂ŕ�������͂����ꍇ�A�����A����A�X���o��܂Ŗ߂�
      }catch(Exception e){
          display.setCenterLog(RIGHT_NUMBER);
      }
    }while(LOOP);
  }
  //�������\�b�h
  public static void buy(Player player, Display display, List<Item> shopItem){
    display.setCenterLog(null);
    while(LOOP){
      display.itemDisplay(shopItem);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        //0�����͂��ꂽ��߂�
        if(re == RETURN){
          break;
          //���̔ԍ��̃A�C�e�������݂����Ƃ��w������
        }else if(re <= shopItem.size()){
          if(player.getMoney() >= Math.abs(shopItem.get(re-1).getItemEffect()) * shopItem.get(re - 1).getItemCount()){
            boolean bo = player.setItem(shopItem.get(re - 1));
            if(bo){
              display.setCenterLog(shopItem.get(re-1).getItemName() + "��" + shopItem.get(re-1).getItemCount() + "�w������");
              player.changeMoney(-1 * (Math.abs(shopItem.get(re-1).getItemEffect())) * shopItem.get(re - 1).getItemCount());
            }else{
              display.setCenterLog("����ȏ㎝�ĂȂ�");
            }
          }else{
            display.setCenterLog("����������Ȃ�����");
          }
        }else{
          display.setCenterLog(RIGHT_CHARACTER);
        }
      }catch(Exception e){
        display.setCenterLog(RIGHT_NUMBER);
      }
    }
  }
  //���郁�\�b�h
  public static void sell(Player player, Display display){
    display.setCenterLog(null);
    while(LOOP){
      display.itemDisplay(player);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        //0�����͂��ꂽ��߂�
        if(re == RETURN){
          break;
          //���̔ԍ��̃A�C�e�������݂����Ƃ��w������
        }else if(re <= player.getItemGoods() && player.getItemCount(re - 1) > NO_ITEM){
          System.out.println("�{����" + player.getItemName(re - 1) + "�𔄂��Ă���낵���ł����H\n1:YES 2:NO");
          buf = br.readLine(); //���͂��ꂽ�������󂯎��
          int or = Integer.parseInt(buf);
          if(or == YES){
            display.setCenterLog(player.getItemName(re - 1) + "�𔄂�܂���");
            player.changeMoney((Math.abs(player.getItemEffect(re - 1))) * player.getItemCount(re - 1));
            player.itemCountChange(NO_ITEM, re - 1);
          }else if(or == NO){
            display.setCenterLog("����̂���߂�");
          }else{
            display.setCenterLog(RIGHT_CHARACTER);
          }
        }else{
          display.setCenterLog(RIGHT_CHARACTER);
        }
      }catch(Exception e){
        display.setCenterLog(RIGHT_NUMBER);
      }
    }
  }
  //�_���W�����I�����s��
  public static Dungeon dungeonChoise(Display display){
    display.setCenterLog(null);
    while(LOOP){
      display.dungeonChoiseDisplay(TOTAL_DUNGEON, DUNGEON_NAMES);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        switch(re){
          case 0:
            return null;
          case 1:
            return new GrassDungeon();
          case 2:
            return new CaveDungeon();
          default:
            display.setCenterLog(RIGHT_CHARACTER);
        }
      }catch(Exception e){
        display.setCenterLog(RIGHT_NUMBER);
      }
    }
  }

  //�_���W�����T��
  public static int goToDungeon(Display display, Dungeon dungeons){
    int x = dungeons.getNowX();
    int y = dungeons.getNowY();
    display.setCenterLog(x + "a" + y);
    while(LOOP){
      display.dungeonDisplay(dungeons, x, y);
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //���͂��ꂽ�������󂯎��
        int re = Integer.parseInt(buf);
        switch(re){
          case 0:
            break;
            //�E
          case GO_RIGHT:
              switch(dungeons.searchDungeon(x + 1, y)){
                case 0:
                  display.setCenterLog("���̕����ɂ͐i�߂Ȃ�");
                  break;
                default:
                  dungeons.setNow(x + 1, y);
                  return dungeons.searchDungeon(x + 1, y);
              }
            break;
          case GO_STRAIGHT:
              switch(dungeons.searchDungeon(x, y - 1)){
                case 0:
                  display.setCenterLog("���̕����ɂ͐i�߂Ȃ�");
                  break;
                default:
                  dungeons.setNow(x, y - 1);
                  return dungeons.searchDungeon(x, y - 1);
              }
              break;
          case GO_LEFT:
            switch(dungeons.searchDungeon(x - 1, y)){
              case 0:
                display.setCenterLog("���̕����ɂ͐i�߂Ȃ�");
                break;
              default:
                dungeons.setNow(x - 1, y);
                return dungeons.searchDungeon(x - 1, y);
            }
            break;
          case TURN_BACK:
              switch(dungeons.searchDungeon(x, y + 1)){
                case 0:
                  display.setCenterLog("���̕����ɂ͐i�߂Ȃ�");
                  break;
                default:
                  dungeons.setNow(x, y + 1);
                  return dungeons.searchDungeon(x, y + 1);
              }
              break;
          default:
            display.setCenterLog(RIGHT_CHARACTER);
        }
      }catch(Exception e){
        display.setCenterLog(RIGHT_NUMBER);
      }
    }
  }
}
