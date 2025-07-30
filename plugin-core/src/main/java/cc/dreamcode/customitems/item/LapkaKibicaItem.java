package cc.dreamcode.customitems.item;

import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.util.NBTHelper;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class LapkaKibicaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.lapkaKibica.material).orElse(XMaterial.STICK).parseMaterial())
                .setName(itemsConfig.lapkaKibica.name)
                .setLore(itemsConfig.lapkaKibica.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.LAPKA_KIBICA);

        return item;
    }

    public void useItem(Profile attackerProfile, Profile targetProfile) {

        int duration = itemsConfig.lapkaKibica.effectDuration * 20;


        Player attacker = Bukkit.getPlayer(attackerProfile.getUniqueId());
        Player target = Bukkit.getPlayer(targetProfile.getUniqueId());

        if (attacker == null || target == null) {
            return;
        }


        target.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, 1));
        target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 1));


        messageConfig.lapkaTarget.send(target);
        messageConfig.lapkaUsed.with("target", target.getName()).send(attacker);
    }

    public boolean isLapkaKibica(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.LAPKA_KIBICA);
    }
}
