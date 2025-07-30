package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.KotwiczkaItem;

import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class KotwiczkaListener implements Listener {

    private final KotwiczkaItem kotwiczkaItem;
    private final ItemsConfig itemsConfig;




    private final Map<UUID, Location> hookLocations = new HashMap<>();

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        ItemStack item = event.getPlayer().getItemInHand();


        if (!kotwiczkaItem.isKotwiczka(item)) {
            return;
        }

        UUID playerId = event.getPlayer().getUniqueId();

        if (event.getState() == PlayerFishEvent.State.FISHING) {

            if (event.getHook() != null) {
                hookLocations.put(playerId, event.getHook().getLocation().clone());
            }
            return;
        }

        if (event.getState() == PlayerFishEvent.State.REEL_IN) {

            Location hookLocation = hookLocations.get(playerId);
            if (hookLocation == null) {
                return;
            }


            hookLocations.remove(playerId);


            event.setCancelled(true);

            Player player = event.getPlayer();


            if (player.hasCooldown(player.getInventory().getItemInMainHand().getType())) {
                return;
            }


            player.setCooldown(player.getInventory().getItemInMainHand().getType(), itemsConfig.kotwiczka.cooldown * 20);


            kotwiczkaItem.useItem(player, hookLocation);
        }
    }

    private Location calculateHookLocation(Player player) {

        Location playerLoc = player.getLocation();
        org.bukkit.util.Vector direction = playerLoc.getDirection();


        double maxDistance = 30.0;
        Location targetLoc = playerLoc.clone();

        for (double i = 1; i <= maxDistance; i += 0.5) {
            targetLoc = playerLoc.clone().add(direction.clone().multiply(i));


            if (targetLoc.getBlock().getType().isSolid() ||
                targetLoc.getY() <= 0) {
                break;
            }
        }

        return targetLoc;
    }
}
