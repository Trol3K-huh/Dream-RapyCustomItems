package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.util.NBTHelper;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;



@RequiredArgsConstructor(onConstructor_ = @Inject)
public class GranatKibicaItem {

    private final ItemsConfig itemsConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.granatKibica.material).orElse(XMaterial.LINGERING_POTION).parseMaterial())
                .setName(itemsConfig.granatKibica.name)
                .setLore(itemsConfig.granatKibica.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.GRANAT_KIBICA);

        return item;
    }

    public void useItem(Location location) {

        double radius = itemsConfig.granatKibica.radius;
        int duration = itemsConfig.granatKibica.effectDuration * 20;

        for (Player player : location.getWorld().getPlayers()) {
            if (player.getLocation().distance(location) <= radius) {

                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, duration, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, duration, 0));


                player.sendMessage("§c§lGranat Kibica §7eksplodowal w poblizu! Otrzymujesz efekty!");
            }
        }
    }

    public boolean isGranatKibica(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.GRANAT_KIBICA);
    }
}
