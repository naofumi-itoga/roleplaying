class Paralysis extends State{
  private int time=-1;//麻痺で動けないターン数
  //何ターン行動できないかを決める
  Paralysis(){
    if(time<=0){
      time = (int)(Math.random()*3)+1;
    }
  }
  //行動できないターンを一つ減らして動けるか動けないかを送る
  boolean getTime(){
    time--;
    if(time>=0){
      return true;
    }
    return false;
  }
  //麻痺状態かそうでないかを送る
  boolean checkTime(){
    if(time>=0){
      return true;
    }
    return false;
  }
}
