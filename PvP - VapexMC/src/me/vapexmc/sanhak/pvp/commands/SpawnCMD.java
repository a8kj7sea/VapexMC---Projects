package me.vapexmc.sanhak.pvp.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Logger;
import me.vapexmc.sanhak.pvp.methods.Methods;
import me.vapexmc.sanhak.pvp.spawn.SpawnManager;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>SpawnCMD</b> class , It contains on Command allow to the players with
 * permissions to set the spawn and back to spawn <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class SpawnCMD implements CommandExecutor { // Start

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) { // If player use command from console return false and send message !
			Logger.Warn("&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}

		Player p = (Player) cs;
		if (p.hasPermission("pvp.admin")) { // If player has permissions
			if (args.length == 0) { // if player use command without args like /setspawn
				if (!p.isOnGround()) { // Check if the player not on ground
					// If player not on ground will ingore him and send message and play sound
					p.sendMessage(VapexMCPvP.Prefix
							+ Methods.f("&cYou don't on ground please go down and set the spawn ! (don't fly)"));
					p.playSound(p.getLocation(), Sound.DONKEY_ANGRY, 5.0f, 5.0f);

					if (p.isFlying()) { // If player is flying disable it cuz cmd not allowed to flying players
						p.setFlying(false);
					}
				} else { // if player on ground will be allowed to set the spawn
					SpawnManager.set_the_spawn(p);
					p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
					SpawnManager.reload();
					SpawnManager.save();
					p.sendMessage(VapexMCPvP.Prefix
							+ Methods.f("&aSuccessfully set the spawn details in configuration file "));
				}
			} else { // If player use the wrong command!
				p.sendMessage(VapexMCPvP.Prefix + Methods.f("&cWrong use please try to type &f/setspawn"));
			}
		} else { // if player hasn't permissions !
			p.sendMessage(
					VapexMCPvP.Prefix + Methods.f("&cYou don't have enough of permissions to use this command !"));
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 5.0f, 5.0f);
		}

		return false;
	}

} // End
