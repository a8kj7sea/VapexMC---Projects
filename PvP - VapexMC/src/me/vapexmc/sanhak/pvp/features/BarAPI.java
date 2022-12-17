package me.vapexmc.sanhak.pvp.features;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * [<b>VapexMC Development Team</b>] <br>
 * <br>
 * <b>BarAPI</b> class , It contains a little methods to handle with the action
 * bar and display it <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class BarAPI { // Start

	// This method to send action bar to player with custom text | it cotains 2
	// parms p tp choose the player and Msg to put custom text
	public static void send(Player P, String Msg) {
		CraftPlayer CraftPlayer = (CraftPlayer) P;
		IChatBaseComponent ChatComponent = ChatSerializer.a("{\"text\": \"" + Msg.replaceAll("&", "§") + "\"}");
		PacketPlayOutChat Packet2 = new PacketPlayOutChat(ChatComponent, (byte) 2);
		CraftPlayer.getHandle().playerConnection.sendPacket(Packet2);
	}
} // End