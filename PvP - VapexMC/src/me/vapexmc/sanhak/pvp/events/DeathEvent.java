package me.vapexmc.sanhak.pvp.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.vapexmc.sanhak.pvp.configurations.Cuts;
import me.vapexmc.sanhak.pvp.features.Board;
import me.vapexmc.sanhak.pvp.features.Stats;
import me.vapexmc.sanhak.pvp.kits.KitManager;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Methods;
import me.vapexmc.sanhak.pvp.spawn.SpawnManager;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>DeathEvent</b> class , It contains main and important event to pvp game
 * mode<br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class DeathEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeat2h(PlayerDeathEvent e) {
		e.getEntityType();
		if (e.getEntityType() == EntityType.PLAYER) {
			e.setDeathMessage(null);
			e.setDroppedExp(0);
			e.getDrops().clear();
			SpawnManager.teleport_player_to_Spawn( (Player) e.getEntity());
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity(); // get player
		Player k = e.getEntity().getKiller(); // get killer
		
		if (k == null) return;
		if (p == null) return;
		
		e.setDeathMessage(null); // set the death msg to null

		// Teleport the player to spawn after die
		SpawnManager.teleport_player_to_Spawn(p);
		SpawnManager.teleport_player_to_Spawn(p);
		SpawnManager.teleport_player_to_Spawn(p);
		SpawnManager.teleport_player_to_Spawn(p);
		SpawnManager.teleport_player_to_Spawn(p);
		
		// add points to killer
		Stats.addPoints(k.getName(), Cuts.Points_onKill);
		Board.setBoard(k);

		// remove the points from player
		Stats.removePoints(p.getName(), Cuts.Points_onDeath);
		Board.setBoard(p);

		// add streaks to killer
		Stats.addStreak(k.getName(), 1);
		Board.setBoard(k);

		// Remove the streaks from the player
		Stats.removeStreak(p.getName(), Stats.getStreak(p.getName()));
		Board.setBoard(p);

		// Remove the drop
		e.getDrops().clear();
		e.setDroppedExp(0);
		
		// hp
		double health = k.getHealth();
		String hp = String.format("%.1f", new Object[] { Double.valueOf(health / 2.0D) });

		// Send message to player
		p.sendMessage(VapexMCPvP.Prefix
				+ Methods.f("&8&aYour enemy &4 " + k.getDisplayName() + " &astill had &c" + hp + " &aheart remaining"));

		// Add deaths to player
		Stats.addDeaths(p.getName(), 1);

		// add kills to killer
		Stats.addKills(k.getName(), 1);

		// auto heal to killer
		k.setHealth(20.0D);

		// lvl change to killer and player
		p.setLevel(0);
		k.setLevel(k.getLevel() + 1);

		// set board
		Board.setBoard(p);
		Board.setBoard(k);

		//add arrow to player
		k.getInventory().addItem(KitManager.ArrowToKiller(p));
		
		// Send message to killer
		k.sendMessage(VapexMCPvP.Prefix
				+ Methods.f("&8&aYou Killed &4" + p.getDisplayName() + " &awith &c" + hp + " &aheart remaning"));

	}
} // End
