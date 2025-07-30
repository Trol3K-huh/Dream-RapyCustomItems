package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.util.NBTHelper;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class KotwiczkaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.kotwiczka.material).orElse(XMaterial.FISHING_ROD).parseMaterial())
                .setName(itemsConfig.kotwiczka.name)
                .setLore(itemsConfig.kotwiczka.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.KOTWICZKA);

        return item;
    }

    public void useItem(Player player, Location targetLocation) {


        double distance = player.getLocation().distance(targetLocation);
        if (distance > itemsConfig.kotwiczka.maxRange) {
            player.sendMessage("§c§lKotwiczka §7- Za daleko! Maksymalny zasieg: §e" + itemsConfig.kotwiczka.maxRange + " §7kratek.");
            return;
        }


        pullPlayerToLocation(player, targetLocation);
        messageConfig.kotwiczkaUsed.send(player);
    }

    private void pullPlayerToLocation(Player player, Location targetLocation) {

        org.bukkit.util.Vector direction = targetLocation.toVector().subtract(player.getLocation().toVector());


        if (direction.length() < 2.0) {
            player.sendMessage("§b§lKotwiczka §7- Za blisko!");
            return;
        }


        direction.normalize().multiply(2.0);


        double distance = player.getLocation().distance(targetLocation);
        direction.setY(Math.max(direction.getY() + 0.3, 0.5 + (distance * 0.1)));


        player.setVelocity(direction);
    }



    public boolean isKotwiczka(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.KOTWICZKA);
    }
}
