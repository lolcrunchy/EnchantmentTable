package dev.crunchy.enchant.events;

import dev.crunchy.enchant.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.Plugin;

public class MenuListener implements Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    private static Economy economy = Main.economy;

    /**
     * economy.withdrawPlayer(player, 25);
     * economy.
     * @param e
     */

    @EventHandler
    public static void onInvClick(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        final double balance = economy.getBalance(player);
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("Enchant Menu")) {
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getName().equals("Enchant Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            } else if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }

            //knockback
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Knockback")) {
                if (balance >= 25) {
                    economy.withdrawPlayer(player, 25);

                    player.closeInventory();
                } else {

                    player.closeInventory();
                }
            }
        }
    }

}
