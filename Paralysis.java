class Paralysis extends State{
  private int time=-1;//麻痺で動けないターン数
  public static final int NO_EFFECT  = 0;
  public static final int MAX_EFFECT = 3;
  public static final int MIN_EFFECT = 1;
  //何ターン行動できないかを決める
  Paralysis(){
    if(time<=NO_EFFECT){
      time = (int)(Math.random()*MAX_EFFECT)+MIN_EFFECT;
    }
  }
  //行動できないターンを一つ減らして動けるか動けないかを送る
  boolean getTime(){
    time--;
    if(time>=NO_EFFECT){
      return true;
    }
    return false;
  }
  //麻痺状態かそうでないかを送る
  boolean checkTime(){
    if(time>=NO_EFFECT){
      return true;
    }
    return false;
  }
}
