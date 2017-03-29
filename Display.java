import java.util.*;

class Display {
  //�萔
  public static final int DOWN_HP = 0; //���̐����ȉ��ɂȂ�����|���
  public static final String CLEAR = "\033c"; //��ʂ��N���A
  public static final String BOLD = "\033[1m"; //����
  public static final String BOLD_DEFAULT = "\033[22m"; //���������ɖ߂�
  public static final String BACK_COLOR_BLUE = "\033[44m"; //�w�i�F���
  public static final String BACK_COLOR_BASE = "\033[00m"; //�w�i�F��߂�
  public static final String BACK_COLOR_WHITE = "\033[47m"; //�w�i�F�𔒂�
  public static final String CENTER_LOG_CHANGE = "\033[1;31m"; //�����ɂ��ĕ�����Ԃ�
  public static final String COLOR_DEFAULT = "\033[m"; //�F�������ɖ߂�
  public static final String WINDOW_SIZE = "\033[4;170;370t"; //�R���\�[���̃T�C�Y��170pixel,370pixcel
  public static final String UNDER_SCORE = "\033[4m"; //������t����
  public static final String UNDER_SCORE_RELEASE = "\033[24m"; //����������
  public static final int ESC = 0x1B; //�d�r�b�L�[
  public static final int ALL_EM = 8; //���ׂĂ��啶���̏ꍇ�̃o�C�g��
  public static final int NO_ITEM = 0; //�A�C�e�����Ȃ����
  //�ϐ�
  String logs[] = new String[8]; //�_���[�W�Ȃǂ�ۑ�����
  String centerLog; //���ɕ\�����镶�͂�\������

  //  ���������ŃX�e�[�^�X��\��
  /*  Display(Player player, Enemy enemy){
      System.out.printf("\033[2");
      System.out.println("������LV:" + player.getLevel());
      System.out.println("������HP:" + player.getHP());
      System.out.println("������MP:" + player.getMP());
      System.out.println("�G��LV:" + enemy.getLevel());
      System.out.println("�G��HP:" + enemy.getHP());
    }*/

    //�E�B���h�E�̃T�C�Y��ύX���ăX�e�[�^�X�ƍs���I���̕\��
  Display(Player player){
    System.out.printf(WINDOW_SIZE);
//    statusDisplay(player, enemy);
//    choiseAction();
  }

  //�o�[�ŃX�e�[�^�X��\��
  void statusDisplay(Player player, Enemy enemy){
    System.out.printf(CLEAR);
    System.out.println("------------------------");
    System.out.println(enemy.getName() + "\t\t|8." + logs[7]);
    System.out.print("LV:" + enemy.getLevel() + "\t");
  //  System.out.println("HP:" + enemy.getHP() + "\t|7." + logs[6]);//�����ɂ��HP�\��(�G)
  //�o�[��HP�\��(�G)
  System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(enemy.getHP() >= enemy.getMaxHP() * a / 10){
        System.out.print("��");
      }else{
        System.out.print("��");
      }
    }
    System.out.println("\t|7." + logs[6]);
    System.out.println("------------------------|6." + logs[5]);
    System.out.print(player.getName());
    if((player.getName().getBytes().length) != ALL_EM){
        System.out.print("\t");
    }
    //System.out.println("HP:" + player.getHP() + "\t|5." + logs[4]);//������HP�\���i�����j
    //�o�[��HP�\��(����)
    System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(player.getHP() >= player.getMaxHP() * a / 10){
        System.out.print("��");
      }else{
        System.out.print("��");
      }
    }
    System.out.println("\t|5." + logs[4]);
    System.out.print("LV:" + player.getLevel() + "\t");
    //System.out.println("MP:" + player.getMP() + "\t\t|4." + logs[3]);//������MP�\���i�����j
    //�o�[��HP�\��(����)
    System.out.print("MP:");
      for(int a = 1; a <= 10; a++){
        if(player.getMP() >= player.getMaxMP() * a / 10){
          System.out.print("��");
        }else{
          System.out.print("��");
        }
      }
      System.out.println("\t|4." + logs[3]);
/*    System.out.println("������HP:" + player.getHP() + "\t\t" + logs[0]);
    System.out.println("������MP:" + player.getMP() + "\t\t" + logs[1]);
    System.out.println("�G��LV:" + enemy.getLevel() + "\t\t" + logs[2]);
    System.out.println("�G��HP:" + enemy.getHP() + "\t\t" + logs[3]);
    */
  }
  //HP��MP��\�����郁�\�b�h(������)
  /*void statusDisplay(Player player, Enemy enemy){
    System.out.println("\n������LV:" + player.getLevel());
    System.out.println("������HP:" + player.getHP());
    System.out.println("������MP:" + player.getMP());
    System.out.println("�G��LV:" + enemy.getLevel());
    System.out.println("�G��HP:" + enemy.getHP());
  }
  */

  //�s���I��(�g�t��)
  void choiseAction(){
    System.out.println("========================|3." + logs[2]);
    System.out.println("1.�U�� 2.���Z\t\t|2." + logs[1]);
    System.out.println("3.���� 4.����\t\t|1." + logs[0]);
    System.out.println("======================== ");
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }



  //�R���\�[���̕`�������������
  void clearDisplay(){
    System.out.printf(CLEAR + WINDOW_SIZE);
  }
  //�_���[�W��\�����郁�\�b�h
  String damageDisplay(int d){
    return "" + d + "�̃_���[�W";
  }
  //�v���C���[�ւ̃_���[�W����щ񕜌��ʂ�\��
  String damageDisplay(int d, Player player){
    if(d >= 0){
      return d + "�̃_���[�W��H�����";
    }else{
      return (d * -1) + "�̉�";
    }
  }
  //�G�ւ̃_���[�W��\��
  String damageDisplay(int d, Enemy enemy){
    if(d >= 0){
      return "�G��" + d + "�̃_���[�W��^����";
    }else{
      return "�G��" + (d * -1) + "�̉�";
    }
  }
  //�s���I���̕��͂�\������
