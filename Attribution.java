class Attribution{
  //�����𐔎��ŕ\��
  private int FIRE=0;
  private int WATER=1;
  private int WIND=2;
  private int attribution;
  public static final int TOTAL_ATTRIBUTION = 3;

  //�����_���ɑ�������
  Attribution(){
    int rand = (int)(Math.random()*TOTAL_ATTRIBUTION);
    if(rand==FIRE){
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
