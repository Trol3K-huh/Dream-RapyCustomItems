package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.TrabkaKibicaItem;

import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class TrabkaKibicaListener implements Listener {

    private final ItemsConfig itemsConfig;
    private final TrabkaKibicaItem trabkaKibicaItem;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemStack item = event.getItem();


        if (!trabkaKibicaItem.isTrabkaKibica(item)) {
            return;
        }


        event.setCancelled(true);

        Player player = event.getPlayer();


        if (player.hasCooldown(item.getType())) {
            return;
        }


        player.setCooldown(item.getType(), itemsConfig.trabkaKibica.cooldown * 20);


        trabkaKibicaItem.useItem(player);
    }
}
