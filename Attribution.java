class Attribution{
  //‘®«‚ğ”š‚Å•\‚·
  private int FIRE=0;
  private int WATER=1;
  private int WIND=2;
  private int attribution;

  //ƒ‰ƒ“ƒ_ƒ€‚É‘®«Œˆ’è
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
  //‘®«‚ğ•Ô‚·
  int getAttribution(){
    return attribution;
  }
}
