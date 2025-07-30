package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.item.NieskonczoneItem;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class NieskonczoneListener implements Listener {

    private final NieskonczoneItem nieskonczoneItem;
    private final ProfileRepository profileRepository;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemStack item = event.getItem();
        if (item == null) return;

        Profile profile = profileRepository.findOrCreate(event.getPlayer().getUniqueId(), event.getPlayer().getName());


        if (nieskonczoneItem.isSila(item)) {
            event.setCancelled(true);
            nieskonczoneItem.useSila(profile);
        }

        else if (nieskonczoneItem.isUsuwacz(item)) {
            event.setCancelled(true);
            nieskonczoneItem.useUsuwacz(profile);
        }

    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();


        if (nieskonczoneItem.isKox(item)) {
            event.setCancelled(true);


            if (player.hasCooldown(item.getType())) {
                return;
            }


            player.setCooldown(item.getType(), 100);


            nieskonczoneItem.useKox(profileRepository.findOrCreate(player.getUniqueId(), player.getName()));

        } else if (nieskonczoneItem.isSila(item)) {
            event.setCancelled(true);


            if (player.hasCooldown(item.getType())) {
                return;
            }


            player.setCooldown(item.getType(), 200);


            nieskonczoneItem.useSila(profileRepository.findOrCreate(player.getUniqueId(), player.getName()));
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Player player = event.getPlayer();


        if (nieskonczoneItem.isFajerwerka(item)) {

            if (player.hasCooldown(item.getType())) {
                event.setCancelled(true);
                return;
            }


            player.setCooldown(item.getType(), 60);


            org.bukkit.Bukkit.getScheduler().runTaskLater(
                org.bukkit.Bukkit.getPluginManager().getPlugin("Dream-Template"),
                () -> {
                    if (player.getInventory().getItemInMainHand().getAmount() == 0) {
                        player.getInventory().setItemInMainHand(nieskonczoneItem.createFajerwerka());
                    }
                }, 1L);
        }
    }

    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Player player = event.getPlayer();


        if (nieskonczoneItem.isUsuwacz(item)) {

            if (player.hasCooldown(item.getType())) {
                return;
            }


            player.setCooldown(item.getType(), 20);


            org.bukkit.Bukkit.getScheduler().runTaskLater(
                org.bukkit.Bukkit.getPluginManager().getPlugin("Dream-Template"),
                () -> {
                    ItemStack currentItem = player.getInventory().getItemInMainHand();
                    if (nieskonczoneItem.isUsuwacz(currentItem)) {

                        currentItem.setDurability((short) 0);
                    }
                }, 1L);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Profile profile = profileRepository.findOrCreate(event.getPlayer().getUniqueId(), event.getPlayer().getName());


        if (nieskonczoneItem.hasSilaInInventory(event.getPlayer())) {
            nieskonczoneItem.useSila(profile);
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Profile profile = profileRepository.findOrCreate(event.getPlayer().getUniqueId(), event.getPlayer().getName());


        if (nieskonczoneItem.hasSilaInInventory(event.getPlayer())) {

            new org.bukkit.scheduler.BukkitRunnable() {
                @Override
                public void run() {
                    nieskonczoneItem.useSila(profile);
                }
            }.runTaskLater(org.bukkit.Bukkit.getPluginManager().getPlugin("Dream-Template"), 20L);
        }
    }
}
