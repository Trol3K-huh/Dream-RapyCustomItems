package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.LapkaKibicaItem;

import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class LapkaKibicaListener implements Listener {

    private final LapkaKibicaItem lapkaKibicaItem;
    private final ItemsConfig itemsConfig;
    private final ProfileRepository profileRepository;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) {
            return;
        }
        

        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        
        Player attacker = (Player) event.getDamager();
        Player target = (Player) event.getEntity();

        ItemStack item = attacker.getInventory().getItemInMainHand();


        if (!lapkaKibicaItem.isLapkaKibica(item)) {
            return;
        }


        Profile attackerProfile = profileRepository.findOrCreate(attacker.getUniqueId(), attacker.getName());
        Profile targetProfile = profileRepository.findOrCreate(target.getUniqueId(), target.getName());



        lapkaKibicaItem.useItem(attackerProfile, targetProfile);
    }
}
