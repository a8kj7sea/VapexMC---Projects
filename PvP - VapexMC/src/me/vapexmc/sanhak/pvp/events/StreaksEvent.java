package me.vapexmc.sanhak.pvp.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import me.vapexmc.sanhak.pvp.features.Board;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>StreaksEvent</b> class , It contains method to check on streaks and broadcast
 * message <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class StreaksEvent implements Listener { // Start

	@EventHandler
	public void onKillstreak(PlayerLevelChangeEvent e) {
		Player p = e.getPlayer();
		int a = e.getNewLevel();

		for (int x = 5;x < Integer.MAX_VALUE && x % 5 == 0 &&x==a;x+=5) {
			Bukkit.broadcastMessage(VapexMCPvP.Prefix + Methods.f("&c" + p.getDisplayName() + " &7got &b" + a));
			Board.setBoard(p);
		}

	}
} // End
