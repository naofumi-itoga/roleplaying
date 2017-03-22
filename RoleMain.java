import java.io.*;

class RoleMain {
  //定数
  public static final int PL_HP = 200; //プレイヤーのHP
  public static final int PL_MP = 10; //プレイヤーのMP
  public static final int PL_AT = 20; //プレイヤーの攻撃力
  public static final int CP_HP = 250; //CPUのHP
  public static final int CP_AT = 22; //CPUの攻撃力
  public static final int CP_E = 60; //CPUから逃げることができる確率
  public static final int PLAYER_LEVEL_WIDTH = 20; //プレイヤーのレベル幅
  public static final int ENEMY_LEVEL_WIDTH = 35; //CPUのレベル幅
  public static final int PLAYER_LEVEL_LOWEST = 10; //プレイやーレベルの最低値
  public static final int ENEMY_LEVEL_LOWEST = 1; //CPUレベルの最低値
  public static final int ATTACK_COMMAND = 1; //攻撃を選択
  public static final int SKILL_COMMAND = 2; //特技を選択
  public static final int ITEM_COMMAND = 3; //道具を選択
  public static final int ESCAPE_COMMAND = 4; //逃げるを選択
  public static final int DAMAGE_WIDTH = 40; //ダメージ倍率の振れ幅
  public static final int DAMAGE_LOWEST = 80; //ダメージの最低倍率
  public static final int PARALYSIS = 1; //麻痺を付与
  public static final int PARALYSIS_ATTACK_PROBABILITY = 20; //麻痺攻撃を行う確率
  public static final int YES = 1; //特技と道具で使用すると回答
  public static final int HUNDRED_PERCENT = 100; //１００、％とかで使う
  public static final int NO_ITEM = 0; //これ以下なら道具が使用できない
  public static final int DOWN_HP = 0; //この数字以下になったら倒れる
  public static final int PINCH_HP = 4; //最大値÷この数字=ひん死
  public static final int ATTRIBUTION_PLUS1 = 2; //これなら得意な属性
  public static final int ATTRIBUTION_PLUS2 = -1; //これも得意な属性
  public static final int ATTRIBUTION_MINUS1 = -2; //苦手な属性
  public static final int ATTRIBUTION_MINUS2 = 1; //苦手な属性
  public static final double ATTRIBUTION_BUFF = 1.4; //得意な属性時のボーナス
  public static final double ATTRIBUTION_DEBUFF = 0.7; //苦手な属性時のボーナス
  public static final double ATTRIBUTION_NOBUFF = 1.0; //通常の属性時攻撃
  public static final int HEAL_ITEM = 0; //回復道具
  public static final int ATTACK_ITEM = 1; //攻撃道具
  public static final int OTHER_ITEM = 2; //その他道具
  public static final int HEAL_SKILL = 0; //回復特技
  public static final int ATTACK_SKILL = 1; //攻撃特技
  public static final int POWER_UP_SKILL = 2; //強化特技
  public static final int GET_HERB = 50; //薬草を獲得する確率
  public static final int MIN_HEAL = -50; //最低回復量
  public static final int MAX_ITEM_GOODS = 100; //所持できる道具の最大数
  public static final int MAX_GET_ITEM = 10; //一度に獲得できるアイテムの最大数
  public static final int MIN_GET_ITEM = 1; //一度に獲得できるアイテムの最低数
  public static final int MAX_SKILLGOODS = 100; //所持できるスキルの最大数

  //変数
  public static int count; //ターン数
  public static Item allItem[] = new Item[MAX_ITEM_GOODS-1]; //すべてのアイテム
  public static Skill allSkill[] = new Skill[MAX_SKILLGOODS-1]; //すべての特技

