package justkira.mythicmobspartieshook;

import io.lumine.mythic.bukkit.events.MythicConditionLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MythicMobsPartiesHook extends JavaPlugin implements Listener {

    private Logger log;

    @Override
    public void onEnable() {
        // Plugin startup logic

        log = this.getLogger();
        Bukkit.getPluginManager().registerEvents(this, this);

        log.info("MythicMobs API Examples Plugin Enabled!");

        System.out.println("Plugin Started");
        if (getServer().getPluginManager().getPlugin("Parties") != null) {
            if (getServer().getPluginManager().getPlugin("Parties").isEnabled()) {
                System.out.println("Parties Hooked");

            }
        }
        if (getServer().getPluginManager().getPlugin("MythicMobs") != null) {
            if (getServer().getPluginManager().getPlugin("MythicMobs").isEnabled()) {
                System.out.println("MythicMobs Hooked");
            }
        }
    }
    @EventHandler
    public void onMythicConditionLoad(MythicConditionLoadEvent event)	{
        log.info("MythicConditionLoadEvent called for condition " + event.getConditionName());

        if(event.getConditionName().equalsIgnoreCase("InSameParty"))	{
            event.register(new InSamePartyCondition(event.getConfig()));
            log.info("-- Registered InSameParty condition!");
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
