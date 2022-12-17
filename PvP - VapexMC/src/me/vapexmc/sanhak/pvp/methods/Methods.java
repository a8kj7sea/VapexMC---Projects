package me.vapexmc.sanhak.pvp.methods;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Objective;

import me.vapexmc.sanhak.pvp.main.VapexMCPvP;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Methods</b> class , It contains a little methods and functions that help
 * the plug-in <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Methods { // Start

	// This method to translate color codes
	// Example on usages -> p.sendMessage(f("&bHello Worst World !!!"));
	public static String f(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	// Change the scoreboard title every 8L | Like hypixel (animation title)
	public static void Title_Changer_for_board(Objective ob) {
		ArrayList<String> A = new ArrayList<String>();
		A.clear();
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(VapexMCPvP.getMain(), new Runnable() {
			public void run() {
				Integer i = A.size();
				if (i == 1) {ob.setDisplayName(Methods.f("&ePvP"));A.add("A");}
				if (i == 2) {ob.setDisplayName(Methods.f("&6&lP&evP"));A.add("B");}
				if (i == 3) {ob.setDisplayName(Methods.f("&6&lPv&eP"));A.add("C");}
				if (i == 4) {ob.setDisplayName(Methods.f("&6&lPvP"));A.add("D");}
				if (i == 5) {ob.setDisplayName(Methods.f("&6&lPVP"));A.add("E");}
				if (i == 5) {A.clear();}
			}
		}, 0L, 8L);
	}
	
	// This method to fix the Player (fix location / remove lag / bla bla bla)
	public static void Fix(final Player player) {
		if (player != null && player.isOnline()) {
			Location NewLocation = new Location(player.getWorld(), player.getLocation().getX(),
					player.getLocation().getY() + 0.3D, player.getLocation().getZ(), player.getLocation().getYaw(),
					player.getLocation().getPitch());
			player.teleport(NewLocation);
			Iterator<?> var4 = Bukkit.getOnlinePlayers().iterator();
			while (var4.hasNext()) {
				Player allPlayers = (Player) var4.next();
				allPlayers.hidePlayer(player);
				player.hidePlayer(allPlayers);
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(VapexMCPvP.getMain(), new Runnable() {
				public void run() {
					Iterator<?> var2 = Bukkit.getOnlinePlayers().iterator();
					while (var2.hasNext()) {
						Player allPlayers = (Player) var2.next();
						allPlayers.showPlayer(player);
						player.showPlayer(allPlayers);
					}
					player.sendMessage(Methods.f("&aYou have been fixed."));
				}
			}, 1L);
		}
	}

} // End
