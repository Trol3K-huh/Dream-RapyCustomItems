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

import java.util.ArrayList;
import java.util.List;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ToporKibicaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;

    public ItemStack createItem() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.toporKibica.material).orElse(XMaterial.DIAMOND_AXE).parseMaterial())
                .setName(itemsConfig.toporKibica.name)
                .setLore(itemsConfig.toporKibica.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.TOPOR_KIBICA);

        return item;
    }

    public void useItem(Profile attackerProfile, Profile targetProfile) {
        Player attacker = Bukkit.getPlayer(attackerProfile.getUniqueId());
        Player target = Bukkit.getPlayer(targetProfile.getUniqueId());
        
        if (attacker == null || target == null) return;

        int duration = itemsConfig.toporKibica.effectDuration * 20;
        

        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, 3));
        

        targetProfile.setElytraBlocked(System.currentTimeMillis() + (itemsConfig.toporKibica.effectDuration * 1000L));
        
        messageConfig.toporUsed.with("target", target.getName()).send(attacker);
    }

    public boolean isToporKibica(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.TOPOR_KIBICA);
    }
}
