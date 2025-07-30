package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.item.PilkaKibicaItem;
import cc.dreamcode.customitems.item.SetKibicaItem;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SetKibicaListener implements Listener {

    private final SetKibicaItem setKibicaItem;
    private final PilkaKibicaItem pilkaKibicaItem;
    private final Random random = new Random();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        

        if (killer == null) {
            return;
        }
        

        int dropBonus = setKibicaItem.calculateDropBonus(killer);
        
        if (dropBonus <= 0) {
            return;
        }
        

        if (random.nextInt(100) < dropBonus) {

            ItemStack pilka = pilkaKibicaItem.createItem();
            event.getDrops().add(pilka);
            
            killer.sendMessage("§f§lPiłka Kibica §7- bonus z setu! §e(+" + dropBonus + "% szans)");
        }
    }
}
