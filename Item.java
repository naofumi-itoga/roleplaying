//道具の情報を保存するメソッド
class Item{
  private int itemEffect;
  private int itemCount;
  private String itemName;

  //Itemの情報を決定する
  Item(int x, int y, String s){
     itemEffect= x;
     itemCount = y;
     itemName = s;
  }
  //道具の所持数を変える
  void countChange(int x){
    itemCount+=x;
  }
  //道具の所持数を返す
  int getItemCount(){
    return itemCount;
  }
  //道具の効果を返す
  int getItemEffect(){
    return itemEffect;
  }
  //道具の名前を返す
  String getItemName(){
    return itemName;
  }
  //道具の戸数を減らす
  void itemLost(){
    itemCount--;
  }
}
