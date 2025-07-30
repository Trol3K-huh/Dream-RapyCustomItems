package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.util.NBTHelper;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class TrabkaKibicaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.trabkaKibica.material).orElse(XMaterial.GOAT_HORN).parseMaterial())
                .setName(itemsConfig.trabkaKibica.name)
                .setLore(itemsConfig.trabkaKibica.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.TRABKA_KIBICA);

        return item;
    }

    public void useItem(Player player) {

        double range = itemsConfig.trabkaKibica.range;
        List<Player> nearbyPlayers = player.getWorld().getPlayers().stream()
                .filter(p -> p.getLocation().distance(player.getLocation()) <= range)
                .toList();

        int duration = itemsConfig.trabkaKibica.effectDuration * 20;

        for (Player nearbyPlayer : nearbyPlayers) {
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, 1));
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 1));

            if (!nearbyPlayer.equals(player)) {
                messageConfig.trabkaNearby.send(nearbyPlayer);
            }
        }

        messageConfig.trabkaUsed.send(player);
    }

    public boolean isTrabkaKibica(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.TRABKA_KIBICA);
    }
}
