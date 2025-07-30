package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.item.KetchupowaKuszaItem;

import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class KetchupowaKuszaListener implements Listener {

    private final KetchupowaKuszaItem ketchupowaKuszaItem;
    private final ItemsConfig itemsConfig;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Arrow) ||
            !(((Arrow) event.getDamager()).getShooter() instanceof Player) ||
            !(event.getEntity() instanceof Player)) {
            return;
        }

        Player attacker = (Player) ((Arrow) event.getDamager()).getShooter();
        Player target = (Player) event.getEntity();


        if (!ketchupowaKuszaItem.isKetchupowaKusza(attacker.getItemInHand())) {
            return;
        }


        if (attacker.hasCooldown(attacker.getItemInHand().getType())) {
            return;
        }


        attacker.setCooldown(attacker.getItemInHand().getType(), itemsConfig.ketchupowaKusza.cooldown * 20);


        ketchupowaKuszaItem.useItem(attacker, target);
    }
}
