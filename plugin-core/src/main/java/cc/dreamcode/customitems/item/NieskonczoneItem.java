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
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class NieskonczoneItem {

    private final ItemsConfig itemsConfig;
    private final MessageConfig messageConfig;


    public ItemStack createFajerwerka() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.nieskonczonaFajerwerka.material).orElse(XMaterial.FIREWORK_ROCKET).parseMaterial())
                .setName(itemsConfig.nieskonczonaFajerwerka.name)
                .setLore(itemsConfig.nieskonczonaFajerwerka.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONA_FAJERWERKA);

        return item;
    }


    public ItemStack createKox() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.nieskonczoneKox.material).orElse(XMaterial.GOLDEN_APPLE).parseMaterial())
                .setName(itemsConfig.nieskonczoneKox.name)
                .setLore(itemsConfig.nieskonczoneKox.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONE_KOX);

        return item;
    }


    public ItemStack createSila() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.nieskonczonaSila.material).orElse(XMaterial.POTION).parseMaterial())
                .setName(itemsConfig.nieskonczonaSila.name)
                .setLore(itemsConfig.nieskonczonaSila.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONA_SILA);

        return item;
    }


    public ItemStack createUsuwacz() {
        ItemStack item = new ItemBuilder(XMaterial.matchXMaterial(itemsConfig.nieskonczoneUsuwacz.material).orElse(XMaterial.SHEARS).parseMaterial())
                .setName(itemsConfig.nieskonczoneUsuwacz.name)
                .setLore(itemsConfig.nieskonczoneUsuwacz.lore)
                .fixColors()
                .toItemStack();


        item = NBTHelper.addNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONE_USUWACZ);

        return item;
    }


    public boolean isFajerwerka(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONA_FAJERWERKA);
    }

    public boolean isKox(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONE_KOX);
    }

    public boolean isSila(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONA_SILA);
    }

    public boolean isUsuwacz(ItemStack item) {
        return NBTHelper.hasNBTTag(item, NBTHelper.DREAM_ITEM_ID, NBTHelper.NIESKONCZONE_USUWACZ);
    }


    public void useSila(Profile profile) {
        Player player = Bukkit.getPlayer(profile.getUniqueId());
        if (player == null) return;


        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
    }

    public void useKox(Profile profile) {
        Player player = Bukkit.getPlayer(profile.getUniqueId());
        if (player == null) return;


        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));


        player.setFoodLevel(Math.min(player.getFoodLevel() + 4, 20));
        player.setSaturation(Math.min(player.getSaturation() + 9.6f, 20f));
    }

    public void useUsuwacz(Profile profile) {
        Player player = Bukkit.getPlayer(profile.getUniqueId());
        if (player == null) return;

        Location playerLoc = player.getLocation();
        

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Location checkLoc = playerLoc.clone().add(x, y, z);
                    if (checkLoc.getBlock().getType() == XMaterial.COBWEB.parseMaterial()) {
                        checkLoc.getBlock().setType(XMaterial.AIR.parseMaterial());
                    }
                }
            }
        }
        
        messageConfig.usuwaczUsed.send(player);
    }


    public boolean hasSilaInInventory(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (isSila(item)) {
                return true;
            }
        }
        return false;
    }

}
