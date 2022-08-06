package dev.crunchy.enchant.utils;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static final String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
