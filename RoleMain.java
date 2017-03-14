import java.io.*;

class RoleMain {
  static int PLHP = 200;
  static int PLMP = 10;
  static int CPHP = 250;
  public static int PARALYSIS = 1;
  //Main、流れの制御をおこなう
  public static void main(String args[]){
    boolean escapeSuccess=false;//逃げることに成功したかどうか
    boolean actionFlag;//行動したかどうか
    PlayerStatus ps = new PlayerStatus(PLHP, PLMP, 20);//プレイヤーのステータス
    EnemyStatus es1 = new EnemyStatus(CPHP, 22, 60);//CPUのステータス
    Display di = new Display(ps, es1);//コンソールの描画関係
    //プレイヤーと敵、両方のHPが残っていて、逃走に成功していない場合繰り返す
      while(es1.getHP()>0&&!escapeSuccess&&ps.getHP()>0){
        actionFlag=false;
        if(beforeAttackEffect(ps)){
          actionFlag=true;
        }
        while(!actionFlag){//行動を行うまで繰り返し
          di.choiseAction();
          try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String buf = br.readLine();//入力された文字を受け取る
            int re = Integer.parseInt(buf);//文字をint型に
            //1,2,3,4のなにが入力されたか
            if(re == 1){
              //通常攻撃の処理
              actionFlag = normalAttack(ps, es1, di);
            }else if(re == 2){
              //特技の処理
              actionFlag = skillAttack(ps, es1, di);
            }else if(re == 3){
              //道具の処理
              actionFlag = itemUse(ps, es1, di);
            }else if(re == 4){
              //逃げるの処理
              actionFlag = true;
              escapeSuccess = escape(ps, es1, di);
            }else{
              System.out.println("1~4の中から選択してください");
            }
          }catch(Exception e){
          }
        }
        //敵のHPが残っていてなおかつ逃走に成功していない場合に実行
        if(es1.getHP()>0&&!escapeSuccess){
          enemyTurn(ps, es1, di);//敵の行動の処理へ
        }
        di.statusDisplay(ps, es1);
    }
    di.result(ps, es1);
    System.out.println("owari");
  }

//ダメージの計算を行うメソッド
/*  public static int damageCalc(int at){
    int rand = (int)(Math.random()*40)+80;//80~12までの範囲の乱数
    return ((at*rand)/100);
  }
  //スキルによるダメージ計算を行うメソッド
  public static int damageCalc(int at, double bt){
    int rand = (int)(Math.random()*40)+80;
    return (int)((at*bt*rand)/100);
  }*/
  //通常攻撃：相性
  public static int damageCalc(int at, PlayerStatus ps, EnemyStatus es){
    double attributionBonus = getAttributionBonus(ps, es);
    int rand = (int)(Math.random()*40)+80;
    return (int)((at*rand*attributionBonus)/100);
  }
  //スキル攻撃：相性
  public static int damageCalc(int at, double bt, PlayerStatus ps, EnemyStatus es){
    double attributionBonus = getAttributionBonus(ps, es);
    int rand = (int)(Math.random()*40)+80;
    return (int)((at*bt*rand*attributionBonus)/100);
  }
  //敵の攻撃：相性
  public static int damageCalc(int at, EnemyStatus es, PlayerStatus ps){
    double attributionBonus = getAttributionBonus(es, ps);
    int rand = (int)(Math.random()*40)+80;//80~12までの範囲の乱数
    return (int)((at*rand*attributionBonus)/100);
  }

  //通常攻撃の判定
  public static boolean normalAttack(PlayerStatus ps, EnemyStatus es, Display di){
    int damage;//ダメージ計算用変数
    damage = damageCalc(ps.getAttack(), ps, es);//ダメージ計算
    es.HPCalc(damage);
    di.damageDisplay(damage,es);
    return true;
  }

  //特技による攻撃の判定
  public static boolean skillAttack(PlayerStatus ps, EnemyStatus es, Display di){
    System.out.println("特技を使用しますか? 消費MP" + ps.getSkillCost() + "\n1.YES 2.NO");
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();//入力された文字を受け取る
      int re = Integer.parseInt(buf);
      if(re == 1){
        //MPが消費MPを上回っていたら行動できる
        if(ps.getMP()>=ps.getSkillCost()){
          int damage;//ダメージ計算用変数
          damage = damageCalc(ps.getAttack(), ps.getSkillBonus(), ps, es);//ダメージ計算
          ps.MPCalc(ps.getSkillCost());
          es.HPCalc(damage);
          di.damageDisplay(damage,es);
          return true;
        }else{
          System.out.println("MPが足りない");
        }
      }
    }catch(Exception e){
    }
    return false;
  }

  //道具を使用するメソッド
  public static boolean itemUse(PlayerStatus ps, EnemyStatus es, Display di){
    System.out.println(ps.getItemName() + "を使用しますか?　所持数:" + ps.getItemCount() + "\n1.YES 2.NO");
    try{
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String buf = br.readLine();
      int re = Integer.parseInt(buf);
      if(re == 1){
        //個数が足りているかどうか
        if(ps.getItemCount()-1>=0){
          int damage=ps.getItemEffect();//ダメージ計算用変数
          ps.itemLost();
          ps.HPCalc(damage);
          di.damageDisplay(damage,ps);
          return true;
        }else{
          System.out.println("薬草が足りない");
        }
      }
    }catch(Exception e){
    }
    return false;
  }

  //逃走判定用
  public static boolean escape(PlayerStatus ps, EnemyStatus es, Display di){
    int rand = (int)(Math.random()*100);//0~100までの乱数
    if(rand > es.getEscape()){
      System.out.println("逃走失敗");
      return false;
    }else{
      System.out.println("逃走成功");
      return true;
    }
  }

  //相手の行動
  public static void enemyTurn(PlayerStatus ps,EnemyStatus es, Display di){
    int rand = (int)(Math.random()*100);
    if(rand>=99){
      int damage;//ダメージ計算用変数
      damage = damageCalc(es.getAttack(), es, ps);//ダメージ計算
      ps.HPCalc(damage);
      di.damageDisplay(damage,ps);
    }else{
      if(!ps.checkStateEffect()){
        ps.setStateEffect(PARALYSIS);
        System.out.println("麻痺攻撃を食らった");
      }
      else{
        System.out.println("すでに麻痺していたため麻痺攻撃を食らわなかった");
      }
    }
  }

  //属性による強弱
  public static double getAttributionBonus(PlayerStatus ps, EnemyStatus es){
    if(ps.getAttribution()-es.getAttribution() == -2
        ||ps.getAttribution()-es.getAttribution() == 1){
      return 2;
    }else if(ps.getAttribution()-es.getAttribution() == -1
        ||ps.getAttribution()-es.getAttribution() == 2){
      return 0.55;
    }else{
      return 1.0;
    }
  }
  //属性による強弱（敵）
  public static double getAttributionBonus(EnemyStatus es, PlayerStatus ps){
    if(es.getAttribution()-ps.getAttribution() == -2
        ||es.getAttribution()-ps.getAttribution() == 1){
      return 2.;
    }else if(es.getAttribution()-es.getAttribution() == -1
        ||es.getAttribution()-es.getAttribution() == 2){
      return 0.55;
    }else{
      return 1.0;
    }
  }
  public static boolean beforeAttackEffect(PlayerStatus ps){
    if(ps.getStateEffect()){
      return true;
    }
    return false;
  }
}
