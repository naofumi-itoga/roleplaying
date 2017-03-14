class Paralysis extends State{
  private int time=-1;

  Paralysis(){
    if(time<=0){
      time = (int)(Math.random()*3)+1;
    }
  }
  boolean getTime(){
    time--;
    if(time>=0){
      return true;
    }
    return false;
  }
  boolean checkTime(){
    if(time>=0){
      return true;
    }
    return false;
  }
}
