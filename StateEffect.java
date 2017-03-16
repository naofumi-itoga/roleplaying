class StateEffect{
//  private int nowState;
//¡‚Ç‚Ìó‘ÔˆÙí‚É‚©‚©‚Á‚Ä‚¢‚é‚©
  private int PARALYSIS = 1;
  private int NOMAL = 0;
  State nowState;

  //’Êíó‘Ô‚Å‰Šú‰»‚·‚é
  StateEffect(){
    nowState = new NomalState();
  }
  //ó‘ÔˆÙí‚É‚©‚©‚Á‚½‚©
  void setStateEffect(int x){
    if(x==PARALYSIS){
      nowState = new Paralysis();
    }else {
      nowState = new NomalState();
    }
  }
  //ó‘ÔˆÙí‚ğ•Ô‚·
  boolean getStateEffect(){
    return nowState.getTime();
  }
  //ó‘ÔˆÙí‚ğ•Ô‚·
  boolean checkStateEffect(){
    return nowState.checkTime();
  }
}
