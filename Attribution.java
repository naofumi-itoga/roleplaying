class Attribution{
  //�萔
  public static final int TOTAL_ATTRIBUTION = 3; //�����̑���
  //�����𐔎��ŕ\��
  public static final  int FIRE=0;
  public static final int WATER=1;
  public static final int WIND=2;

  //�ϐ�
  private int attribution;

  //�����_���ɑ�������
  Attribution(){
    int rand = (int)(Math.random() * TOTAL_ATTRIBUTION-1);
    if(rand == FIRE){
      attribution = FIRE;
    }else if(rand == WATER){
      attribution = WATER;
    }else{
      attribution = WIND;
    }
  }
  //������Ԃ�
  int getAttribution(){
    return attribution;
  }
}
