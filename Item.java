//����̏���ۑ����郁�\�b�h
class Item{
  private int itemEffect;
  private int itemCount;


  Item(int x, int y){
     itemEffect= x;
     itemCount = y;
  }

  void countChange(int x){
    itemCount+=x;
  }

  int getItemCount(){
    return itemCount;
  }
  int getItemEffect(){
    return itemEffect;
  }
}
