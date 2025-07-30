package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.item.PlecakKibicaItem;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PlecakKibicaListener implements Listener {

    private final PlecakKibicaItem plecakKibicaItem;
    private final ProfileRepository profileRepository;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();


        if (killer == null || !plecakKibicaItem.hasPlecakInInventory(killer)) {
            return;
        }


        Profile killerProfile = profileRepository.findOrCreate(killer.getUniqueId(), killer.getName());
        Profile victimProfile = profileRepository.findOrCreate(event.getEntity().getUniqueId(), event.getEntity().getName());


        plecakKibicaItem.collectItems(killerProfile, victimProfile);


        event.getDrops().clear();
    }
}
