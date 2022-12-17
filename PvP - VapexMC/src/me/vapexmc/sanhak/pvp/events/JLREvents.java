package me.vapexmc.sanhak.pvp.events;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;

import me.vapexmc.sanhak.pvp.cooldown.Manager;
import me.vapexmc.sanhak.pvp.features.Board;
import me.vapexmc.sanhak.pvp.features.Stats;
import me.vapexmc.sanhak.pvp.kits.KitManager;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.spawn.SpawnManager;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>JLREvents</b> class , It contains on join leave respawn listeners <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class JLREvents implements Listener { // Start

	BukkitScheduler respawn = Bukkit.getServer().getScheduler();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		// Set the scoreboard to player
		Board.setBoard(p);
		// Add kit to player according to his perms
		KitManager.check_on_perms_and_give_kits(p);
		// Clear the weather
		p.setPlayerWeather(WeatherType.CLEAR);
		// Set the game mode to survival
		p.setGameMode(GameMode.SURVIVAL);
		// set the health
		p.setHealth(20.0D);
		// Set the food lvl
		p.setFoodLevel(20);
		// set the lvl zero
		p.setLevel(0);
		// Remove the streaks
		Stats.removeStreak(p.getName(), Stats.getStreak(p.getName()));
		// Teleport to the spawn
		SpawnManager.teleport_player_to_Spawn(p);
		//Set null message when palyer join
		e.setJoinMessage(null);
		//Boardddddd
		for (Player ps : Bukkit.getOnlinePlayers()) {
			Board.setBoard(ps);
		}

	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Manager.cooldowns.containsKey(p.getUniqueId())) { // if player in cooldown
			Manager.cooldowns.remove(p.getUniqueId()); // Remove the player from the cool down
		}
		//Boardddddd
		for (Player ps : Bukkit.getOnlinePlayers()) {
			Board.setBoard(ps);
		}
		// Clear the weather
		p.setPlayerWeather(WeatherType.CLEAR);
		// Set the game mode to survival
		p.setGameMode(GameMode.SURVIVAL);
		// set the health
		p.setHealth(20.0D);
		// Set the food lvl
		p.setFoodLevel(20);
		// set the lvl zero
		p.setLevel(0);
		// Remove the streaks
		Stats.removeStreak(p.getName(), Stats.getStreak(p.getName()));
		// Clear the inventory and remove the effects and set lvl 0
		e.setQuitMessage(null);
		p.getInventory().clear();
		p.setLevel(0);
		Iterator<PotionEffect> var4 = p.getActivePotionEffects().iterator();
		while (var4.hasNext()) {
			PotionEffect effect = var4.next();
			p.removePotionEffect(effect.getType());
		}
		// Teleport to the spawn
		SpawnManager.teleport_player_to_Spawn(p);

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		// Set the lvl zero
		p.setLevel(0);
		// Remove the streaks
		Stats.removeStreak(p.getName(), Stats.getStreak(p.getName()));
		// Clear the inventory and remove the effects and set lvl to 0
		p.setFoodLevel(20);
		// Teleport to the spawn
		SpawnManager.teleport_player_to_Spawn(p);
		Board.setBoard(p);
		this.respawn.scheduleSyncDelayedTask(VapexMCPvP.getMain(), new Runnable() {
			public void run() {
				p.spigot().respawn();
				Board.setBoard(p);
				KitManager.check_on_perms_and_give_kits(p);
			}
		}, 3L);

	}
} // End