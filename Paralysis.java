class Paralysis extends State{
  //�萔
  public static final int NO_EFFECT  = 0; //��Ⴢɂ������Ă��Ȃ�
  public static final int MAX_EFFECT = 3; //��Ⴢɂ��������ꍇ�ɓ����Ȃ��ő�^�[��
  public static final int MIN_EFFECT = 1; //��Ⴢɂ����������ɓ����Ȃ��ŏ��^�[��

  //�ϐ�
  private int time=NO_EFFECT;//��Ⴢœ����Ȃ��^�[����

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
