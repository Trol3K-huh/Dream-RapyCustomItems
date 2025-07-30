package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.util.NBTHelper;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PlecakKibicaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.plecakKibica.material).orElse(XMaterial.SHULKER_BOX).parseMaterial())
                .setName(itemsConfig.plecakKibica.name)
                .setLore(itemsConfig.plecakKibica.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.PLECAK_KIBICA);

        return item;
    }

    public void collectItems(Profile killerProfile, Profile victimProfile) {
        Player killer = Bukkit.getPlayer(killerProfile.getUniqueId());
        Player victim = Bukkit.getPlayer(victimProfile.getUniqueId());

        if (killer == null || victim == null) {
            return;
        }

        ItemStack[] victimInventory = victim.getInventory().getContents();

        for (ItemStack item : victimInventory) {
            if (item != null && item.getType() != XMaterial.AIR.parseMaterial()) {

                if (killer.getInventory().firstEmpty() == -1) {
                    killer.getWorld().dropItemNaturally(killer.getLocation(), item);
                } else {
                    killer.getInventory().addItem(item);
                }
            }
        }

        victim.getInventory().clear();
        messageConfig.plecakCollected.send(killer);
    }

    public boolean isPlecakKibica(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.PLECAK_KIBICA);
    }

    public boolean hasPlecakInInventory(Player player) {
        ItemStack[] contents = player.getInventory().getContents();
        for (ItemStack item : contents) {
            if (isPlecakKibica(item)) {
                return true;
            }
        }
        return false;
    }
}
