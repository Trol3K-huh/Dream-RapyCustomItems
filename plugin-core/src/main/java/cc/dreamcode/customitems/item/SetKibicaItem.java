package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SetKibicaItem {

    private final ItemsConfig itemsConfig;


    public ItemStack createHelmet1() {
        return createArmorPiece(XMaterial.LEATHER_HELMET, "helmet", itemsConfig.setKibica1);
    }

    public ItemStack createChestplate1() {
        return createArmorPiece(XMaterial.LEATHER_CHESTPLATE, "chestplate", itemsConfig.setKibica1);
    }

    public ItemStack createLeggings1() {
        return createArmorPiece(XMaterial.LEATHER_LEGGINGS, "leggings", itemsConfig.setKibica1);
    }

    public ItemStack createBoots1() {
        return createArmorPiece(XMaterial.LEATHER_BOOTS, "boots", itemsConfig.setKibica1);
    }


    public ItemStack createHelmet2() {
        return createArmorPiece(XMaterial.CHAINMAIL_HELMET, "helmet", itemsConfig.setKibica2);
    }

    public ItemStack createChestplate2() {
        return createArmorPiece(XMaterial.CHAINMAIL_CHESTPLATE, "chestplate", itemsConfig.setKibica2);
    }

    public ItemStack createLeggings2() {
        return createArmorPiece(XMaterial.CHAINMAIL_LEGGINGS, "leggings", itemsConfig.setKibica2);
    }

    public ItemStack createBoots2() {
        return createArmorPiece(XMaterial.CHAINMAIL_BOOTS, "boots", itemsConfig.setKibica2);
    }




    private ItemStack createArmorPiece(XMaterial material, String type, ItemsConfig.SetKibicaConfig config) {

        String itemName;
        switch (type) {
            case "helmet":
                itemName = config.helmetName;
                break;
            case "chestplate":
                itemName = config.chestplateName;
                break;
            case "leggings":
                itemName = config.leggingsName;
                break;
            case "boots":
                itemName = config.bootsName;
                break;
            default:
                itemName = "&6&lElement Setu Kibica {version}";
        }


        itemName = itemName.replace("{version}", config.version);


        List<String> processedLore = new ArrayList<>();
        for (String line : config.lore) {
            String processedLine = line
                .replace("{version}", config.version)
                .replace("{enchant_level}", String.valueOf(config.enchantLevel))
                .replace("{drop_bonus}", String.valueOf(config.dropBonus))
                .replace("{full_set_bonus}", String.valueOf(config.fullSetBonus));
            processedLore.add(processedLine);
        }

        ItemStack armor = new ItemBuilder(material.parseMaterial())
                .setName(itemName)
                .setLore(processedLore)
                .fixColors()
                .toItemStack();
        

        armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, config.enchantLevel);
        armor.addUnsafeEnchantment(Enchantment.DURABILITY, config.enchantLevel);
        
        return armor;
    }


    public boolean isSetKibica1(ItemStack item) {
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return false;
        }

        String itemName = item.getItemMeta().getDisplayName();

        return itemName.contains(itemsConfig.setKibica1.version);
    }

    public boolean isSetKibica2(ItemStack item) {
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return false;
        }

        String itemName = item.getItemMeta().getDisplayName();

        return itemName.contains(itemsConfig.setKibica2.version);
    }




    public boolean hasFullSet1(Player player) {
        return isSetKibica1(player.getInventory().getHelmet()) &&
               isSetKibica1(player.getInventory().getChestplate()) &&
               isSetKibica1(player.getInventory().getLeggings()) &&
               isSetKibica1(player.getInventory().getBoots());
    }

    public boolean hasFullSet2(Player player) {
        return isSetKibica2(player.getInventory().getHelmet()) &&
               isSetKibica2(player.getInventory().getChestplate()) &&
               isSetKibica2(player.getInventory().getLeggings()) &&
               isSetKibica2(player.getInventory().getBoots());
    }




    public int calculateDropBonus(Player player) {
        int bonus = 0;
        

        if (isSetKibica1(player.getInventory().getHelmet())) bonus += itemsConfig.setKibica1.dropBonus;
        if (isSetKibica1(player.getInventory().getChestplate())) bonus += itemsConfig.setKibica1.dropBonus;
        if (isSetKibica1(player.getInventory().getLeggings())) bonus += itemsConfig.setKibica1.dropBonus;
        if (isSetKibica1(player.getInventory().getBoots())) bonus += itemsConfig.setKibica1.dropBonus;
        

        if (isSetKibica2(player.getInventory().getHelmet())) bonus += itemsConfig.setKibica2.dropBonus;
        if (isSetKibica2(player.getInventory().getChestplate())) bonus += itemsConfig.setKibica2.dropBonus;
        if (isSetKibica2(player.getInventory().getLeggings())) bonus += itemsConfig.setKibica2.dropBonus;
        if (isSetKibica2(player.getInventory().getBoots())) bonus += itemsConfig.setKibica2.dropBonus;
        

        if (hasFullSet1(player)) bonus += itemsConfig.setKibica1.fullSetBonus;
        if (hasFullSet2(player)) bonus += itemsConfig.setKibica2.fullSetBonus;
        
        return bonus;
    }
}
