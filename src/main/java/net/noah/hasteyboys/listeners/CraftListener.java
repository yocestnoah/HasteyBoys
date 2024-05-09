package net.noah.hasteyboys.listeners;

import net.noah.hasteyboys.HasteyBoys;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {

    private final HasteyBoys plugin;

    public CraftListener(HasteyBoys plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onToolCrafting(PrepareItemCraftEvent event) {
        if(HasteyBoys.status) {

            ItemStack craftedItem = event.getInventory().getResult();

            if(craftedItem == null) {
                return;
            }

            if(!craftedItem.getTranslationKey().contains("_pickaxe") && !craftedItem.getTranslationKey().contains("_axe") && !craftedItem.getTranslationKey().contains("_shovel")) {
                return;
            }

            int efficiencyLevel = this.plugin.getConfig().getInt("efficiency-level");
            int unbreakingLevel = this.plugin.getConfig().getInt("unbreaking-level");

            craftedItem.addEnchantment(Enchantment.DIG_SPEED, efficiencyLevel);
            craftedItem.addEnchantment(Enchantment.DURABILITY, unbreakingLevel);
        }
    }
}