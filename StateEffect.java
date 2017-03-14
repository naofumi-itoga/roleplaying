class StateEffect{
//  private int nowState;
  private int PARALYSIS = 1;
  private int NOMAL = 0;
  State nowState;
  StateEffect(){
    nowState = new NomalState();
  }
  void setStateEffect(int x){
    if(x==1){
      nowState = new Paralysis();
    }else {
      nowState = new NomalState();
    }
  }
  boolean getStateEffect(){
    return nowState.getTime();
  }
  boolean checkStateEffect(){
    return nowState.checkTime();
  }
}
