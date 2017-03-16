class Paralysis extends State{
  //定数
  public static final int NO_EFFECT  = 0; //麻痺にかかっていない
  public static final int MAX_EFFECT = 3; //麻痺にかかった場合に動けない最大ターン
  public static final int MIN_EFFECT = 1; //麻痺にかかった時に動けない最少ターン

  //変数
  private int time=NO_EFFECT;//麻痺で動けないターン数

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
