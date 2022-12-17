package me.vapexmc.sanhak.pvp.combat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;

import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>CombatTask</b> class , It contains on runnable task to support and help
 * CombatManager class to be better <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class CombatTask implements Runnable { // Start

	public static int combatTime = 10;
	public static HashMap<Player, Integer> combat = new HashMap<Player, Integer>();

	public void run() {
		List<Player> list = new ArrayList<Player>();
		Iterator<Player> var3 = combat.keySet().iterator();

		Player player;
		while (var3.hasNext()) {
			player = (Player) var3.next();
			if ((Integer) combat.get(player) >= combatTime) {
				player.sendMessage(VapexMCPvP.Prefix
						+ Methods.f("&fYou're not under the attack so, &fYou have been out of comabt !"));
				list.add(player);
			} else {
				combat.replace(player, (Integer) combat.get(player) + 1);
			}
		}

		var3 = list.iterator();

		while (var3.hasNext()) {
			player = (Player) var3.next();
			combat.remove(player);
		}

	}
} // End
