class Attribution{
  //‘®«‚ğ”š‚Å•\‚·
  private int FIRE=0;
  private int WATER=1;
  private int WIND=2;
  private int attribution;

  //
  Attribution(){
    int rand = (int)(Math.random()*3);
    System.out.println("‘®«‚Ínew" + rand);
    if(rand==0){
      attribution = FIRE;
    }else if(rand == 1){
      attribution = WATER;
    }else{
      attribution = WIND;
    }
  }
  int getAttribution(){
    return attribution;
  }
}
