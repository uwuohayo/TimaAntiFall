package ovh.rootkovskiy.timaantifall;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Plugin enabled");
        this.saveDefaultConfig();
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaAntiFall 1.0-release Loaded and Enabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: " + getServer().getBukkitVersion() + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);

    }

    @Override
    public void onDisable() {

        getLogger().info("Plugin disabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaAntiFall 1.0-release Disabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: " + getServer().getBukkitVersion() + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Goodbye ;p" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);

    }

    @EventHandler
    public void noFall(PlayerMoveEvent event) {

        boolean title = getConfig().getBoolean("ENABLE_TITLE");
        boolean message = getConfig().getBoolean("ENABLE_FALL_MESSAGE");

        Player plr = event.getPlayer();
        int y = plr.getLocation().getBlockY();
        Location spawn = plr.getWorld().getSpawnLocation();

        if (y < getConfig().getInt("MIN_Y") && event.getPlayer().getWorld().getName().equalsIgnoreCase(getConfig().getString("WORLD"))) {
            plr.teleport(spawn);
            if (title) {
                plr.sendTitle(getConfig().getString("TITLE").replace("&", "§"), null, 20, 40, 20);
            }
            if (message) {
                plr.sendMessage(getConfig().getString("FALL_MESSAGE").replace("&", "§"));
            }
        }
    }
}
