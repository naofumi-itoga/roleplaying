class Display {
  //�萔
  public static final int DOWN_HP = 0; //���̐����ȉ��ɂȂ�����|���
  public static final String CLEAR = "\033c";//��ʂ��N���A
  public static final String BOLD = "\033[1m";//����
  public static final String BOLD_DEFAULT = "\033[22m";//���������ɖ߂�
  public static final String BACK_COLOR_BLUE = "\033[44m";//�w�i�F���
  public static final String BACK_COLOR_BASE = "\033[00m";//�w�i�F��߂�
  public static final String BACK_COLOR_WHITE = "\033[47m";//�w�i�F�𔒂�
  public static final String CENTER_LOG_CHANGE = "\033[1;31m";//�����ɂ��ĕ�����Ԃ�
  public static final String COLOR_DEFAULT = "\033[m";//�F�������ɖ߂�
  public static final String WINDOW_SIZE = "\033[4;170;370t";//�R���\�[���̃T�C�Y��170pixel,370pixcel
  public static final int ESC = 0x1B;//�d�r�b�L�[
  public static final int ALL_EM = 8;
  //�ϐ�
    String logs[] = new String[8];

  //  ���������ŃX�e�[�^�X��\��
  /*  Display(Player ps, Enemy es){
      System.out.printf("\033[2");
      System.out.println("������LV:" + ps.getLevel());
      System.out.println("������HP:" + ps.getHP());
      System.out.println("������MP:" + ps.getMP());
      System.out.println("�G��LV:" + es.getLevel());
      System.out.println("�G��HP:" + es.getHP());
    }*/

    //�o�[��HP�Ȃǂ�\��
  Display(Player ps, Enemy es){
    System.out.printf(WINDOW_SIZE);
    statusDisplay(ps, es);
    choiseAction();
  }

  //�o�[�ŃX�e�[�^�X��\��
  void statusDisplay(Player ps, Enemy es){
  //  System.out.printf("%c[1;1H", ESC); //�J�[�\�������
    System.out.printf(CLEAR);
    System.out.println("------------------------");
    System.out.println(es.getName() + "\t\t|8." + BACK_COLOR_BLUE + logs[7] + BACK_COLOR_BASE);
    System.out.print("LV:" + es.getLevel() + "\t");
  //  System.out.println("HP:" + es.getHP() + "\t|7." + logs[6]);//�����ɂ��HP�\��(�G)
  //�o�[��HP�\��(�G)
  System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(es.getHP() >= es.getMaxHP()*a/10){
        System.out.print("��");
      }else{
        System.out.print("��");
      }
    }
    System.out.println("\t|7." + logs[6]);
/*    System.out.println("\t\t\t|" + logs[1]);
    System.out.println("\t" + centerLog + "\t|" + logs[2]);
    */
    System.out.println("------------------------|6." + logs[5]);
    System.out.print(ps.getName());
    if((ps.getName().getBytes().length) != ALL_EM){
        System.out.print("\t");
    }
    //System.out.println("HP:" + ps.getHP() + "\t|5." + logs[4]);//������HP�\���i�����j
    //�o�[��HP�\��(����)
    System.out.print("HP:");
    for(int a = 1; a <= 10; a++){
      if(ps.getHP() >= ps.getMaxHP()*a/10){
        System.out.print("��");
      }else{
        System.out.print("��");
      }
    }
    System.out.println("\t|5." + logs[4]);
    System.out.print("LV:" + ps.getLevel() + "\t");
    //System.out.println("MP:" + ps.getMP() + "\t\t|4." + logs[3]);//������MP�\���i�����j
    //�o�[��HP�\��(����)
    System.out.print("MP:");
      for(int a = 1; a <= 10; a++){
        if(ps.getMP() >= ps.getMaxMP()*a/10){
          System.out.print("��");
        }else{
          System.out.print("��");
        }
      }
      System.out.println("\t|4." + logs[3]);
/*    System.out.println("������HP:" + ps.getHP() + "\t\t" + logs[0]);
    System.out.println("������MP:" + ps.getMP() + "\t\t" + logs[1]);
    System.out.println("�G��LV:" + es.getLevel() + "\t\t" + logs[2]);
    System.out.println("�G��HP:" + es.getHP() + "\t\t" + logs[3]);
    */
    //System.out.printf("%c[1;1H", ESC); //���[����ʒu��������
    //System.out.printf("%c[>5h", ESC); // �J�[�\������
  }
  //HP��MP��\�����郁�\�b�h(������)
  /*void statusDisplay(Player ps, Enemy es){
    System.out.println("\n������LV:" + ps.getLevel());
    System.out.println("������HP:" + ps.getHP());
    System.out.println("������MP:" + ps.getMP());
    System.out.println("�G��LV:" + es.getLevel());
    System.out.println("�G��HP:" + es.getHP());
  }
  */

  //�s���I��(�g�t��)
  void choiseAction(){
    System.out.println("========================|3."+ logs[2]);
    System.out.println("1.�U�� 2.���Z\t\t|2." + logs[1]);
    System.out.println("3.���� 4.����\t\t|1." + logs[0]);
    System.out.println("======================== ");
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
  String damageDisplay(int d, Player ps){
    if(d>=0){
      return d + "�̃_���[�W��H�����";
    }else{
      return (d * -1) + "�̉�";
    }
  }
  //�G�ւ̃_���[�W��\��
  String damageDisplay(int d, Enemy es){
    if(d>=0){
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
  void result(Player ps, Enemy es){
    if(es.getHP() <= DOWN_HP){
      System.out.println("�퓬�ɏ�������");
    }else if(ps.getHP() <= DOWN_HP){
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

  //�����Ƀ_���[�W�\������p
  String centerLog =  "1234567789";
  void setCenterLog(int i){
    if(i>=0){
      centerLog = CENTER_LOG_CHANGE + i + "�_���[�W" + BOLD_DEFAULT + COLOR_DEFAULT;
    }else{
      centerLog = -1*i + "��";
    }

  }
    /*
    private int count;//�s���̃J�E���g
    void choiseAction(int a){
      System.out.println("�s����I�����Ă��������B\n1.�U�� 2.���Z 3.���� 4.����\n");
      System.out.printf("\033[%dA" ,1);
      count=6;
    }
    void damageDisplay(int d, int a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("�G��" + d + "�̃_���[�W\n");
      System.out.printf("\033[%dB" ,count-2);
      System.out.printf("\033[2K");
    }
    void statusDisplay(Player ps, Enemy es, int  a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("������HP:" + ps.getHP());
      System.out.printf("\033[2K");
      System.out.println("������MP:" + ps.getMP());
      System.out.printf("\033[2K");
      System.out.println("�G��HP:" + es.getHP());
      System.out.printf("\033[%dB" , 2);
      System.out.printf("\033[2k");
    }*/
}
