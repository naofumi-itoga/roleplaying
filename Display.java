class Display {
  private int count;//�s���̃J�E���g
  Display(PlayerStatus ps, EnemyStatus es){
    System.out.printf("\033[2J");
    System.out.println("������HP:" + ps.getHP());
    System.out.println("������MP:" + ps.getMP());
    System.out.println("�G��HP:" + es.getHP());
  }
  //HP��MP��\�����郁�\�b�h
  void statusDisplay(PlayerStatus ps, EnemyStatus es){
    System.out.println("������HP:" + ps.getHP());
    System.out.println("������MP:" + ps.getMP());
    System.out.println("�G��HP:" + es.getHP());
  }
    void statusDisplay(PlayerStatus ps, EnemyStatus es, int  a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("������HP:" + ps.getHP());
      System.out.printf("\033[2K");
      System.out.println("������MP:" + ps.getMP());
      System.out.printf("\033[2K");
      System.out.println("�G��HP:" + es.getHP());
      System.out.printf("\033[%dB" , 2);
      System.out.printf("\033[2k");
    }
    void clearDisplay(){
      System.out.printf("\033[2J");
    }
    void damageDisplay(int d){
      System.out.println("�G��" + d + "�̃_���[�W\n");
    }
    void damageDisplay(int d, int a){
      System.out.printf("\033[%dA" ,count);
      System.out.printf("\033[2K");
      System.out.println("�G��" + d + "�̃_���[�W\n");
      System.out.printf("\033[%dB" ,count-2);
      System.out.printf("\033[2K");
    }
    void choiseAction(){
      System.out.println("�s����I�����Ă��������B\n1.�U�� 2.���Z 3.���� 4.����\n");
    }
    void choiseAction(int a){
      System.out.println("�s����I�����Ă��������B\n1.�U�� 2.���Z 3.���� 4.����\n");
      System.out.printf("\033[%dA" ,1);
      count=6;
    }
}
