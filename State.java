abstract class State{
  private int time;
  State(){
  }
  boolean getTime(){
    time--;
    return false;
  }
  boolean checkTime(){
      return false;
  }
}
