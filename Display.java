class Display {
  public static final int DOWN_HP = 0; //���̐����ȉ��ɂȂ�����|���

  Display(Player ps, Enemy es){
    System.out.printf("\033[2J");
    System.out.println("������LV:" + ps.getLevel());
    System.out.println("������HP:" + ps.getHP());
    System.out.println("������MP:" + ps.getMP());
    System.out.println("�G��LV:" + es.getLevel());
    System.out.println("�G��HP:" + es.getHP());
  }
  //HP��MP��\�����郁�\�b�h
  void statusDisplay(Player ps, Enemy es){
    System.out.println("\n������LV:" + ps.getLevel());
    System.out.println("������HP:" + ps.getHP());
    System.out.println("������MP:" + ps.getMP());
    System.out.println("�G��LV:" + es.getLevel());
    System.out.println("�G��HP:" + es.getHP());
  }
  //�R���\�[���̕`�������������
  void clearDisplay(){
    System.out.printf("\033[2J");
  }
  //�_���[�W��\�����郁�\�b�h
  void damageDisplay(int d){
    System.out.println("" + d + "�̃_���[�W");
  }
  //�v���C���[�ւ̃_���[�W����щ񕜌��ʂ�\��
  void damageDisplay(int d, Player ps){
    if(d>=0){
      System.out.println(d + "�̃_���[�W��H�����");
    }else{
      System.out.println((d * -1) + "�̉�");
    }
  }
  //�G�ւ̃_���[�W��\��
  void damageDisplay(int d, Enemy es){
    if(d>=0){
      System.out.println("�G��" + d + "�̃_���[�W��^����");
    }else{
      System.out.println("�G��" + (d * -1) + "�̉�");
    }
  }
  //�s���I���̕��͂�\������
  void choiseAction(){
    System.out.println("�s����I�����Ă��������B\n1.�U�� 2.���Z 3.���� 4.����");
  }
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