/*  void choiseAction(){
    System.out.println("�s����I�����Ă��������B\n1.�U�� 2.���Z 3.���� 4.����");
  }
  */
  //�퓬����
  void result(Player player, Enemy enemy){
    if(enemy.getHP() <= DOWN_HP){
      System.out.println("�퓬�ɏ�������");
    }else if(player.getHP() <= DOWN_HP){
      System.out.println("�퓬�ɔs�k����");
    }else {
      System.out.println("�퓬���瓦���o����");
    }
  }

  //�퓬�̃��O��ۑ�����
  void setLog(String s){
    for(int i = logs.length - 1; i > 0; i--){
      logs[i] = logs[i - 1];
    }
    logs[0] = BACK_COLOR_BLUE + s + BACK_COLOR_BASE;
  }

  //�_���[�W�\������p
  void setCenterLog(int i){
    if(i >= 0){
      centerLog = CENTER_LOG_CHANGE + i + "�_���[�W" + BOLD_DEFAULT + COLOR_DEFAULT;
    }else{
      centerLog = -1 * i + "��";
    }
  }
  //������ۑ�
  void setCenterLog(String str){
      centerLog = str;
  }

  //�X�L����\������
  void skillDisplay(Player player){
    System.out.printf(CLEAR + UNDER_SCORE + BACK_COLOR_BLUE);
    for(int i = 0; i < player.getSkillGoods(); i++){
      System.out.println(i+1 + "." + player.getSkillName(i) + ":����MP" + player.getSkillCost(i));
    }
    System.out.println("0.���ǂ�" + UNDER_SCORE_RELEASE + BACK_COLOR_BASE);
  }

  //�����\������
  void itemDisplay(Player player){
    System.out.printf(CLEAR + UNDER_SCORE + BACK_COLOR_BLUE);
    for(int i = 0; i < player.getItemGoods(); i++){
      if(player.getItemCount(i) > NO_ITEM){
        System.out.println((i + 1) + "." + player.getItemName(i) + ":���ʗ�" + player.getItemEffect(i) + ":������" + player.getItemCount(i));
      }
    }
    System.out.println("0.���ǂ�" + UNDER_SCORE_RELEASE + BACK_COLOR_BASE);
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }
  //�����\������(���)
  void itemDisplay(List<Item> item){
    System.out.printf(CLEAR + UNDER_SCORE + BACK_COLOR_BLUE);
    for(int i = 0; i < item.size(); i++){
      if(item.get(i).getItemCount() > NO_ITEM){
        System.out.println((i + 1) + "." + item.get(i).getItemName() + ":���ʗ�" + item.get(i).getItemEffect() + ":������" + item.get(i).getItemCount() + ":�l�i" + Math.abs(item.get(i).getItemEffect() * item.get(i).getItemCount()));
      }
    }
    System.out.println("0.���ǂ�" + UNDER_SCORE_RELEASE + BACK_COLOR_BASE);
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }

  //���̃C���^�[�t�F�[�X
  void townDisplay(int money, String choises[]){
    List<String> choisesList = new ArrayList<String>();
    for(int i = 0; i < choises.length; i++){
      choisesList.add(choises[i]);
    }
    System.out.printf(CLEAR);
    System.out.println(" ---------------");
    System.out.println("|������:" + money + "en\t|");
    for(int i = 0; i < choisesList.size(); i++){
      if(choisesList.get(i).getBytes().length <= 4 ){
        System.out.println("|" + (i + 1) + "." + choisesList.get(i) + "\t\t|");
      }else{
        System.out.println("|" + (i + 1) + "." + choisesList.get(i) + "\t|");
      }
    }
    System.out.println(" ---------------");
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }

  //�_���W�����̑I�����
  void dungeonChoiseDisplay(int totalDungeon, String dungeonName[]){
    for(int i = 0; i < totalDungeon; i++){
        System.out.println((i + 1) + ":" + dungeonName[i]);
    }
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }

  //�_���W�������ł̈ړ��\���\��
  void dungeonDisplay(Dungeon dungeons, int x, int y){
    System.out.printf(CLEAR);
    for(int i = 0; i < dungeons.getDepth(); i++){
      for(int j = 0; j < dungeons.getDepth(); j++){
        if(dungeons.searchDungeon(j, i) == 1){
          if(dungeons.getNowX() == j && dungeons.getNowY() == i){
            System.out.print("��");
          }else{
            System.out.print("��");
          }
        }else{
          System.out.print(" ");
        }
      }
      System.out.print("\n");
    }
    if(dungeons.searchDungeon(x, y - 1) == 1){
      System.out.print("   2:��");
    }
    System.out.print("\n");
    if(dungeons.searchDungeon(x - 1, y) == 1){
      System.out.print("3:��");
    }else{
      System.out.print("    ");
    }
    System.out.print("��");
    if(dungeons.searchDungeon(x + 1, y) == 1){
      System.out.print("1:�E");
    }
    System.out.print("\n");
    if(dungeons.searchDungeon(x, y + 1) == 1){
      System.out.print("   4:��");
    }
    System.out.print("\n");
    if(centerLog != null){
      System.out.println(centerLog);
    }
  }
}
