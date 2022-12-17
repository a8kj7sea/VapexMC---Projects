package me.vapexmc.sanhak.pvp.features;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.vapexmc.sanhak.pvp.main.VapexMCPvP;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Stats</b> class , It contains a little methods to add defaults objects to
 * Stats file and it contains on methods to store player stats and set the stats
 * <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Stats { // Start

	public static File file = new File(VapexMCPvP.getMain().getDataFolder(), "Stats.yml"); // Get object of file and
																							// Definition it
	public static FileConfiguration stats_file; // Get object of File Configuration

	static {
		stats_file = YamlConfiguration.loadConfiguration(file); // Definition the object of File Configuration
	}

	// This method to save the Configuration file
	// You can use it Like ReloadCMD/SpawnCMD class or in onEnable method (in Init
	// class)
	// or in onLoad / or bla bla
	public static void save() {
		try {
			stats_file.save(file); // Save the Configuration file
		} catch (IOException var1) {
			var1.printStackTrace();
		}

	}

	// This method used to reload / load the Configuration file
	public static void reload() {
		stats_file = YamlConfiguration.loadConfiguration(file);
	}

	// This method used to get Configuration file
	// to set new string inside it or getstring or addDefault / or bla bla
	public static FileConfiguration getConfig() {
		return stats_file;
	}

	// This method to set kills in configuration for the player
	public static void setKills(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Kills", amount);
		save();
	}

	// This method to add kills to the player
	public static void addKills(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Kills", getKills(name) + amount);
		save();
	}

	// This method to remove kills from the player
	public static void removeKills(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Kills", getKills(name) - amount);
		save();
	}

	// this method to get kills to player
	public static Integer getKills(String name) {
		return stats_file.getInt(String.valueOf(name) + ".Kills");
	}

	// this method to set deaths to the player
	public static void setDeaths(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Deaths", amount);
		save();
	}

	// this method to add deaths to player
	public static void addDeaths(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Deaths", getDeaths(name) + amount);
		save();
	}

	// this method to remove deaths from the player
	public static void removeDeaths(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Deaths", getDeaths(name) - amount);
		save();
	}

	// this method to get deaths to player
	public static Integer getDeaths(String name) {
		return stats_file.getInt(String.valueOf(name) + ".Deaths");
	}

	// this method to add streak to player
	public static void addStreak(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Streak", getStreak(name) + amount);
		save();
	}

	// this method to remove streak from the player
	public static void removeStreak(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Streak", getStreak(name) - amount);
		save();
	}

	// this method to get streaks to the player
	public static Integer getStreak(String name) {
		return stats_file.getInt(String.valueOf(name) + ".Points");
	}

	// this method to add points to player
	public static void addPoints(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Points", getPoints(name) + amount);
		save();
	}

	// this method to remove points from player
	public static void removePoints(String name, int amount) {
		stats_file.set(String.valueOf(name) + ".Points", getPoints(name) - amount);
		save();
	}

	// This method to get player points
	public static Integer getPoints(String name) {
		return stats_file.getInt(String.valueOf(name) + ".Points");
	}

} // End
