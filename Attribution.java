class Attribution{
  //�����𐔎��ŕ\��
  private int FIRE=0;
  private int WATER=1;
  private int WIND=2;
  private int attribution;

  //�����_���ɑ�������
  Attribution(){
    int rand = (int)(Math.random()*3);
    if(rand==0){
      attribution = FIRE;
    }else if(rand == 1){
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
