package sakura.bw.addon;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import sakura.bw.addon.mysql.Connect;
import sakura.bw.addon.mysql.Mysql_usages;
import sakura.bw.addon.usages.SetPlayerMaps;

public class Demo {
    public void demo1(){
        //Demo1.1 本方法下是PlayerMaps主类的使用

          //New出SetPlayerMaps对象
        SetPlayerMaps instance_1 = new SetPlayerMaps();

          //传入Player对象实参,这里我随便new出一个player对象,但开发是要注意对象是否存在 要不然bukkit会报错
        Player player_1 = Bukkit.getPlayer("Demo1");

          //add方法 向HashMap丢入玩家信息
        instance_1.set_mode("simple");
        instance_1.add(player_1);



        //Demo1.2 删除玩家信息
            //New出SetPlayerMaps对象
        SetPlayerMaps instance_2 = new SetPlayerMaps();

          //传入Player对象实参,这里我随便new出一个player对象,但开发是要注意对象是否存在 要不然bukkit会报错
        Player player_2 = Bukkit.getPlayer("Demo2");

        instance_2.set_mode("simple");
        instance_2.remove(player_2);


        //Demo1.3 删除所有玩家数据
          //New出SetPlayerMaps对象
        SetPlayerMaps instance_3 = new SetPlayerMaps();


        //确认操作
        instance_3.confrim_remove();
        instance_3.confrim_remove();
        instance_3.remove_all();


        //Demo1.4 查找玩家

          //New出SetPlayerMaps对象
        SetPlayerMaps instance_4 = new SetPlayerMaps();

          //传入Player对象实参,这里我随便new出一个player对象,但开发是要注意对象是否存在 要不然bukkit会报错
        Player player_4 = Bukkit.getPlayer("Demo4");


          //条件判断
        instance_4.set_mode("simple");
        if (instance_4.search_player(player_4)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }




    }


    public void Demo2(){
        //Demo1.1 本方法下是Mysql_usages主类的使用


        //首先在这里介绍一下 这个项目主要功能目前也只是mysql的方法
        // 目的是为了解决jdbc框架使用困难的问题项目开发时间问题 我只完成了一个功能search方法 而且简化了大部分的步骤

        //首先你需要在config.yml把数据库设置好

        //下面是完成搜索数据的方法

          //获取方法实例
        Mysql_usages instance_5 = new Mysql_usages();
        instance_5.init();
        instance_5.connect();

        //传入Player对象实参,这里我随便new出一个player对象,但开发是要注意对象是否存在 要不然bukkit会报错
        Player player_5 = Bukkit.getPlayer("Demo5");

        //获取玩家名String
        String playername = player_5.getName();

        //查询test表里面的name栏是否有playername的值
        if (instance_5.search("test","name",playername)){
            System.out.println("数据库有该玩家");
        }else {
            System.out.println("数据库没有该玩家");
        }
    }
}
