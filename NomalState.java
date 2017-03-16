class NomalState extends State{
  private int time;//状態異常ではない状態
  //通常
  NomalState(){

  }
  //状態異常にかかっているかを確認する
  boolean getTime(){
    return false;
  }
  //状態異常にかかっているかを確認する
  boolean checkTime(){
    return false;
  }
}
