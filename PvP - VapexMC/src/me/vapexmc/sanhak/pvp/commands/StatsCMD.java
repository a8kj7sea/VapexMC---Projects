package me.vapexmc.sanhak.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.vapexmc.sanhak.pvp.features.Prestige;
import me.vapexmc.sanhak.pvp.features.Stats;
import me.vapexmc.sanhak.pvp.methods.Logger;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>StatsCMD</b> class , It contains on Command allow to player to see his
 * stats and players stats <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class StatsCMD implements CommandExecutor { // Start

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) { // If player use command from console return false and send message !
			Logger.Warn("&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}

		Player p = (Player) cs;
		if (args.length == 0) { // if player use command without args like /stats
			Prestige rank = Prestige.getRankOf(p.getName());
			p.sendMessage("  ");
			p.sendMessage(Methods.f("&6&l" + p.getName() + " &f&lStats"));
			p.sendMessage(Methods.f("&8&l︳ &fRank &8» " + rank.getPrefix()));
			p.sendMessage(Methods.f("&8&l︳ &fPoints &8» &a" + Stats.getPoints(p.getName())));
			p.sendMessage(Methods.f("&8&l︳ &fKills &8» &e" + Stats.getKills(p.getName())));
			p.sendMessage(Methods.f("&8&l︳ &fDeaths &8» &b" + Stats.getDeaths(p.getName())));
			p.sendMessage(Methods.f("&8&l︳ &fKill-Streak &8» " + Stats.getStreak(p.getName())));
			p.sendMessage("  ");
		} else if (args.length == 1) { // if player use command with args like /stats <player>
			Player t = Bukkit.getPlayer(args[0]);
			if (t != null) {
			Prestige rank = Prestige.getRankOf(t.getName());

			p.sendMessage("  ");
			p.sendMessage(Methods.f("&6&l" + t.getName() + " &f&lStats"));
			p.sendMessage(Methods.f("&8&l︳ &fRank &8» " + rank.getPrefix()));
			p.sendMessage(Methods.f("&8&l︳ &fPoints &8» &a" + Stats.getPoints(t.getName())));
			p.sendMessage(Methods.f("&8&l︳ &fKills &8» &e" + Stats.getKills(t.getName())));
			p.sendMessage(Methods.f("&8&l︳ &fDeaths &8» &b" + Stats.getDeaths(t.getName())));
			p.sendMessage(Methods.f("&8&l︳ &fKill-Streak &8» " + Stats.getStreak(t.getName())));
			p.sendMessage("  ");
			} else {
				p.sendMessage(Methods.f("&cPlayer not online now please try another once when player be online!"));
			}
		}

		return false;
	}

} // End
