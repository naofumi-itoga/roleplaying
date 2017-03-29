class Dungeon{
  public static final int HEAL_ITEM = 0; //�񕜓���
  public static final int ATTACK_ITEM = 1; //�U������
  public static final int POWER_UP_ITEM = 2; //�U���㏸����
  public static final int POWER_DOWN_ITEM = 3; //�U�����~����
  public static final int OTHER_ITEM = 99; //���̑�����
  public static final int MEASURE_TRUE = 1; //���̃}�X�͑��݂��Ă���
  public static final int MEASURE_FALSE = 0; // ���̃}�X�͑��݂��Ă��Ȃ�
  public static final int DUNGEON_DEPTH = 5; //�_���W�����̑傫��
  public static final int TOTAL_DUNGEON = 2; //�_���W�����̑���

  private int enemyAverage;
  private String enemyName;
  private Item enemyDropItem;
  private  Item treasure;
  private int dungeonMap[][];
  private int goalX = 2;
  private int goalY = 0;
  private int startX = 2;
  private int startY = 4;
  private int nowX;
  private int nowY;


  Dungeon(){

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
  //�X�^�[�g�̈ʒu��Ԃ�
  int getStartX(){
    return startX;
  }
  int getStartY(){
    return startY;
  }
  //�S�[���̈ʒu��Ԃ�
  int getGoalX(){
    return goalX;
  }
  int getGoalY(){
    return goalY;
  }
  //���ݒn��Ԃ�
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
