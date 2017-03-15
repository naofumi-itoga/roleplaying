class Attribution{
  //属性を数字で表す
  private int FIRE=0;
  private int WATER=1;
  private int WIND=2;
  private int attribution;

  //ランダムに属性決定
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
  //属性を返す
  int getAttribution(){
    return attribution;
  }
}
