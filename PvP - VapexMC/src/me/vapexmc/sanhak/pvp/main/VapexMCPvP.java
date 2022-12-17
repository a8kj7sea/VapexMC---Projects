package me.vapexmc.sanhak.pvp.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.vapexmc.sanhak.pvp.configurations.Configuration;
import me.vapexmc.sanhak.pvp.cooldown.Manager;
import me.vapexmc.sanhak.pvp.methods.CutsMethods;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>VapexMCPvP</b> class , It the Main Class of Project (init) From here
 * everything starts / Main class (init) / soul of project <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class VapexMCPvP extends JavaPlugin { // Start

	public static VapexMCPvP m; // Get object of The Main class
	public Configuration config; // Get object of The Configuration class
	public static String Prefix = Methods.f("&8︳ &ePvP &8︳ &r"); // Plugin Prefix

	// When the plug-in Start or enable !
	@Override
	public void onEnable() {
		m = this; // Definition of Main object
		config = new Configuration("config.yml", this, true); // Definition of Main object
		Manager.setupCooldown(); // Setup the cooldown and Definition it
		CutsMethods.RegisterEvents(); // Register the events
		CutsMethods.RegisterCommands(); // Register the commands !
		CutsMethods.PrintPluginStatusMessages(1); // Print Messages according to
		// plug-in status
	}

	// When the plug-in stop or disable !
	@Override
	public void onDisable() {
		CutsMethods.PrintPluginStatusMessages(0); // Print Messages according to
		// plug-in status
	}

	// Get the Main Folder Path / or get instance of main class / get Main
	// Main class
	public static VapexMCPvP getMain() {
		return m;
	}

} // End
