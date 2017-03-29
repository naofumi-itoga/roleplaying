class GrassDungeon extends Dungeon{
  public static final int HEAL_ITEM = 0; //回復道具
  public static final int ATTACK_ITEM = 1; //攻撃道具
  public static final int POWER_UP_ITEM = 2; //攻撃上昇道具
  public static final int POWER_DOWN_ITEM = 3; //攻撃下降道具
  public static final int OTHER_ITEM = 99; //その他道具
  public static final int MEASURE_TRUE = 1; //そのマスは存在している
  public static final int MEASURE_FALSE = 0; // そのマスは存在していない
  public static final int DUNGEON_DEPTH = 5;

  private int enemyAverage;
  //private int dungeonDepth[5][5]= {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 1, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 1};
  private String enemyName;
  private Item enemyDropItem;
  private  Item treasure;
  private int dungeonMap[][] = {{0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 1, 1, 1}};
  private int goalX = 2;
  private int goalY = 0;
  private int startX = 2;
  private int startY = 4;
  private int nowX;
  private int nowY;

  GrassDungeon(){
    enemyAverage = 15;
    enemyName = "オオカミ";
    enemyDropItem = new Item(1, 1, ATTACK_ITEM, "牙");
    treasure = new Item(1000, 1, OTHER_ITEM, "きれいな宝石");
    nowX = startX;
    nowY = startY;
  }
  String getEnemyName(){
    return enemyName;
  }
  int getAverageLevel(){
    return enemyAverage;
  }
  Item getTreasure(){
    return treasure;
  }
  int getDepth(){
    return DUNGEON_DEPTH;
  }
  Item getEnemyDropItem(){
    return enemyDropItem;
  }
  //スタートの位置を返す
  int getStartX(){
    return startX;
  }
  int getStartY(){
    return startY;
  }
  //ゴールの位置を返す
  int getGoalX(){
    return goalX;
  }
  int getGoalY(){
    return goalY;
  }
  //現在地を返す
  int getNowX(){
    return nowX;
  }
  int getNowY(){
    return nowY;
  }
  int searchDungeon(int x, int y){
    if(x >= 0 && x < DUNGEON_DEPTH && y >= 0 && y < DUNGEON_DEPTH){
      return dungeonMap[x][y];
    }else{
      return 0;
    }
  }
  void setNow(int x, int y){
    nowX = x;
    nowY = y;
  }
}
