package sakura.bw.addon.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import sakura.bw.addon.usages.SetPlayerMaps;

public class PlayerEvents implements Listener {
    @EventHandler
    public void Playerjoinevents(PlayerJoinEvent events){
        Player player = events.getPlayer();
        SetPlayerMaps spm = new SetPlayerMaps();
        spm.set_mode("simple");
        spm.add(player);
    }
}
