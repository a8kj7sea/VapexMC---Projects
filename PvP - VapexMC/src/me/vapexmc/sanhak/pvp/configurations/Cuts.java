package me.vapexmc.sanhak.pvp.configurations;

import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Cuts</b> class , It contains abbreviations for some things so that you do
 * not repeat them and complicate things for you (it just for configuration file
 * right now !) <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Cuts { // Start

	/* (S T A T S) |-----[Just for Configuration]-----| (M E T H O D S) */

	// How much you wanna add points to the Killer when he kill someone ?
	public static int Points_onKill = Configuration.getConfig().getInt("Stats.Points.Killer");

	// How much you wanna remove points from the player when he die ?
	public static int Points_onDeath = Configuration.getConfig().getInt("Stats.Points.Player");

	/* (K I T S) |-----[Just for Configuration]-----| (M E T H O D S) */

	// every thing not free so we should have custom kits with custom perms so -->
	// down
	// This method for the VapexMC kit permissions !
	public static String Kits_Vapex_Perms = Configuration.getConfig().getString("Kits.VapexMC.Permissions");

	// every thing not free so we should have custom kits with custom perms so -->
	// down
	// This method for the Vip kit permissions !
	public static String Kits_Vip_Perms = Configuration.getConfig().getString("Kits.Vip.Permissions");

	/* (B O A R D) |-----[Just for Configuration]-----| (M E T H O D S) */

	// This method to get server ip for the board
	public static String IP = Methods.f(Configuration.getConfig().getString("Scoreboard.IP"));

	

} // End
