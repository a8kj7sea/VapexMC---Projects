package me.vapexmc.sanhak.pvp.methods;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import me.vapexmc.sanhak.pvp.combat.CombatManager;
import me.vapexmc.sanhak.pvp.combat.CombatTask;
import me.vapexmc.sanhak.pvp.commands.FixCMD;
import me.vapexmc.sanhak.pvp.commands.ReloadCMD;
import me.vapexmc.sanhak.pvp.commands.SpawnCMD;
import me.vapexmc.sanhak.pvp.commands.StatsCMD;
import me.vapexmc.sanhak.pvp.events.DeathEvent;
import me.vapexmc.sanhak.pvp.events.JLREvents;
import me.vapexmc.sanhak.pvp.events.OtherEvents;
import me.vapexmc.sanhak.pvp.events.StreaksEvent;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>CutsMethods</b> class , It contains abbreviations for some things so that
 * you do not repeat them and complicate things for you <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class CutsMethods { // Start

	// This Method to register events !
	public static void RegisterEvents() {
		PluginManager pm = Bukkit.getPluginManager(); // Get Plug-in Manager
		Bukkit.getScheduler().scheduleSyncRepeatingTask(VapexMCPvP.getMain(), (Runnable) new CombatTask(), 20L, 20L); // Enable
																														// the
																														// combat
																														// task
																														// runnable
		pm.registerEvents(new CombatManager(), VapexMCPvP.getMain()); // Register combat manager events
		pm.registerEvents(new JLREvents(), VapexMCPvP.getMain()); // Register combat JLR Events
		pm.registerEvents(new StreaksEvent(), VapexMCPvP.getMain()); // Register combat Streaks Event
		pm.registerEvents(new DeathEvent(), VapexMCPvP.getMain()); // Register Death Event 
		pm.registerEvents(new OtherEvents(), VapexMCPvP.getMain()); // Register Other Events

	}

	// This Method to register the commands !
	public static void RegisterCommands() {
		VapexMCPvP m = VapexMCPvP.getMain();
		m.getCommand("setspawn").setExecutor(new SpawnCMD());
		m.getCommand("fix").setExecutor(new FixCMD());
		m.getCommand("stats").setExecutor(new StatsCMD());
		m.getCommand("reloadconfig").setExecutor(new ReloadCMD());
	}

	// This method send messages when plug-in enabled or disabled ! / Print Messages
	// according to plug-in status
	public static void PrintPluginStatusMessages(int Status) {
		if (Status == 1) { // If the input == 1 (Enabled the plugin) ==> will send message like down
			Bukkit.getConsoleSender().sendMessage(Methods.f("&6PvP &aPlugin has been Enabled"));
		} else if (Status == 0) { // If the input == 0 (Disabled the plugin) ==> will send message like down
			Bukkit.getConsoleSender().sendMessage(Methods.f("&6PvP &cPlugin has been Disabled"));
		} else { // If input not equal 1 or 0 ==> Error
			Logger.Error("Wrong input please input 0 or 1 | 1 to enable | 0 to disable");
			Logger.Error("Thank you for using my plugin <3");
		}
	} //

} // End