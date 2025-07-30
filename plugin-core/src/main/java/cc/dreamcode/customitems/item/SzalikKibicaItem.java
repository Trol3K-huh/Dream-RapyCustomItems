package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.util.NBTHelper;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;



@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SzalikKibicaItem {

    private final ItemsConfig itemsConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.szalikKibica.material).orElse(XMaterial.WHITE_BANNER).parseMaterial())
                .setName(itemsConfig.szalikKibica.name)
                .setLore(itemsConfig.szalikKibica.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.SZALIK_KIBICA);

        return item;
    }

    public boolean isSzalikKibica(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.SZALIK_KIBICA);
    }

    public boolean hasSzalikInInventory(Player player) {
        ItemStack[] contents = player.getInventory().getContents();
        for (ItemStack item : contents) {
            if (isSzalikKibica(item)) {
                return true;
            }
        }
        return false;
    }
}
