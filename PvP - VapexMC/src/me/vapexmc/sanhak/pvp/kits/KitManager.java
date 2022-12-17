package me.vapexmc.sanhak.pvp.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.vapexmc.sanhak.pvp.configurations.Cuts;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>KitManager</b> class , It contains on a little method to check on
 * permissions and give the kit right now <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class KitManager { // Start

	// This method check on player permissions and give him his kit according to his
	// permissions
	public static void check_on_perms_and_give_kits(Player p) {
		// if the player have VapexMC Kit permissions he will get the VapexMC kit after
		// clear his inventory
		if (p.hasPermission(Cuts.Kits_Vapex_Perms)) { // Check on player permissions
			p.getInventory().clear(); // Clear the Player inventory
			VapexMC.Set_VapexMC_Kit(p); // Add kit to player
			// if the player have Vip Kit permissions he will get the Vip kit after clear
			// his inventory
		} else if (p.hasPermission(Cuts.Kits_Vip_Perms)) { // Check on player permissions
			p.getInventory().clear(); // Clear the Player inventory
			Vip.Set_Vip_Kit(p); // Add kit to player
			// if player not have any permissions he will get the default kit (member kit)
		} else {
			p.getInventory().clear(); // Clear the Player inventory
			Member.Set_Member_Kit(p); // Add kit to player
		}
	}
	
	// This method to Make Arrows item to death event
	public static ItemStack ArrowToKiller(Player p) {
		ItemStack item = new ItemStack(Material.ARROW, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Methods.f("&f&lARROW"));
		item.setItemMeta(meta);
		return item;
	}

} // End
