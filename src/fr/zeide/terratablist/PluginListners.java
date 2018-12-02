package fr.zeide.terratablist;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

public class PluginListners implements Listener {
	
	public static void setPlayerList(Player player, String header, String footer){
		IChatBaseComponent hj = ChatSerializer.a("{\"text\": \"" + header + "\"}");
		IChatBaseComponent fj = ChatSerializer.a("{\"text\": \"" + footer +"\"}");
		PacketPlayOutPlayerListHeaderFooter packet = (PacketPlayOutPlayerListHeaderFooter) constructHeaderAndFooterPacket(hj, fj);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
	}
	
    private static Object constructHeaderAndFooterPacket(Object header, Object footer){
		try{
			Object packet = PacketPlayOutPlayerListHeaderFooter.class.newInstance();
			if(header != null){
				Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("a");
				field.setAccessible(true);
				field.set(packet, header);
				field.setAccessible(false);
			}
			if(footer != null){
				Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("b");
				field.setAccessible(true);
				field.set(packet, footer);
				field.setAccessible(false);
			}
			return packet;
		}catch (InstantiationException | IllegalAccessException | NoSuchFieldException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
			
		setPlayerList(e.getPlayer(), "§7Welcome" + e.getPlayer().getName() + "to §aTerra§2Network §7! \n" + "Join our discord now : §ehttps://discord.gg/N9YXpFv §7!", "§e" + Bukkit.getOnlinePlayers().size() + " §7players online. \n" + "Type §e/shop §7to have access to the shop !");
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				setPlayerList(e.getPlayer(), "§7Welcome" + e.getPlayer().getName() + "to §aTerra§2Network §7! \n" + "Join our discord now : §ehttps://discord.gg/N9YXpFv §7!", "§e" + Bukkit.getOnlinePlayers().size() + " §7players online. \n" + "Type §e/shop §7to have access to the shop !");
	        
			}
				
        }.runTaskTimer(Core.getInstance(), 0, 10);
		
	}

}
