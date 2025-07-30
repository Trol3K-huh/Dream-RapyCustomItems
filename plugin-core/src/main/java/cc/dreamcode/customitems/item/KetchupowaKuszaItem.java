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
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class KetchupowaKuszaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;
    private final Random random = new Random();

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.ketchupowaKusza.material).orElse(XMaterial.CROSSBOW).parseMaterial())
                .setName(itemsConfig.ketchupowaKusza.name)
                .setLore(itemsConfig.ketchupowaKusza.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.KETCHUPOWA_KUSZA);

        return item;
    }

    public void useItem(Player attacker, Player target) {


        int chance = random.nextInt(100) + 1;
        if (chance > itemsConfig.ketchupowaKusza.pullChance) {

            messageConfig.kuszaPullFailed.send(attacker);
            return;
        }


        teleportPlayerToAttacker(attacker, target);


        messageConfig.kuszaPullSuccess.with("target", target.getName()).send(attacker);
        messageConfig.kuszaPullTarget.with("attacker", attacker.getName()).send(target);
    }

    private void teleportPlayerToAttacker(Player attacker, Player target) {

        Vector direction = attacker.getLocation().getDirection();
        direction.multiply(2);
        direction.setY(0);

        Location teleportLocation = attacker.getLocation().add(direction);


        if (teleportLocation.getBlock().getType().isSolid()) {
            teleportLocation.add(0, 1, 0);
        }

        target.teleport(teleportLocation);
    }

    public boolean isKetchupowaKusza(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.KETCHUPOWA_KUSZA);
    }
}
