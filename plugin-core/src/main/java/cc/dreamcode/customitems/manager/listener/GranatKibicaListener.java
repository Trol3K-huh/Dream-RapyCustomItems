package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.GranatKibicaItem;

import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.LingeringPotion;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class GranatKibicaListener implements Listener {

    private final GranatKibicaItem granatKibicaItem;
    private final ItemsConfig itemsConfig;
    

    private final Map<UUID, UUID> potionOwners = new HashMap<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity() instanceof LingeringPotion) && !(event.getEntity() instanceof ThrownPotion)) {
            return;
        }
        
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }
        
        Player player = (Player) event.getEntity().getShooter();
        ItemStack item = player.getItemInHand();
        

        if (granatKibicaItem.isGranatKibica(item)) {

            potionOwners.put(event.getEntity().getUniqueId(), player.getUniqueId());
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        UUID shooterId = potionOwners.get(event.getEntity().getUniqueId());
        if (shooterId == null) {
            return;
        }
        
        Player shooter = org.bukkit.Bukkit.getPlayer(shooterId);
        if (shooter == null) {
            return;
        }


        Material granatMaterial = XMaterial.matchXMaterial(itemsConfig.granatKibica.material).orElse(XMaterial.LINGERING_POTION).parseMaterial();
        if (shooter.hasCooldown(granatMaterial)) {
            return;
        }


        shooter.setCooldown(granatMaterial, itemsConfig.granatKibica.cooldown * 20);
        

        granatKibicaItem.useItem(event.getEntity().getLocation());
        

        potionOwners.remove(event.getEntity().getUniqueId());
    }
}
