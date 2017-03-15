import java.io.*;

class RoleMain {
  public static final int PLHP = 200;//プレイヤーのHP
  public static final int PLMP = 10;//プレイヤーのMP
  public static final int PLAT = 20;//プレイヤーの攻撃力
  public static final int CPHP = 250;//CPUのHP
  public static final int CPAT = 22;//CPUの攻撃力
  public static final int CPE = 60;//CPUから逃げることができる確率
  public static final int DAMAGEWIDTH = 40;//ダメージ倍率の振れ幅
  public static final int DAMAGELOWEST = 80;//ダメージの最低倍率
  public static final int PARALYSIS = 1;//麻痺を付与
  public static final int PLAYERLEVELWIDTH = 30;//プレイヤーのレベル幅
  public static final int ENEMYLEVELWIDTH = 35;//CPUのレベル幅
  public static final int LEVELLOWEST = 1;//レベルの最低値
  public static final int DOWNHP = 0;//この数字以下になったら倒れる
  public static final int HUNDREDPERCENT = 100;//１００、％とかで使う
  public static final int PARALYSISATTACKPROBABILITY = 20;//麻痺攻撃を行う確率
  public static final int ATTACKCOMMAND = 1;//攻撃を選択
  public static final int SKILLCOMMAND = 2;//特技を選択
  public static final int ITEMCOMMAND = 3;//道具を選択
  public static final int ESCAPECOMMAND = 4;//逃げるを選択
  public static final int YES = 1;//特技と道具で使用すると回答
  public static final int NO_ITEM = 0;//これ以下なら道具が使用できない
  public static final int PINCH_HP = 4;//最大値÷この数字がやばめ
  public static final int ATTRIBUTION_PLUS1 = 2;//これなら得意な属性
  public static final int ATTRIBUTION_PLUS2 = -1;//得意
  public static final int ATTRIBUTION_MINUS1 = -2;//苦手
  public static final int ATTRIBUTION_MINUS2 = 1;//苦手
  public static final double ATTRIBUTION_BUFF = 2.0;//得意な時のボーナス
  public static final double ATTRIBUTION_DEBUFF = 0.5;//苦手な時のボーナス
  public static final double ATTRIBUTION_NOBUFF = 1.0;//通常の攻撃
  public static final int HEALITEM = 0;//回復道具
  public static final int ATTACKITEM = 1;//攻撃道具
  public static final int OTHERITEM = 2;//その他道具
  public static final int HEALSKILL = 0;//回復特技
  public static final int ATTACKSKILL = 1;//攻撃特技
  public static final int OTHERSKILL = 2;//その他特技

  //Main、流れの制御をおこなう
  public static void main(String args[]){
    boolean escapeSuccess;//逃げることに成功したかどうか
    boolean actionFlag;//行動したかどうか
    boolean continuation=true;
    //Player player = new Player(PLHP, PLMP, PLAT);//プレイヤーのステータス作成
    Player player = new Player((int)(Math.random()*PLAYERLEVELWIDTH)+LEVELLOWEST);//プレイヤーのレベルで作成
    //Enemy enemy1 = new Enemy(CPHP, CPAT, CPE);//CPUのステータス作成
    //Enemy enemy1 = new Enemy((int)(Math.random()*ENEMYLEVELWIDTH)+LEVELLOWEST);//CPUのレベルで作成
    //Display display = new Display(player, enemy1);//コンソールの描画関係
    player.setSkill(8, 10, ATTACKSKILL, "ブルクラッシュ");
    player.setSkill(-2, 3, HEALSKILL, "月光");
    player.setSkill(1.1, 5, OTHERSKILL, "力溜");
    while(continuation){
      escapeSuccess=false;
      Enemy enemy1 = new Enemy((int)(Math.random()*ENEMYLEVELWIDTH)+LEVELLOWEST);//CPUのレベルで作成
      Display display = new Display(player, enemy1);//コンソールの描画関係
      //プレイヤーと敵、両方のHPが残っていて、逃走に成功していない場合繰り返す
      while(enemy1.getHP() > DOWNHP && !escapeSuccess && player.getHP() > DOWNHP){
        actionFlag=false;
        if(beforeAttackEffect(player)){
          actionFlag=true;
        }
        while(!actionFlag){//行動を行うまで繰り返し
          display.choiseAction();
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//入力された文字を受け取る
            int re = Integer.parseInt(buf);//文字をint型に
            //1,2,3,4のなにが入力されたか
            switch(re){
              case (ATTACKCOMMAND):
                actionFlag = normalAttack(player, enemy1, display);
                break;
              case (SKILLCOMMAND):
                actionFlag = skillAttack(player, enemy1, display);
                break;
              case (ITEMCOMMAND):
                actionFlag = itemUse(player, enemy1, display);
                break;
              case (ESCAPECOMMAND):
                actionFlag = true;
                escapeSuccess = escape(player, enemy1, display);
                break;
              default:
                System.out.println("1~4の中から選択してください");
            }
            /*if(re == ATTACKCOMMAND){
              //通常攻撃の処理
              actionFlag = normalAttack(player, enemy1, display);
            }else if(re == SKILLCOMMAND){
              //特技の処理
              actionFlag = skillAttack(player, enemy1, display);
            }else if(re == ITEMCOMMAND){
              //道具の処理
              actionFlag = itemUse(player, enemy1, display);
            }else if(re == ESCAPECOMMAND){
              //逃げるの処理
              actionFlag = true;
              escapeSuccess = escape(player, enemy1, display);
            }else{
              System.out.println("1~4の中から選択してください");
            }*/
          }catch(Exception e){
            System.out.println("数字を入力してください");
          }
        }
        //敵のHPが残っていてなおかつ逃走に成功していない場合に実行
        if(enemy1.getHP() > DOWNHP && !escapeSuccess){
          enemyTurn(player, enemy1, display);//敵の行動の処理へ
        }
        display.statusDisplay(player, enemy1);
      }
      display.result(player, enemy1);
      gainItem(player, enemy1);
      if(player.getHP()>0){
        System.out.println("次へ進みますか？1:YES, 2:NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine();//入力された文字を受け取る
          int re = Integer.parseInt(buf);
          if(re == YES){
            continuation = true;
          }else{
            continuation = false;
          }
        }catch(Exception e){
          System.out.println("数字を入力してください");
        }
      }else{
        continuation = false;
      }
    }
    System.out.println("owari");
  }

