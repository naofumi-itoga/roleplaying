class Paralysis extends State{
  private int time=-1;//��Ⴢœ����Ȃ��^�[����
  //���^�[���s���ł��Ȃ��������߂�
  Paralysis(){
    if(time<=0){
      time = (int)(Math.random()*3)+1;
    }
  }
  //�s���ł��Ȃ��^�[��������炵�ē����邩�����Ȃ����𑗂�
  boolean getTime(){
    time--;
    if(time>=0){
      return true;
    }
    return false;
  }
  //��჏�Ԃ������łȂ����𑗂�
  boolean checkTime(){
    if(time>=0){
      return true;
    }
    return false;
  }
}
