package me.vapexmc.sanhak.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.vapexmc.sanhak.pvp.configurations.Configuration;
import me.vapexmc.sanhak.pvp.features.Stats;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Logger;
import me.vapexmc.sanhak.pvp.methods.Methods;
import me.vapexmc.sanhak.pvp.spawn.SpawnManager;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>ReloadCMD</b> class , It contains on Command allow to Reload (load)
 * configuration files <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class ReloadCMD implements CommandExecutor { // Start

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) { // If player use command from console return false and send message !
			Logger.Warn("&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}

		Player p = (Player) cs;
		if (p.hasPermission("pvp.admin")) { // If player has permissions
			if (args.length == 0) { // if player use command without args like /sclrlc
				// Reload Configuration
				Configuration.reload();
				Configuration.save();

				// relaod spawn configuration
				SpawnManager.reload();
				SpawnManager.save();

				// relaod stats configuration
				Stats.reload();
				Stats.save();

				Bukkit.getPluginManager().disablePlugin(VapexMCPvP.getMain());
				Bukkit.getPluginManager().enablePlugin(VapexMCPvP.getMain());
				p.sendMessage(VapexMCPvP.Prefix + Methods.f("&aSuccessfully reloaded the configuraion file !"));
			} else { // If player use the wrong command!
				p.sendMessage(VapexMCPvP.Prefix + Methods.f("&cWrong use please try to type &f/reloadconfig"));
			}
		} else { // if player hasn't permissions !
			p.sendMessage(
					VapexMCPvP.Prefix + Methods.f("&cYou don't have enough of permissions to use this command !"));
			p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5, 5);
		}

		return false;
	}
}