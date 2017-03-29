class CaveDungeon extends Dungeon{
  public static final int HEAL_ITEM = 0; //‰ñ•œ“¹‹ï
  public static final int ATTACK_ITEM = 1; //UŒ‚“¹‹ï
  public static final int POWER_UP_ITEM = 2; //UŒ‚ã¸“¹‹ï
  public static final int POWER_DOWN_ITEM = 3; //UŒ‚‰º~“¹‹ï
  public static final int OTHER_ITEM = 99; //‚»‚Ì‘¼“¹‹ï
  public static final int MEASURE_TRUE = 1; //‚»‚Ìƒ}ƒX‚Í‘¶Ý‚µ‚Ä‚¢‚é
  public static final int MEASURE_FALSE = 0; // ‚»‚Ìƒ}ƒX‚Í‘¶Ý‚µ‚Ä‚¢‚È‚¢
  public static final int DUNGEON_DEPTH = 5;

  private int enemyAverage;
  //private int dungeonDepth[5][5]= {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 1, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 1};
  private String enemyName;
  private Item enemyDropItem;
  private  Item treasure;
  private int dungeonMap[][] = {{1, 1, 1, 1, 1}, {0, 0, 1, 0, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 0, 1, 1, 1}};
  private int goalX = 0;
  private int goalY = 0;
  private int startX = 2;
  private int startY = 4;
  private int nowX;
  private int nowY;

  CaveDungeon(){
    enemyAverage = 30;
    enemyName = "ƒSƒuƒŠƒ“";
    enemyDropItem = new Item(200, 1, ATTACK_ITEM, "‰Î‰Š•r");
    treasure = new Item(5000, 1, OTHER_ITEM, "ƒSƒuƒŠƒ“‚Ìà•ó");
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
  //ƒXƒ^[ƒg‚ÌˆÊ’u‚ð•Ô‚·
  int getStartX(){
    return startX;
  }
  int getStartY(){
    return startY;
  }
  //ƒS[ƒ‹‚ÌˆÊ’u‚ð•Ô‚·
  int getGoalX(){
    return goalX;
  }
  int getGoalY(){
    return goalY;
  }
  //Œ»Ý’n‚ð•Ô‚·
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
