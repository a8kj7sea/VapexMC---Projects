package me.vapexmc.sanhak.pvp.configurations;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Configuration</b> class , It help players to be able to change the
 * settings of your plug-in <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Configuration { // Start
	private static File file; // Get object of The File class
	private static FileConfiguration config; // Get object of The FileConfiguration class

	// This method to create Configuration file and check if you wanna to save
	// defualt or not
	public Configuration(String fileName, JavaPlugin plugin, boolean saveDefault) {
		file = new File(plugin.getDataFolder(), fileName); // Definition of File object / filename is parms for the
															// methods anyway the file Definition with datafolder
															// (Plugin dir)
		file.getParentFile().mkdirs(); // Create the Configuration file (in the parnet path)
		if (!file.exists()) { // Check if the Configuration file not exists (not found the Configuration file)
			if (saveDefault) { // check if the player wanna save default if Yes (True) will be save Resource
								// successfully
				plugin.saveResource(fileName, true); // Save Default and save Resource
			} else { // check if the player wanna save default if not (not) will be Create new
						// Configuration file and remove the last one
				try {
					file.createNewFile(); // Create new Configuration file and remove the last one
				} catch (IOException var5) {
					var5.printStackTrace();
				}
			}
		}

		config = YamlConfiguration.loadConfiguration(file); // Load the Configuration file / Definition of
															// FileConfiguration object		
	}

	// This method to save the Configuration file
	// You can use it Like ReloadCMD/SpawnCMD class or in onEnable method (in Init class) 
	// or in onLoad / or bla bla
	public static void save() {
		try {
			config.save(file); // Save the Configuration file
		} catch (IOException var1) {
			var1.printStackTrace();
		}

	}

	// This method used to reload / load the Configuration file
	public static void reload() {
		config = YamlConfiguration.loadConfiguration(file);
	}

	// This method used to get Configuration file
	// to set new string inside it or getstring or addDefault / or bla bla
	public static FileConfiguration getConfig() {
		return config;
	}
}