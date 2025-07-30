package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.SzalikKibicaItem;
import cc.dreamcode.customitems.profile.ProfileRepository;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SzalikKibicaListener implements Listener {

    private final SzalikKibicaItem szalikKibicaItem;
    private final ItemsConfig itemsConfig;
    private final ProfileRepository profileRepository;
    private final Random random = new Random();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (!szalikKibicaItem.hasSzalikInInventory(event.getPlayer())) {
            return;
        }


        if (random.nextInt(100) >= itemsConfig.szalikKibica.dropBonus) {
            return;
        }


        Collection<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getItemInHand());
        Location dropLocation = event.getBlock().getLocation();


        for (ItemStack drop : drops) {
            if (drop != null && drop.getType() != XMaterial.AIR.parseMaterial()) {

                int bonusAmount = Math.max(1, (int) Math.ceil(drop.getAmount() * 0.5));
                ItemStack bonusDrop = drop.clone();
                bonusDrop.setAmount(bonusAmount);


                event.getPlayer().getWorld().dropItemNaturally(dropLocation, bonusDrop);
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack itemInHand = event.getItemInHand();


        if (szalikKibicaItem.isSzalikKibica(itemInHand)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§c§lSzalik Kibica §7nie może być postawiony!");
        }
    }
}
