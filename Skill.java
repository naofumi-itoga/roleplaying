//特技の情報を保存するメソッド
class Skill{
  //定数
  public static final int HEAL_SKILL = 0; //回復特技
  public static final int ATTACK_SKILL = 1; //攻撃特技
  public static final int OTHER_SKILL = 2; //その他特技
  //変数
  private double skillBonus; //スキルの倍率
  private int skillCost; //スキルのコスト
  private String skillName; //スキルの名前
  private int skillType; //この特技の種類


  //特技の情報を決定する
  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
  //名前を入力する場合はこちら
  Skill(double x, int y, int z, String s){
    skillBonus = x;
    skillCost = y;
    skillName = s;
    skillType = z;
  }
//特技の性能を返すメソッド
  double getSkillBonus(){
    return skillBonus;
  }
  //特技で消費するMPを返す
  int getSkillCost(){
    return skillCost;
  }
  //スキルの名前を返す
  String getSkillName(){
    return skillName;
  }
  //スキルがどういう効果か返す。
  int getSkillType(){
    return skillType;
  }
}
