package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.PilkaKibicaItem;

import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PilkaKibicaListener implements Listener {

    private final PilkaKibicaItem pilkaKibicaItem;
    private final ItemsConfig itemsConfig;
    private final ProfileRepository profileRepository;
    

    private final Map<UUID, UUID> snowballOwners = new HashMap<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity() instanceof Snowball)) {
            return;
        }
        
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }
        
        Player player = (Player) event.getEntity().getShooter();
        ItemStack item = player.getItemInHand();
        

        if (pilkaKibicaItem.isPilkaKibica(item)) {

            snowballOwners.put(event.getEntity().getUniqueId(), player.getUniqueId());
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Snowball) || !(event.getEntity() instanceof Player)) {
            return;
        }
        
        Snowball snowball = (Snowball) event.getDamager();
        Player target = (Player) event.getEntity();
        

        UUID shooterId = snowballOwners.get(snowball.getUniqueId());
        if (shooterId == null) {
            return;
        }
        
        Player shooter = org.bukkit.Bukkit.getPlayer(shooterId);
        if (shooter == null) {
            return;
        }
        

        Profile shooterProfile = profileRepository.findOrCreate(shooter.getUniqueId(), shooter.getName());
        Profile targetProfile = profileRepository.findOrCreate(target.getUniqueId(), target.getName());


        Material pilkaMaterial = XMaterial.matchXMaterial(itemsConfig.pilkaKibica.material).orElse(XMaterial.SNOWBALL).parseMaterial();
        if (shooter.hasCooldown(pilkaMaterial)) {
            return;
        }


        shooter.setCooldown(pilkaMaterial, itemsConfig.pilkaKibica.cooldown * 20);


        pilkaKibicaItem.useItem(shooterProfile, targetProfile);
        

        snowballOwners.remove(snowball.getUniqueId());
    }
}
