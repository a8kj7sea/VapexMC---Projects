package me.vapexmc.sanhak.pvp.combat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Methods;
import me.vapexmc.sanhak.pvp.spawn.SpawnManager;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>CombatManager</b> class , It contains on combat system to give player the
 * better exp and join the mood of the pvp game mode <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class CombatManager implements Listener { // Start

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	private void onEntityHit(EntityDamageByEntityEvent e) {
		if (e.getDamage() != 0.0D && !e.isCancelled()) {
			Player p;
			if (e.getEntity() instanceof Player) {
				p = (Player) e.getEntity();
				p.setFlying(false);
				p.setAllowFlight(false);
				if (CombatTask.combat.containsKey(p)) {
					CombatTask.combat.put(p, 0);
				} else {
					CombatTask.combat.put(p, 0);
					p.sendMessage(VapexMCPvP.Prefix
							+ Methods.f("You're now under the attack , let's do the better of you !"));
				}
			}

			if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
				p = (Player) e.getDamager();
				p.setFlying(false);
				p.setAllowFlight(false);
				if (CombatTask.combat.containsKey(p)) {
					CombatTask.combat.put(p, 0);
				} else {
					CombatTask.combat.put(p, 0);
					p.sendMessage(VapexMCPvP.Prefix
							+ Methods.f("You're now under the attack , let's do the better of you !"));
				}
			}
		}

	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	private void onEntityShootBow(EntityShootBowEvent e) {
		if (!e.isCancelled() && e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			p.setFlying(false);
			p.setAllowFlight(false);
			if (CombatTask.combat.containsKey(p)) {
				CombatTask.combat.put(p, 0);
			} else {
				CombatTask.combat.put(p, 0);
				p.sendMessage(
						VapexMCPvP.Prefix + Methods.f("You're now under the attack , let's do the better of you !"));
			}
		}

	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	private void onEntityHit(EntityDamageEvent e) {
		if (e.getDamage() != 0.0D && !e.isCancelled() && e.getCause().equals(DamageCause.FIRE_TICK)
				&& e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (CombatTask.combat.containsKey(p)) {
				CombatTask.combat.put(p, 0);
			} else {
				CombatTask.combat.put(p, 0);
				p.sendMessage(
						VapexMCPvP.Prefix + Methods.f("You're now under the attack , let's do the better of you !"));
			}
		}

	}

	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
		if (CombatTask.combat.containsKey(e.getPlayer()) && this.blockedCMD(e.getMessage())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(
					VapexMCPvP.Prefix + Methods.f("You're now under the attack , You can't use the commands"));
		}

	}

	// This is blocked cmd in combat
	public boolean blockedCMD(String cmd) {
	      return cmd.startsWith("/lobby") || cmd.startsWith("/hub") || cmd.startsWith("/leave") || cmd.startsWith("/l") || cmd.startsWith("/h") || cmd.startsWith("/spawn");
	}

	@EventHandler
	private void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage((String) null);
		SpawnManager.teleport_player_to_Spawn(p);
		if (CombatTask.combat.containsKey(p)) { // Check if palyer leave and he in combat
			e.getPlayer().setHealth(0.0D);
			CombatTask.combat.remove(p); // Remove player from the combat
		}

	}
} // End