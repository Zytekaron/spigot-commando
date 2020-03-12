package tk.zytekaron.spigot.commando;

import org.bukkit.plugin.java.JavaPlugin;
import tk.zytekaron.spigot.commando.commands.HelpCommand;

public class MyPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        SpigotCommando commando = new SpigotCommando(this);
        commando.registerCommands(new HelpCommand());
    }
}