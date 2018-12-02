package fr.zeide.terratablist;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	private static Core instance;
	
	public static Core getInstance() {
		
		return instance;
		
	}
	
	@Override
	public void onEnable() {
		
		System.out.println("[TerraTablist]The plugin is starting");
		System.out.println("[TerraTablist]The plugin is starting");
		System.out.println("[TerraTablist]The plugin is starting");
		getServer().getPluginManager().registerEvents(new PluginListners(), this);
		
		instance = this;
		
	}
	
	@Override
	public void onDisable() {
		
		System.out.println("[TerraTablist]The plugin is stopping");
		System.out.println("[TerraTablist]The plugin is stopping");
		System.out.println("[TerraTablist]The plugin is stopping");
		
	}

}
