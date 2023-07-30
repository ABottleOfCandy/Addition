package sakura.bw.addon.usages;

import org.bukkit.entity.Player;
import sakura.bw.addon.main;

import java.util.HashMap;
import java.util.Objects;

import static sakura.bw.addon.main.PlayerMaps;

public class SetPlayerMaps {
    private main plugin = main.getInstance();
    private WarningMessages wm = new WarningMessages();
    private HashMap pm = PlayerMaps;

    private String mode = "simple";
    private Boolean confirm_type = false;
    private int confirm_times = 0;



    public Boolean set_mode(String s_mode){
        if (s_mode.equalsIgnoreCase("simple")){
            if (mode.equals("simple")){
                plugin.getLogger().info(wm.SetPlayermaps_alreadychanged());
                mode = "simple";
                return true;
            }else{
                plugin.getLogger().warning(wm.SetPlayermaps_nomoremode());

            }
        }
        return false;
    }

    private void synchronous_pm(){
        pm = PlayerMaps;
    }

    private void synchronous_PlayerMaps(){
        PlayerMaps = pm;
    }


    public void remove(Player player){
        if (mode.equals("simple")){
            synchronous_pm();
            pm.remove(player);
            synchronous_PlayerMaps();
        }
    }

    public void add(Player player){
        if (mode.equals("simple")){
            synchronous_pm();
            pm.put(player,"true");
            synchronous_PlayerMaps();
        }else {
            plugin.getLogger().warning(wm.SetPlayermaps_nomoremode());
        }
    }

    public void remove_all(){
        if (confirm_type == false){
            plugin.getLogger().warning(wm.SetPlayermaps_NotConfirm());
        }else {
            if (confirm_times >= 2){
                pm.clear();
                PlayerMaps = pm;
            }else {
                plugin.getLogger().warning(wm.SetPlayermaps_NotConfirm());
            }
        }
    }

    public void confrim_remove(){
        confirm_times = confirm_times ++;
        if (confirm_times == 1){
            plugin.getLogger().info(wm.SetPlayermaps_NotConfirm_1l());
        } else{
            plugin.getLogger().info(wm.SetPlayermaps_ConfirmSuccessully());
        }


    }

    public Boolean search_player(Player player){
        Object object = pm.get(player);
        if (Objects.isNull(object)){
            return false;
        }else {
            return true;
        }
    }
}
