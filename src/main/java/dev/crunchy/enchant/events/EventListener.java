package dev.crunchy.enchant.events;

import dev.crunchy.enchant.menus.EnchantMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener {

    @EventHandler
    public static void listener(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        e.setCancelled(true);
        if (e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (player.getInventory().getItemInHand().getType() == Material.DIAMOND_SWORD) {
                    EnchantMenu.open(player);
                    return;
                }
                player.sendMessage("Du skal holde dit sværd i hånden.");
            }
        }
    }

}
