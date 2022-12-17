package me.vapexmc.sanhak.pvp.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import me.vapexmc.sanhak.pvp.features.Board;
import me.vapexmc.sanhak.pvp.features.Prestige;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>OtherEvents</b> class , It contains on Other listeners to pvp game mode
 * <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class OtherEvents implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void DisableWeather(WeatherChangeEvent event) {
		event.setCancelled(event.toWeatherState());
	}

	@EventHandler
	public void Acheviment(PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getEntityType() == EntityType.PLAYER && e.getDamager() != null
				&& e.getDamager().getType() == EntityType.ARROW
				&& ((Arrow) e.getDamager()).getShooter() == e.getEntity()) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		if (e.getEntity() instanceof Arrow) {
			((Arrow) e.getEntity()).remove();
		}

		if (e.getEntityType() == EntityType.ARROW) {
			e.getEntity().remove();
		}

	}

	@EventHandler
	public void onSpawnEntity(EntitySpawnEvent e) {
		e.setCancelled(false);
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void gg(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
		}

		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.VOID) {
			e.setCancelled(false);
			e.setDamage(20.0D);
		}

		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.BLOCK_EXPLOSION) {
			e.setCancelled(true);
		}

		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.CONTACT) {
			e.setCancelled(true);
		}

		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.FALLING_BLOCK) {
			e.setCancelled(true);
		}

		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.SUICIDE) {
			e.setCancelled(true);
		}

		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.DROWNING) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		Prestige rank = Prestige.getRankOf(player.getName());
		e.setFormat(Methods.f(rank.getPrefix() + " &8|&r " + e.getFormat()));
		if (player.hasPermission("pvp.admin")) {
			e.setMessage(Methods.f(e.getMessage()));
		}
		Board.setBoard(player);
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		Player p = (Player) e.getEntity();

		Board.setBoard(p);

		e.setCancelled(true);
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onSign(SignChangeEvent e) {
		e.setLine(0, ChatColor.translateAlternateColorCodes('&', e.getLine(0)));
		e.setLine(1, ChatColor.translateAlternateColorCodes('&', e.getLine(1)));
		e.setLine(2, ChatColor.translateAlternateColorCodes('&', e.getLine(2)));
		e.setLine(3, ChatColor.translateAlternateColorCodes('&', e.getLine(3)));
	}
}