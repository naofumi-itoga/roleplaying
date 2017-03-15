//“Á‹Z‚Ìî•ñ‚ğ•Û‘¶‚·‚éƒƒ\ƒbƒh
class Skill{
  private double skillBonus;
  private int skillCost;
  private String skillName;
  public static final int HEALSKILL = 0;//‰ñ•œ“Á‹Z
  public static final int ATTACKSKILL = 1;//UŒ‚“Á‹Z
  public static final int OTHERSKILL = 2;//‚»‚Ì‘¼“Á‹Z
  private int skillType;//‚±‚Ì“Á‹Z‚Ìí—Ş

  //“Á‹Z‚Ìî•ñ‚ğŒˆ’è‚·‚é
  Skill(double x, int y){
    skillBonus = x;
    skillCost = y;
  }
  //–¼‘O‚ğ“ü—Í‚·‚éê‡‚Í‚±‚¿‚ç
  Skill(double x, int y, String s){
    skillBonus = x;
    skillCost = y;
    skillName = s;
  }
//“Á‹Z‚Ì«”\‚ğ•Ô‚·ƒƒ\ƒbƒh
  double getSkillBonus(){
    return skillBonus;
  }
  //“Á‹Z‚ÅÁ”ï‚·‚éMP‚ğ•Ô‚·
  int getSkillCost(){
    return skillCost;
  }
  String getSkillName(){
    return skillName;
  }
}
