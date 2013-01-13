package com.slipvyne.testPlugin;
 
import org.bukkit.plugin.java.JavaPlugin;
//import java.util.logging.Logger;
 
public final class testPlugin extends JavaPlugin {
	@Override
    public void onEnable(){
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("onEnable has been invoked!");
		getCommand("cubeMake").setExecutor(new MyPluginExec(this));
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("onDisable has been invoked!");
    }
}