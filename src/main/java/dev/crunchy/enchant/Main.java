package dev.crunchy.enchant;

import dev.crunchy.enchant.events.EventListener;
import dev.crunchy.enchant.events.MenuListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Economy economy;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        load();
    }

    @Override
    public void onDisable() {
    }

    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {

        return economy;
    }

    private void load() {
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }
}
