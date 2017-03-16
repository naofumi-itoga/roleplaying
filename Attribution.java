class Attribution{
  //’è”
  public static final int TOTAL_ATTRIBUTION = 3; //‘®«‚Ì‘”
  //‘®«‚ğ”š‚Å•\‚·
  public static final  int FIRE=0;
  public static final int WATER=1;
  public static final int WIND=2;

  //•Ï”
  private int attribution;

  //ƒ‰ƒ“ƒ_ƒ€‚É‘®«Œˆ’è
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
  //‘®«‚ğ•Ô‚·
  int getAttribution(){
    return attribution;
  }
}