//ダメージの計算を行うメソッド
/*  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~12までの範囲の乱数
    return ((at*rand)/100);
  }*/
  //スキルによるダメージ計算を行うメソッド
  public static int damageCalc(int at, double bt){
    int rand = (int)(Math.random()*40)+80;
    return (int)((at*bt*rand)/100);
  }
  /*
  //敵の攻撃
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~12までの範囲の乱数
    return (int)((at*rand)/100);
  }*/
  //通常攻撃：相性
  public static int damageCalc(int at, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random()*DAMAGEWIDTH)+DAMAGELOWEST;
    return (int)((at*rand*attributionBonus)/HUNDREDPERCENT);
  }
  //スキル攻撃：相性
  public static int damageCalc(int at, double bt, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random()*DAMAGEWIDTH)+DAMAGELOWEST;
    return (int)((at*bt*rand*attributionBonus)/HUNDREDPERCENT);
  }
  //敵の攻撃：相性
  public static int damageCalc(int at, Enemy enemy, Player player){
    double attributionBonus = getAttributionBonus(enemy, player);
    int rand = (int)(Math.random()*DAMAGEWIDTH)+DAMAGELOWEST;//80~12までの範囲の乱数
    return (int)((at*rand*attributionBonus)/HUNDREDPERCENT);
  }

  //通常攻撃の判定
  public static boolean normalAttack(Player player, Enemy enemy, Display display){
    int damage;//ダメージ計算用変数
    damage = damageCalc(player.getAttack(), player, enemy);//ダメージ計算
    enemy.HPCalc(damage);
    display.damageDisplay(damage,enemy);
    return true;
  }

  //特技による攻撃の判定
  public static boolean skillAttack(Player player, Enemy enemy, Display display){
    for(int i = 0; i<player.getSkillGoods(); i++){
      System.out.println(player.getSkillName(i) + "を使用しますか? 消費MP" + player.getSkillCost(i) + "\n1.YES 2.NO");
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine();//入力された文字を受け取る
        int re = Integer.parseInt(buf);
        if(re == YES){
          //MPが消費MPを上回っていたら行動できる

          if(player.getMP() >= player.getSkillCost(i)){
            switch(player.getSkillType(i)){
              case (HEALSKILL):
                int damage = damageCalc(player.getAttack(), player.getSkillBonus(i));//ダメージ計算
                player.MPCalc(player.getSkillCost(i));
                if(player.getHP()-damage >= player.getMaxHP()){
                  damage = player.getHP()-player.getMaxHP();
                }
                player.HPCalc(damage);
                display.damageDisplay(damage,player);
                return true;
              case (ATTACKSKILL):
                damage = damageCalc(player.getAttack(), player.getSkillBonus(i), player, enemy);//ダメージ計算
                player.MPCalc(player.getSkillCost(i));
                enemy.HPCalc(damage);
                display.damageDisplay(damage,enemy);
                return true;
              case (OTHERSKILL):
                player.setAttack(player.getSkillBonus(i));
                return true;
              default:
                System.out.println("効果はなかった");
                return true;
            }
          }else{
            System.out.println("MPが足りない");
          }
        }
      }catch(Exception e){
        System.out.println("数字を入力してください");
      }
    }
    return false;
  }

  //道具を使用するメソッド
  public static boolean itemUse(Player player, Enemy enemy, Display display){
    for(int i = 0; i<player.getItemGoods(); i++){
      if(player.getItemCount(i) > 0){
        System.out.println(player.getItemName(i) + "を使用しますか?　所持数:"
                        + player.getItemCount(i) + "\n1.YES 2.NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine();
          int re = Integer.parseInt(buf);
          if(re == YES){
            //個数が足りているかどうか
            if(player.itemLost(i) >= NO_ITEM){
              switch(player.getItemType(i)){
                case (HEALITEM):
                  int damage=player.getItemEffect(i);//ダメージ計算用変数
                  if(player.getHP()-damage >= player.getMaxHP()){
                    damage = player.getHP()-player.getMaxHP();
                  }
                  player.HPCalc(damage);
                  display.damageDisplay(damage,player);
                  return true;
                case (ATTACKITEM):
                  damage=player.getItemEffect(i);//ダメージ計算用変数
                  enemy.HPCalc(damage);
                  display.damageDisplay(damage,enemy);
                  return true;
                default:
                  System.out.println("効果はなかった");
                  return true;
              }
            }else{
              player.countChange(NO_ITEM, i);
              System.out.println("薬草が足りない");
              return false;
            }
          }
        }catch(Exception e){
          System.out.println("数字を入力してください");
          return false;
        }
      }
    }
    return false;
  }

  //逃走判定用
  public static boolean escape(Player player, Enemy enemy, Display display){
    int rand = (int)(Math.random()*HUNDREDPERCENT);//0~100までの乱数
    if(rand > enemy.getEscape()){
      System.out.println("逃走失敗");
      return false;
    }else{
      System.out.println("逃走成功");
      return true;
    }
  }

  //相手の行動
  public static void enemyTurn(Player player,Enemy enemy, Display display){
    //薬草を使用できるかどうか
    if(enemy.getHP() <= enemy.getMaxHP()/PINCH_HP && enemy.itemLost() >= NO_ITEM){
      int damage=enemy.getItemEffect();//ダメージ計算用変数
      enemy.itemLost();
      if(enemy.getHP()-damage>=enemy.getMaxHP()){
        damage = enemy.getHP()-enemy.getMaxHP();
      }
      enemy.HPCalc(damage);
      display.damageDisplay(damage,enemy);
    }else{
      int rand = (int)(Math.random()*HUNDREDPERCENT);
      if(rand>=PARALYSISATTACKPROBABILITY){
        int damage;//ダメージ計算用変数
        damage = damageCalc(enemy.getAttack(), enemy, player);//ダメージ計算
        player.HPCalc(damage);
        display.damageDisplay(damage,player);
      }else{
        if(!player.checkStateEffect()){
          player.setStateEffect(PARALYSIS);
          System.out.println("麻痺攻撃を食らった");
        }else{
          System.out.println("すでに麻痺していたため麻痺攻撃を食らわなかった");
        }
      }
    }
  }

  //属性による強弱
  public static double getAttributionBonus(Player player, Enemy enemy){
    if(player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_PLUS1
        ||player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS1
        ||player.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS2){
      return ATTRIBUTION_DEBUFF;
    }else{
      return ATTRIBUTION_NOBUFF;
    }
  }
  //属性による強弱（敵）
  public static double getAttributionBonus(Enemy enemy, Player player){
    if(enemy.getAttribution()-player.getAttribution() == ATTRIBUTION_PLUS1
        ||enemy.getAttribution()-player.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(enemy.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS1
        ||enemy.getAttribution()-enemy.getAttribution() == ATTRIBUTION_MINUS2){
      return ATTRIBUTION_DEBUFF;
    }else{
      return ATTRIBUTION_NOBUFF;
    }
  }
  //麻痺にかかっているか、かかっていた場合はターンを飛ばす
  public static boolean beforeAttackEffect(Player player){
    if(player.getStateEffect()){
      return true;
    }
    return false;
  }
  //アイテム獲得
  public static void gainItem(Player player, Enemy enemy){
    if(enemy.getHP()<=0){
      String str;
      if((int)(Math.random()*HUNDREDPERCENT)>=50){
        str = "薬草";
        player.setItem((int)(Math.random()*-HUNDREDPERCENT), (int)(Math.random()*10)+1,
                                                          HEALITEM, str);
      }else{
        str = "石";
        player.setItem((int)(Math.random()*HUNDREDPERCENT), (int)(Math.random()*5)+1,
                                                          ATTACKITEM, str);
      }
      System.out.println(player.getItemName(player.getItemGoods()-1) + "を" +
                 player.getItemCount(player.getItemGoods()-1) + "手に入れた");
    }
  }
}
