class StateEffect{
//  private int nowState;
//���ǂ̏�Ԉُ�ɂ������Ă��邩
  private int PARALYSIS = 1;
  private int NOMAL = 0;
  State nowState;

  //�ʏ��Ԃŏ���������
  StateEffect(){
    nowState = new NomalState();
  }
  //��Ԉُ�ɂ���������
  void setStateEffect(int x){
    if(x==PARALYSIS){
      nowState = new Paralysis();
    }else {
      nowState = new NomalState();
    }
  }
  //��Ԉُ��Ԃ�
  boolean getStateEffect(){
    return nowState.getTime();
  }
  //��Ԉُ��Ԃ�
  boolean checkStateEffect(){
    return nowState.checkTime();
  }
}
