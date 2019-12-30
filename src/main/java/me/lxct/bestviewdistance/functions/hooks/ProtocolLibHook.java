package me.lxct.bestviewdistance.functions.hooks;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import me.lxct.bestviewdistance.BestViewDistance;
import me.lxct.bestviewdistance.functions.BVDPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import static me.lxct.bestviewdistance.functions.data.Variable.onlinePlayers;

class ProtocolLibHook {
    static void protocolLibHook(Plugin plugin) {
        final ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new PacketAdapter(plugin,
                ListenerPriority.NORMAL,
                PacketType.Play.Client.SETTINGS) {
            @Override
            public void onPacketReceiving(PacketEvent e) {
                Bukkit.getScheduler().runTaskLaterAsynchronously(BestViewDistance.plugin, () -> getBVDPlayerData(e), 10L);
            }
        });
    }
    private static void getBVDPlayerData(PacketEvent e){
        if (e.getPacketType() == PacketType.Play.Client.SETTINGS) {
            final PacketContainer packet = e.getPacket();
            final BVDPlayer player = onlinePlayers.get(e.getPlayer());
            player.saveSettingsViewDistance(packet.getIntegers().read(0));
        }
    }
}
