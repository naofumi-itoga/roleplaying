class Paralysis extends State{
  private int time=-1;//��Ⴢœ����Ȃ��^�[����
  public static final int NO_EFFECT  = 0;
  public static final int MAX_EFFECT = 3;
  public static final int MIN_EFFECT = 1;
  //���^�[���s���ł��Ȃ��������߂�
  Paralysis(){
    if(time<=NO_EFFECT){
      time = (int)(Math.random()*MAX_EFFECT)+MIN_EFFECT;
    }
  }
  //�s���ł��Ȃ��^�[��������炵�ē����邩�����Ȃ����𑗂�
  boolean getTime(){
    time--;
    if(time>=NO_EFFECT){
      return true;
    }
    return false;
  }
  //��჏�Ԃ������łȂ����𑗂�
  boolean checkTime(){
    if(time>=NO_EFFECT){
      return true;
    }
    return false;
  }
}
