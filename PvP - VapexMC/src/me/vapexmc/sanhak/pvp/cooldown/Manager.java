package me.vapexmc.sanhak.pvp.cooldown;

import java.util.*;

import org.bukkit.entity.*;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Manager</b> class , It Simple Class to manager cooldown <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Manager { // Start

	public static HashMap<UUID, Double> cooldowns;

	public static void setupCooldown() {
		cooldowns = new HashMap<>();
	}

	public static void setCooldown(Player p, int seconds) {
		double delay = System.currentTimeMillis() + (seconds * 1000);
		cooldowns.put(p.getUniqueId(), delay);
	}

	public static int getCooldown(Player p) {
		return Math.toIntExact(Math.round((cooldowns.get(p.getUniqueId()) - System.currentTimeMillis()) / 1000));
	}

	public static boolean checkCooldown(Player player) {
		if (!cooldowns.containsKey(player.getUniqueId())
				|| cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis()) {
			return true;
		}
		return false;
	}

} // End
