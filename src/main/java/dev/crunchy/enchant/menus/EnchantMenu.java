package dev.crunchy.enchant.menus;

import dev.crunchy.enchant.Main;
import dev.crunchy.enchant.utils.ItemUtil;
import dev.crunchy.enchant.utils.LoreUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EnchantMenu {
    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "Enchant Menu");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                ItemStack head;

                for (int i = 0; i < 10; i++) {
                    item = ItemUtil.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, LoreUtil.loreMaker(""));
                    inv.setItem(i, item);
                }
                for (int i = 17; i < 19; i++) {
                    item = ItemUtil.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, LoreUtil.loreMaker(""));
                    inv.setItem(i, item);
                }
                for (int i = 26; i < 28; i++) {
                    item = ItemUtil.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, LoreUtil.loreMaker(""));
                    inv.setItem(i, item);
                }
                for (int i = 35; i < 40; i++) {
                    item = ItemUtil.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, LoreUtil.loreMaker(""));
                    inv.setItem(i, item);
                }
                item = ItemUtil.itemMaker("§c§lLUK MENUEN", Material.BARRIER, 1, 0, LoreUtil.loreMaker(""));
                inv.setItem(40, item);
                for (int i = 41; i < 45; i++) {
                    item = ItemUtil.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, LoreUtil.loreMaker(""));
                    inv.setItem(i, item);
                }
                item = ItemUtil.itemMaker("§3§l" + player.getInventory().getItemInHand().getItemMeta().getDisplayName(), player.getInventory().getItemInHand().getType(), 1, 0, LoreUtil.loreMaker(""));
                inv.setItem(4, item);
            }
        }, 1L);
    }

}
