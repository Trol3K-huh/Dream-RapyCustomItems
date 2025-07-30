package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.item.KijKielbasaItem;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class KijKielbasaListener implements Listener {

    private final KijKielbasaItem kijKielbasaItem;
    private final ProfileRepository profileRepository;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) {
            return;
        }
        
        Player attacker = (Player) event.getDamager();
        Player target = (Player) event.getEntity();
        

        if (!kijKielbasaItem.isKijKielbasa(attacker.getItemInHand())) {
            return;
        }
        

        Profile attackerProfile = profileRepository.findOrCreate(attacker.getUniqueId(), attacker.getName());
        Profile targetProfile = profileRepository.findOrCreate(target.getUniqueId(), target.getName());
        

        kijKielbasaItem.useItem(attackerProfile, targetProfile);
    }
}
