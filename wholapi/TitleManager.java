

// Author lost (edited by Curiosow)

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

@SuppressWarnings("rawtypes")
public class TitleManager {


    public static void sendTitle(String title, Player p, int fadein, int staytime, int fadeout) {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle packet2 = new PacketPlayOutTitle(fadein, staytime, fadeout);
        (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet);
        (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet2);
    }

    public static void sendSubTitle(String subtitle, Player p, int fadein, int staytime, int fadeout) {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatTitle);
        PacketPlayOutTitle packet2 = new PacketPlayOutTitle(fadein, staytime, fadeout);
        (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet);
        (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet2);
    }

    public static void setPlayerList(Player player, String header, String footer) {
        IChatBaseComponent hj = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + header + "\"}");
        IChatBaseComponent fj = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + footer + "\"}");
        PacketPlayOutPlayerListHeaderFooter packet = (PacketPlayOutPlayerListHeaderFooter)constructHeaderAndFooterPacket(hj, fj);
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)packet);
    }

    public static void clear(Player player) {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"\"}");
        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.RESET, chatTitle);
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)title);
    }

    public static void sendActionBar(Player player, String message) {
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)ppoc);
    }

    @SuppressWarnings("deprecation")
    private static Object constructHeaderAndFooterPacket(Object header, Object footer) {
        try {
            Object packet = PacketPlayOutPlayerListHeaderFooter.class.newInstance();
            if (header != null) {
                Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("a");
                field.setAccessible(true);
                field.set(packet, header);
                field.setAccessible(false);
            }
            if (footer != null) {
                Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("b");
                field.setAccessible(true);
                field.set(packet, footer);
                field.setAccessible(false);
            }
            return packet;
        } catch (InstantiationException|IllegalAccessException|NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

}
