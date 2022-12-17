package me.vapexmc.sanhak.pvp.features;


import me.vapexmc.sanhak.pvp.methods.Methods;


/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>Prestige</b> class , this class to display the prestige / 
 * thanks to Mqzn cuz him help me with this class <3
 * <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public enum Prestige { // Start

	UNRANKED(Methods.f("&7UNRANKED"), 0), R2(Methods.f("&cRedstone"), 500), R3(Methods.f("&fIron"), 1000),
	R4(Methods.f("&6Gold"), 1500), R5(Methods.f("&bDiamond"), 2000), R6(Methods.f("&aEmerald"), 2500),
	R7(Methods.f("&0Bedrock"), 5000);

	private final String prefix;
	private final int requiredKills;

	private Prestige(String prefix, int requiredKills) {
		this.prefix = prefix;
		this.requiredKills = requiredKills;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public int getKillsRequired() {
		return this.requiredKills;
	}

	public static Prestige getRankOf(String name) {
		int kills = Stats.getKills(name);
		Prestige[] ranks = values();

		for (int i = ranks.length - 1; i >= 0; --i) {
			if (kills >= ranks[i].getKillsRequired()) {
				return ranks[i];
			}
		}

		return UNRANKED;
	}
} // End