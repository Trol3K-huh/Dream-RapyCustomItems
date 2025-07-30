package cc.dreamcode.customitems.config;

import cc.dreamcode.menu.bukkit.BukkitMenuBuilder;
import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import cc.dreamcode.platform.persistence.StorageConfig;
import cc.dreamcode.utilities.builder.MapBuilder;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import eu.okaeri.configs.annotation.Header;
import org.bukkit.inventory.ItemStack;

@Configuration(child = "config.yml")
@Header("## Dream-RapyCustomItems (Main-Config) ##")
public class PluginConfig extends OkaeriConfig {

    @Comment
    @Comment("Debug pokazuje dodatkowe informacje do konsoli. Lepiej wylaczyc. :P")
    @CustomKey("debug")
    public boolean debug = true;

    @Comment
    @Comment("Ponizej znajduja sie dane do logowania bazy danych:")
    @CustomKey("storage-config")
    public StorageConfig storageConfig = new StorageConfig("dreamtemplate");

    @Comment
    @Comment("Konfiguracja menu RapyItems:")
    @CustomKey("rapyitems-menu")
    public BukkitMenuBuilder rapyItemsMenu = new BukkitMenuBuilder(
            "&dDreamCode-RapyItems",
            6,
            new MapBuilder<Integer, ItemStack>()

                    .build()
    );


}
