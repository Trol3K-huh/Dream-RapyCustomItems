package cc.dreamcode.customitems.manager.listener;

import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ProfileListener implements Listener {

    private final ProfileRepository profileRepository;

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());


        if (profile.isElytraBlocked() && event.isGliding()) {
            event.setCancelled(true);
            player.sendMessage("§c§lElytra jest zablokowana!");
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        if (event.getTo().getY() <= event.getFrom().getY()) {
            return;
        }
        
        Player player = event.getPlayer();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());
        

        if (profile.isJumpBlocked()) {

            event.getTo().setY(event.getFrom().getY());
            player.sendMessage("§c§lSkakanie jest zablokowane!");
        }
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {

        Player player = event.getPlayer();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());
        

        if (profile.isJumpBlocked() && event.isFlying()) {
            event.setCancelled(true);
            player.sendMessage("§c§lLatanie jest zablokowane!");
        }
    }
}
