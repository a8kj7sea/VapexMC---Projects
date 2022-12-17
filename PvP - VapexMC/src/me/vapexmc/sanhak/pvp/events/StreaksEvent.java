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
		if (a == 5 || a == 10 || a == 15 || a == 20 || a == 25 || a == 30 || a == 35 || a == 35 || a == 40 || a == 45
				|| a == 50 || a == 55 || a == 60 || a == 65 || a == 70 || a == 75 || a == 80 || a == 85 || a == 90
				|| a == 95 || a == 100 || a == 105 || a == 110 || a == 115 || a == 120 || a == 125 || a == 130
				|| a == 135 || a == 135 || a == 140 || a == 145 || a == 150 || a == 155 || a == 160 || a == 165
				|| a == 170 || a == 175 || a == 180 || a == 185 || a == 190 || a == 195 || a == 200 || a == 205
				|| a == 210 || a == 215 || a == 220 || a == 225 || a == 230 || a == 235 || a == 235 || a == 240
				|| a == 245 || a == 250 || a == 255 || a == 260 || a == 265 || a == 270 || a == 275 || a == 280
				|| a == 285 || a == 290 || a == 295 || a == 300 || a == 305 || a == 310 || a == 315 || a == 320
				|| a == 325 || a == 330 || a == 335 || a == 335 || a == 340 || a == 345 || a == 350 || a == 355
				|| a == 360 || a == 365 || a == 370 || a == 375 || a == 380 || a == 385 || a == 390 || a == 395
				|| a == 400 || a == 405 || a == 410 || a == 415 || a == 420 || a == 425 || a == 430 || a == 435
				|| a == 435 || a == 440 || a == 445 || a == 450 || a == 455 || a == 460 || a == 465 || a == 470
				|| a == 475 || a == 480 || a == 485 || a == 490 || a == 495 || a == 500 || a == 505 || a == 510
				|| a == 515 || a == 520 || a == 525 || a == 530 || a == 535 || a == 535 || a == 540 || a == 545
				|| a == 550 || a == 555 || a == 560 || a == 565 || a == 570 || a == 575 || a == 580 || a == 585
				|| a == 590 || a == 595 || a == 600 || a == 605 || a == 610 || a == 615 || a == 620 || a == 625
				|| a == 630 || a == 635 || a == 635 || a == 640 || a == 645 || a == 650 || a == 655 || a == 660
				|| a == 665 || a == 670 || a == 675 || a == 680 || a == 685 || a == 690 || a == 695 || a == 700
				|| a == 705 || a == 710 || a == 715 || a == 720 || a == 725 || a == 730 || a == 735 || a == 735
				|| a == 740 || a == 745 || a == 750 || a == 755 || a == 760 || a == 765 || a == 770 || a == 775
				|| a == 780 || a == 785 || a == 790 || a == 795 || a == 800 || a == 805 || a == 810 || a == 815
				|| a == 820 || a == 825 || a == 830 || a == 835 || a == 835 || a == 840 || a == 845 || a == 850
				|| a == 855 || a == 860 || a == 865 || a == 870 || a == 875 || a == 880 || a == 885 || a == 890
				|| a == 895 || a == 900 || a == 905 || a == 910 || a == 915 || a == 920 || a == 925 || a == 930
				|| a == 935 || a == 935 || a == 940 || a == 945 || a == 950 || a == 955 || a == 960 || a == 965
				|| a == 970 || a == 975 || a == 980 || a == 985 || a == 990 || a == 995 || a == 1000) {
			Bukkit.broadcastMessage(VapexMCPvP.Prefix + Methods.f("&c" + p.getDisplayName() + " &7got &b" + a));

			Board.setBoard(p);

		}

	}
} // End