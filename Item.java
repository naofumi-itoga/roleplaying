//����̏���ۑ����郁�\�b�h
class Item{
  private int itemEffect;
  private int itemCount;
  private String itemName;

  //Item�̏������肷��
  Item(int x, int y, String s){
     itemEffect= x;
     itemCount = y;
     itemName = s;
  }
  //����̏�������ς���
  void countChange(int x){
    itemCount+=x;
  }
  //����̏�������Ԃ�
  int getItemCount(){
    return itemCount;
  }
  //����̌��ʂ�Ԃ�
  int getItemEffect(){
    return itemEffect;
  }
  //����̖��O��Ԃ�
  String getItemName(){
    return itemName;
  }
  //����̌ː������炷
  void itemLost(){
    itemCount--;
  }
}
