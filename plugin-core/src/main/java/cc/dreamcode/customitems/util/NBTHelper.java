package cc.dreamcode.customitems.util;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;


public class NBTHelper {
    
    private static final String PLUGIN_NAME = "Dream-Rapycustomitems";
    

    public static ItemStack addNBTTag(ItemStack item, String key, String value) {
        if (item == null || !item.hasItemMeta()) {
            return item;
        }
        
        ItemMeta meta = item.getItemMeta();
        NamespacedKey namespacedKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin(PLUGIN_NAME), key);
        meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, value);
        item.setItemMeta(meta);
        
        return item;
    }
    

    public static String getNBTTag(ItemStack item, String key) {
        if (item == null || !item.hasItemMeta()) {
            return null;
        }
        
        NamespacedKey namespacedKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin(PLUGIN_NAME), key);
        return item.getItemMeta().getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING);
    }
    

    public static boolean hasNBTTag(ItemStack item, String key, String expectedValue) {
        String value = getNBTTag(item, key);
        return expectedValue != null && expectedValue.equals(value);
    }
    

    public static boolean hasNBTTag(ItemStack item, String key) {
        return getNBTTag(item, key) != null;
    }
    

    public static ItemStack removeNBTTag(ItemStack item, String key) {
        if (item == null || !item.hasItemMeta()) {
            return item;
        }
        
        ItemMeta meta = item.getItemMeta();
        NamespacedKey namespacedKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin(PLUGIN_NAME), key);
        meta.getPersistentDataContainer().remove(namespacedKey);
        item.setItemMeta(meta);
        
        return item;
    }
    

    public static final String DREAM_ITEM_ID = "dream_item_id";
    

    public static final String TRABKA_KIBICA = "trabka_kibica";
    public static final String LAPKA_KIBICA = "lapka_kibica";
    public static final String KOTWICZKA = "kotwiczka";
    public static final String KETCHUPOWA_KUSZA = "ketchupowa_kusza";
    public static final String PLECAK_KIBICA = "plecak_kibica";
    public static final String SZALIK_KIBICA = "szalik_kibica";
    public static final String TOPOR_KIBICA = "topor_kibica";
    public static final String PILKA_KIBICA = "pilka_kibica";
    public static final String GRANAT_KIBICA = "granat_kibica";
    public static final String KIJ_KIELBASA = "kij_kielbasa";
    public static final String NIESKONCZONA_FAJERWERKA = "nieskonczona_fajerwerka";
    public static final String NIESKONCZONE_KOX = "nieskonczone_kox";
    public static final String NIESKONCZONA_SILA = "nieskonczona_sila";
    public static final String NIESKONCZONE_USUWACZ = "nieskonczone_usuwacz";
}
