package me.vapexmc.sanhak.pvp.features;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.vapexmc.sanhak.pvp.configurations.Cuts;
import me.vapexmc.sanhak.pvp.main.VapexMCPvP;
import me.vapexmc.sanhak.pvp.methods.Methods;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Board</b> class , It contains a little methods to display the scoreboard
 * to player with his stats <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Board { // Start
	public static ArrayList<String> A = new ArrayList<String>();

	// this method to display the scoreboard to player
	public static void setBoard(Player p) {
		Prestige rank = Prestige.getRankOf(p.getName());
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective ob = sb.registerNewObjective("VapexMC-Beta", "Sanhak");
		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		A.clear();
		A.add("F");
		scheduler.scheduleSyncRepeatingTask(VapexMCPvP.getMain(), new Runnable() {
			public void run() {
				Integer i = A.size();
				if (i == 1) {
					ob.setDisplayName(Methods.f("&6&lPvP"));
					A.add("A");
				}
				if (i == 2) {
					ob.setDisplayName(Methods.f("&f&lP&6&lvP"));
					A.add("B");
				}
				if (i == 3) {
					ob.setDisplayName(Methods.f("&f&lPv&6&lP"));
					A.add("C");
				}
				if (i == 4) {
					ob.setDisplayName(Methods.f("&f&lPvP"));
					A.add("D");
				}
				if (i == 5) {
					ob.setDisplayName(Methods.f("&f&lPvP"));
					A.add("d22dd");
				}
				if (i == 5) {
					A.clear();
					A.add("ddd");
				}
			}
		}, 0L, 15L);
		Score s0 = ob.getScore(Methods.f("&e"));
		Score s1 = ob.getScore(Methods.f("&8&l︳ &6&lPrestige"));
		Score s2 = ob.getScore(Methods.f(" &8» " + rank.getPrefix()));
		Score s3 = ob.getScore(Methods.f("&e "));
		Score s4 = ob.getScore(Methods.f("&1 "));
		Score s5 = ob.getScore(Methods.f("&8&l︳ &fPoints &8» &a" + Stats.getPoints(p.getName())));
		Score s6 = ob.getScore(Methods.f("&8&l︳ &fStreaks &8» &4" + Stats.getStreak(p.getName())));
		Score s7 = ob.getScore(Methods.f("&8&l︳ &fKills &8» &c" + Stats.getKills(p.getName())));
		Score s8 = ob.getScore(Methods.f("&b "));	
		Score s9 = ob.getScore(Cuts.IP);
		s0.setScore(9);
		s1.setScore(8);
		s2.setScore(7);
		s3.setScore(6);
		s4.setScore(5);
		s5.setScore(4);
		s6.setScore(3);
		s7.setScore(2);
		s8.setScore(1);
		s9.setScore(0);
		p.setScoreboard(sb);
	}

} // End
