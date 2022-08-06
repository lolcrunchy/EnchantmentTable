package dev.crunchy.enchant.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class LoreUtil {

    public static final ArrayList<String> loreMaker(String... str) {
        ArrayList<String> lore = new ArrayList<>();
        for(String s : str) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return lore;
    }

}
