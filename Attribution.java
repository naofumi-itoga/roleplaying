class Attribution{
  //‘®«‚ğ”š‚Å•\‚·
  private int FIRE=0;
  private int WATER=1;
  private int WIND=2;
  private int attribution;
  public static final int TOTAL_ATTRIBUTION = 3;

  //ƒ‰ƒ“ƒ_ƒ€‚É‘®«Œˆ’è
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
  //‘®«‚ğ•Ô‚·
  int getAttribution(){
    return attribution;
  }
}
