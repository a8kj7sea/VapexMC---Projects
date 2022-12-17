package me.vapexmc.sanhak.pvp.spawn;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.vapexmc.sanhak.pvp.main.VapexMCPvP;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>SpawnManager</b> class , It a simple class contains a little of method to
 * spawn (teleport entity to custom location) and set spawn <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class SpawnManager { // Start

	public static File file = new File(VapexMCPvP.getMain().getDataFolder(), "Spawn.yml"); // Get object of file and
																							// Definition it
	public static FileConfiguration spawn_file; // Get object of File Configuration

	static {
		spawn_file = YamlConfiguration.loadConfiguration(file); // Definition the object of File Configuration
	}

	// This method to save the Configuration file
	// You can use it Like ReloadCMD/SpawnCMD class or in onEnable method (in Init
	// class)
	// or in onLoad / or bla bla
	public static void save() {
		try {
			spawn_file.save(file); // Save the Configuration file
		} catch (IOException var1) {
			var1.printStackTrace();
		}

	}

	// This method used to reload / load the Configuration file
	public static void reload() {
		spawn_file = YamlConfiguration.loadConfiguration(file);
	}

	// This method used to get Configuration file
	// to set new string inside it or getstring or addDefault / or bla bla
	public static FileConfiguration getConfig() {
		return spawn_file;
	}

	// This method to set the spawn in configuration file
	public static void set_the_spawn(Player p) {
		Location loc = p.getLocation();
		getConfig().set("Spawn.X", Double.valueOf(loc.getX()));
		getConfig().set("Spawn.Y", Double.valueOf(loc.getY()));
		getConfig().set("Spawn.Z", Double.valueOf(loc.getZ()));
		getConfig().set("Spawn.Yaw", Float.valueOf(loc.getYaw()));
		getConfig().set("Spawn.Pitch", Float.valueOf(loc.getPitch()));
		getConfig().set("Spawn.World", loc.getWorld().getName());
		try {
			getConfig().save(file);
		} catch (IOException iOException) {
		}
	}
	
	//This method to check if spawn file is exists 
	public static boolean isExists() {
		if (file.exists()) {
			return true;
		}
		return false;
	}

	// This method to teleport player to the spawn
	public static void teleport_player_to_Spawn(Player p) {
		try {
			Location loc = p.getLocation();
			loc.setX(getConfig().getDouble("Spawn.X"));
			loc.setY(getConfig().getDouble("Spawn.Y"));
			loc.setZ(getConfig().getDouble("Spawn.Z"));
			loc.setYaw((float) getConfig().getDouble("Spawn.Yaw"));
			loc.setPitch((float) getConfig().getDouble("Spawn.Pitch"));
			loc.setWorld(Bukkit.getWorld(getConfig().getString("Spawn.World")));
			p.teleport(loc);
		} catch (Exception exception) {
		}
	}

} // End