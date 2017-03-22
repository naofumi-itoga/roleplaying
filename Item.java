//����̏���ۑ����郁�\�b�h
class Item{
  //�萔
  public static final int HEAL_ITEM = 0; //�񕜃A�C�e��
  public static final int ATTACK_ITEM = 1; //�U���A�C�e��
  public static final int OTHER_ITEM = 2; //���̑��A�C�e��
  //�ϐ�
  private int itemEffect; //�A�C�e���̌��ʗ�
  private int itemCount; //�A�C�e���̐�
  private String itemName; //�A�C�e���̖��O
  private int itemType; //���̃A�C�e���̎��

  //Item�̏������肷��
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
  //����̏�������ς���
  void countChange(int x){
    itemCount = x;
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
  //�A�C�e����ǉ�����
  void setItem(int x, int y, int z, String s){
    itemEffect= x;
    itemCount = y;
    itemName = s;
    itemType = z;
  }
  //�A�C�e���̌��ʂ̎�ނ�Ԃ�
  int getItemType(){
    return itemType;
  }
}