  //Main、流れの制御をおこなう
  public static void main(String args[]){
    //出てくる特技、アイテムの設定
    allItem[0] = new Item((int)(Math.random() * -HUNDRED_PERCENT)+MIN_HEAL, (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, HEAL_ITEM, "薬草");
    allItem[1] = new Item((int)(Math.random() * HUNDRED_PERCENT), (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, ATTACK_ITEM, "石");
    allSkill[0] = new Skill(1.8, 2, ATTACK_SKILL, "スラッシュ");
    allSkill[1] = new Skill(8, 10, ATTACK_SKILL, "ブルクラッシュ");
    allSkill[2] = new Skill(-2, 3, HEAL_SKILL, "月光");
    allSkill[3] = new Skill(1.3, 5, POWER_UP_SKILL, "力溜");
    boolean escapeSuccess; //逃げることに成功したかどうか
    boolean actionFlag; //行動したかどうか
    boolean continuation=true;
    //Player player = new Player(PL_HP, PL_MP, PL_AT);//プレイヤーのステータス作成
    Player player = new Player((int)(Math.random() * PLAYER_LEVEL_WIDTH) + PLAYER_LEVEL_LOWEST); //プレイヤーのレベルで作成
    //Enemy enemy1 = new Enemy(CP_HP, CP_AT, CP_E);//CPUのステータス作成
    //Enemy enemy1 = new Enemy((int)(Math.random()*ENEMY_LEVEL_WIDTH)+LEVELLOWEST);//CPUのレベルで作成
    //Display display = new Display(player, enemy1);//コンソールの描画関係
/*    player.setSkill(1.8, 2, ATTACK_SKILL, "スラッシュ");
    player.setItem(-player.getMaxHP()/5, 1, HEAL_ITEM, "薬草");
    player.setSkill(8, 10, ATTACK_SKILL, "ブルクラッシュ");
    player.setSkill(-2, 3, HEAL_SKILL, "月光");
    player.setSkill(1.3, 5, POWER_UP_SKILL, "力溜");*/
    //プレイヤーの使用できるものとして、特技と道具セット
    player.setItem(allItem[0]);
    player.setSkill(allSkill[0]);
    player.setSkill(allSkill[1]);
    player.setSkill(allSkill[2]);
    player.setSkill(allSkill[3]);
    //プレイヤーのHPが０になるか、続けることをやめるまでループ
    //名前入力

    String nameBuf = null;
    do{
      System.out.println("四文字以下でプレイヤーの名前を入力してください");
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        nameBuf = br.readLine(); //入力された文字を受け取る
        player.setName(nameBuf);
      }catch(Exception e){
      }
    }while(nameBuf.length() > 4 || nameBuf.isEmpty());

    while(continuation){
      escapeSuccess = false; //逃走失敗状態
      Enemy enemy1 = new Enemy((int)(Math.random() * ENEMY_LEVEL_WIDTH) + ENEMY_LEVEL_LOWEST); //CPUのレベルで作成
      enemy1.setName("オオカミ");
      //Display display = new Display(player, enemy1); //コンソールの描画関係
      Display display = new Display(player, enemy1); //コンソールの描画関係
      //プレイヤーと敵、両方のHPが残っていて、逃走に成功していない場合繰り返す
      while(enemy1.getHP() > DOWN_HP && !escapeSuccess && player.getHP() > DOWN_HP){
    //    count++;

        //display.setLog(count + "ターン目");
        actionFlag = false;
        if(beforeAttackEffect(player)){
          actionFlag = true;
        }
        while(!actionFlag){ //行動を行うまで繰り返し
          //display.choiseAction(); //行動選択の表示

          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine(); //入力された文字を受け取る
            int re = Integer.parseInt(buf); //文字をint型に
            //1,2,3,4のなにが入力されたか、それによって行動が変化
            switch(re){
              case (ATTACK_COMMAND):
                actionFlag = normalAttack(player, enemy1, display); //通常攻撃を行う
                break;
              case (SKILL_COMMAND):
                actionFlag = skillAttack(player, enemy1, display); //特技を使用する
                break;
              case (ITEM_COMMAND):
                actionFlag = itemUse(player, enemy1, display); //道具を使用する
                break;
              case (ESCAPE_COMMAND):
                actionFlag = true;
                escapeSuccess = escape(player, enemy1, display); //逃げだす
                break;
              default:
                System.out.println("1~4の中から選択してください");
            }
            /*if(re == ATTACK_COMMAND){
              //通常攻撃の処理
              actionFlag = normalAttack(player, enemy1, display);
            }else if(re == SKILL_COMMAND){
              //特技の処理
              actionFlag = skillAttack(player, enemy1, display);
            }else if(re == ITEM_COMMAND){
              //道具の処理
              actionFlag = itemUse(player, enemy1, display);
            }else if(re == ESCAPE_COMMAND){
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
        if(enemy1.getHP() > DOWN_HP && !escapeSuccess){
          enemyTurn(player, enemy1, display); //敵の行動の処理へ
        }

        display.statusDisplay(player, enemy1); //敵のHPの表示
        display.choiseAction(); //行動選択の表示
        display.setLog("_____________");
      }
      display.result(player, enemy1); //戦闘結果の表示
      gainItem(player, enemy1); //アイテムを獲得
      //プレイヤーのHPがある場合選択肢が出る
      if(player.getHP() > DOWN_HP){
        player.levelUp(enemy1.getExperience());
        System.out.println("次へ進みますか？1:YES, 2:NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine(); //入力された文字を受け取る
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
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST;
    return (int)((at * bt * rand) / HUNDRED_PERCENT);
  }
  /*
  //敵の攻撃
  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~120までの範囲の乱数
    return (int)((at*rand)/100);
  }*/
  //通常攻撃+相性
  public static int damageCalc(int at, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST;
    return (int)((at * rand * attributionBonus) / HUNDRED_PERCENT);
  }
  //スキル攻撃+相性
  public static int damageCalc(int at, double bt, Player player, Enemy enemy){
    double attributionBonus = getAttributionBonus(player, enemy);
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST;
    return (int)((at * bt * rand * attributionBonus) / HUNDRED_PERCENT);
  }
  //敵の攻撃+相性
  public static int damageCalc(int at, Enemy enemy, Player player){
    double attributionBonus = getAttributionBonus(enemy, player);
    int rand = (int)(Math.random() * DAMAGE_WIDTH) + DAMAGE_LOWEST; //80~120までの範囲の乱数
    return (int)((at * rand * attributionBonus) / HUNDRED_PERCENT);
  }

  //通常攻撃を選択した場合の処理
  public static boolean normalAttack(Player player, Enemy enemy, Display display){
    int damage;//ダメージ計算用変数
    damage = damageCalc(player.getAttack(), player, enemy); //ダメージ計算
    enemy.HPCalc(damage);
    display.setCenterLog(damage);
    display.setLog(display.damageDisplay(damage, enemy));
    return true;
  }

  //特技を選択した場合の処理
  public static boolean skillAttack(Player player, Enemy enemy, Display display){
    //プレイヤーが所持しているスキルの数だけ繰り返す
    for(int i = 0; i < player.getSkillGoods(); i++){
      System.out.println(player.getSkillName(i) + "を使用しますか? 消費MP" + player.getSkillCost(i) + "\n1.YES 2.NO");
      try{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String buf = br.readLine(); //入力された文字を受け取る
        int re = Integer.parseInt(buf);
        if(re == YES){
          //MPが消費MPを上回っていたら行動できる
          if(player.getMP() >= player.getSkillCost(i)){
            //スキルによって効果を変える
            switch(player.getSkillType(i)){
              //HP回復
              case (HEAL_SKILL):
                int damage = damageCalc(player.getAttack(), player.getSkillBonus(i)); //ダメージ計算
                player.MPCalc(player.getSkillCost(i));
                if(player.getHP() - damage >= player.getMaxHP()){
                  damage = player.getHP() - player.getMaxHP();
                }
                player.HPCalc(damage);
                display.setCenterLog(damage);
                display.setLog(display.damageDisplay(damage, player));
                return true;
                //敵にダメージ
              case (ATTACK_SKILL):
                damage = damageCalc(player.getAttack(), player.getSkillBonus(i), player, enemy); //ダメージ計算
                player.MPCalc(player.getSkillCost(i));
                enemy.HPCalc(damage);
                display.setCenterLog(damage);
                display.setLog(display.damageDisplay(damage, enemy));
                return true;
                //攻撃力アップ
              case (POWER_UP_SKILL):
                player.MPCalc(player.getSkillCost(i));
                player.setAttack(player.getSkillBonus(i));
                return true;
              default:
                System.out.println("効果はなかった");
                return true;
            }
          }else{
            System.out.println("MPが足りない");
            break;
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
    //所持している道具の数だけ繰り返す
    for(int i = 0; i < player.getItemGoods(); i++){
      //消費しきったアイテムは表示しない
      if(player.getItemCount(i) > NO_ITEM){
        System.out.println(player.getItemName(i) + "を使用しますか?　所持数:" + player.getItemCount(i) + "\n1.YES 2.NO");
        try{
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          String buf = br.readLine();
          int re = Integer.parseInt(buf);
          if(re == YES){
            //個数が足りているかどうか
            if(player.itemLost(i) >= NO_ITEM){
              switch(player.getItemType(i)){
                //回復アイテム
                case (HEAL_ITEM):
                  int damage = player.getItemEffect(i); //ダメージ計算用変数
                  if(player.getHP() - damage >= player.getMaxHP()){
                    damage = player.getHP() - player.getMaxHP();
                  }
                  player.HPCalc(damage);
                  display.setLog(display.damageDisplay(damage,player));
                  return true;
                  //攻撃アイテム
                case (ATTACK_ITEM):
                  damage=player.getItemEffect(i); //ダメージ計算用変数
                  enemy.HPCalc(damage);
                  display.setLog(display.damageDisplay(damage, enemy));
                  return true;
                default:
                  System.out.println("効果はなかった");
                  return true;
              }
            }else{
              player.countChange(NO_ITEM, i);
              System.out.println("所持数が足りない");
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
    int rand = (int)(Math.random() * HUNDRED_PERCENT); //0~100までの乱数
    if(rand > enemy.getEscape()){
      System.out.println("逃走失敗");
      return false;
    }else{
      System.out.println("逃走成功");
      return true;
    }
  }

  //相手の行動
  public static void enemyTurn(Player player, Enemy enemy, Display display){
    //薬草を使用できるかどうか
    if(enemy.getHP() <= enemy.getMaxHP() / PINCH_HP && enemy.itemLost() >= NO_ITEM){
      int damage = enemy.getItemEffect(); //ダメージ計算用変数
      enemy.itemLost();
      if(enemy.getHP() - damage >= enemy.getMaxHP()){
        damage = enemy.getHP() - enemy.getMaxHP();
      }
      enemy.HPCalc(damage);
      display.setLog(display.damageDisplay(damage, enemy));
    }else{
      //薬草を使用しなかった場合確率で麻痺攻撃or通常攻撃
      int rand = (int)(Math.random() * HUNDRED_PERCENT);
      if(rand >= PARALYSIS_ATTACK_PROBABILITY){
        int damage; //ダメージ計算用変数
        damage = damageCalc(enemy.getAttack(), enemy, player); //ダメージ計算
        player.HPCalc(damage);
        display.setLog(display.damageDisplay(damage, player));
      }else{
        if(!player.checkStateEffect()){
          player.setStateEffect(PARALYSIS);
          display.setLog("麻痺攻撃を食らった");
        }else{
          display.setLog("麻痺攻撃は外れた");
        }
      }
    }
  }

  //属性による強弱
  public static double getAttributionBonus(Player player, Enemy enemy){
    if(player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_PLUS1 || player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS1 ||player.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS2){
      return ATTRIBUTION_DEBUFF;
    }else{
      return ATTRIBUTION_NOBUFF;
    }
  }
  //属性による強弱（敵）
  public static double getAttributionBonus(Enemy enemy, Player player){
    if(enemy.getAttribution() - player.getAttribution() == ATTRIBUTION_PLUS1 || enemy.getAttribution() - player.getAttribution() == ATTRIBUTION_PLUS2){
      return ATTRIBUTION_BUFF;
    }else if(enemy.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS1 || enemy.getAttribution() - enemy.getAttribution() == ATTRIBUTION_MINUS2){
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
    //敵を倒してバトルを終えたのか
    if(enemy.getHP() <= DOWN_HP){
      //５０％の確率で薬草、それ以外の場合は石
      if((int)(Math.random() * HUNDRED_PERCENT) >= GET_HERB){
        player.setItem((int)(Math.random() * -HUNDRED_PERCENT)+MIN_HEAL, (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, HEAL_ITEM, "薬草");
      }else{
        player.setItem((int)(Math.random()*HUNDRED_PERCENT), (int)(Math.random() * MAX_GET_ITEM)+MIN_GET_ITEM, HEAL_ITEM, "石");
      }
      System.out.println(player.getItemName(player.getItemGoods() - 1) + "を" + player.getItemCount(player.getItemGoods() - 1) + "個手に入れた");
    }
  }

/*  public static void loop(){
    for(int i = 0; i<MAX_ITEMGOODS; i++){
      if(!(allItem[i] == null)){
        System.out.println(i);
      }else{
        System.out.println("asa");
        break;
      }
    }
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();//入力された文字を受け取る
      int re = Integer.parseInt(buf);//文字をint型に
    }catch(Exception e){
      System.out.println("数字を入力してください");
    }
  }*/
}
