package de.greenman1805.monsterextra;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Economy econ = null;
	public static int shards;

	@Override
	public void onEnable() {
		if (!setupEconomy()) {
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new MonsterListener(), this);
		setupConfig();
		getValues();
	}

	private void setupConfig() {
		getConfig().addDefault("Shards pro Monster", 25);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void getValues() {
		shards = getConfig().getInt("Shards pro Monster");
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

}
