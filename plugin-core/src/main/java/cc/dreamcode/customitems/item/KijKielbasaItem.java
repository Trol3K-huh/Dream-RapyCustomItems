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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class KijKielbasaItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;

    public ItemStack createItem() {
        ItemStack kij = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.kijKielbasa.material).orElse(XMaterial.STICK).parseMaterial())
                .setName(itemsConfig.kijKielbasa.name)
                .setLore(itemsConfig.kijKielbasa.lore)
                .fixColors()
                .toItemStack();


        kij = NBTHelper.addNBTTag(kij, NBTHelper.DREAM_ITEM_ID, NBTHelper.KIJ_KIELBASA);


        kij.addUnsafeEnchantment(Enchantment.KNOCKBACK, itemsConfig.kijKielbasa.knockbackLevel);
        return kij;
    }

    public void useItem(Profile attackerProfile, Profile targetProfile) {
        Player attacker = Bukkit.getPlayer(attackerProfile.getUniqueId());
        Player target = Bukkit.getPlayer(targetProfile.getUniqueId());
        
        if (attacker == null || target == null) return;


        messageConfig.kijUsed.send(attacker);
    }

    public boolean isKijKielbasa(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.KIJ_KIELBASA);
    }
}
