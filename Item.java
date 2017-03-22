//道具の情報を保存するメソッド
class Item{
  //定数
  public static final int HEAL_ITEM = 0; //回復アイテム
  public static final int ATTACK_ITEM = 1; //攻撃アイテム
  public static final int OTHER_ITEM = 2; //その他アイテム
  //変数
  private int itemEffect; //アイテムの効果量
  private int itemCount; //アイテムの数
  private String itemName; //アイテムの名前
  private int itemType; //このアイテムの種類

  //Itemの情報を決定する
  Item(int x, int y, int z, String s){
     itemEffect= x;
     itemCount = y;
     itemName = s;
     itemType = z;
  }
  Item(int x, int z, String s){
    itemEffect= x;
    itemName = s;
    itemType = z;
  }
  Item(Item i, int y){
    itemCount = y;
  }
  //道具の所持数を変える
  void countChange(int x){
    itemCount = x;
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
  //アイテムを追加する
  void setItem(int x, int y, int z, String s){
    itemEffect= x;
    itemCount = y;
    itemName = s;
    itemType = z;
  }
  //アイテムの効果の種類を返す
  int getItemType(){
    return itemType;
  }
}
