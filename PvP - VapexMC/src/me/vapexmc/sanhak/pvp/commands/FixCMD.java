package me.vapexmc.sanhak.pvp.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.vapexmc.sanhak.pvp.cooldown.Manager;
import me.vapexmc.sanhak.pvp.features.Board;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Logger;
import me.vapexmc.sanhak.pvp.methods.Methods;
import net.md_5.bungee.api.ChatColor;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>FixCMD</b> class , It contains on Command using by player to fix him <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class FixCMD implements CommandExecutor { // Start

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) { // If player use command from console return false and send message !
			Logger.Warn("&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}

		Player p = (Player) cs;
		if (Manager.checkCooldown(p)) { // Check if player not in cooldown
			Manager.setCooldown(p, 3); // add cooldown to player (add player to cooldown)
			Methods.Fix(p);
			Board.setBoard(p);
			p.sendMessage(VapexMCPvP.Prefix + Methods.f("&aYou have been fixed ! Have a good day sir <3"));
		} else { // if player in cool down will send message to him and play sound
			p.sendMessage(VapexMCPvP.Prefix + ChatColor.RED + "Please wait for a " + ChatColor.WHITE
					+ Manager.getCooldown(p) + ChatColor.RED + " seconds to use it again !");
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3.0f, 3.0f);
		}
		return false;
	}

} // End
