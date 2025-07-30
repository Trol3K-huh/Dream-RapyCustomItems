package cc.dreamcode.customitems;

import cc.dreamcode.command.bukkit.BukkitCommandProvider;
import cc.dreamcode.customitems.item.*;
import cc.dreamcode.customitems.manager.listener.*;
import cc.dreamcode.menu.bukkit.BukkitMenuProvider;
import cc.dreamcode.menu.serializer.MenuBuilderSerializer;
import cc.dreamcode.notice.serializer.BukkitNoticeSerializer;
import cc.dreamcode.platform.DreamVersion;
import cc.dreamcode.platform.bukkit.DreamBukkitConfig;
import cc.dreamcode.platform.bukkit.DreamBukkitPlatform;
import cc.dreamcode.platform.bukkit.component.ConfigurationResolver;
import cc.dreamcode.platform.bukkit.serializer.ItemMetaSerializer;
import cc.dreamcode.platform.bukkit.serializer.ItemStackSerializer;
import cc.dreamcode.platform.component.ComponentService;
import cc.dreamcode.platform.other.component.DreamCommandExtension;
import cc.dreamcode.platform.persistence.DreamPersistence;
import cc.dreamcode.platform.persistence.component.DocumentPersistenceResolver;
import cc.dreamcode.platform.persistence.component.DocumentRepositoryResolver;
import cc.dreamcode.customitems.command.RapyItemsCommand;
import cc.dreamcode.customitems.menu.RapyItemsMenu;
import cc.dreamcode.customitems.command.handler.InvalidInputHandlerImpl;
import cc.dreamcode.customitems.command.handler.InvalidPermissionHandlerImpl;
import cc.dreamcode.customitems.command.handler.InvalidSenderHandlerImpl;
import cc.dreamcode.customitems.command.handler.InvalidUsageHandlerImpl;
import cc.dreamcode.customitems.command.result.BukkitNoticeResolver;
import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.config.PluginConfig;


import cc.dreamcode.customitems.profile.ProfileRepository;
import cc.dreamcode.utilities.adventure.AdventureProcessor;
import cc.dreamcode.utilities.adventure.AdventureUtil;
import cc.dreamcode.utilities.bukkit.StringColorUtil;
import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import eu.okaeri.persistence.document.DocumentPersistence;
import eu.okaeri.tasker.bukkit.BukkitTasker;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class TemplatePlugin extends DreamBukkitPlatform implements DreamBukkitConfig, DreamPersistence {

    @Getter private static TemplatePlugin instance;

    @Override
    public void load(@NonNull ComponentService componentService) {
        instance = this;

        AdventureUtil.setRgbSupport(true);
        StringColorUtil.setColorProcessor(new AdventureProcessor());
    }

    @Override
    public void enable(@NonNull ComponentService componentService) {
        componentService.setDebug(false);

        this.registerInjectable(BukkitTasker.newPool(this));
        this.registerInjectable(BukkitMenuProvider.create(this));

        this.registerInjectable(BukkitCommandProvider.create(this));
        componentService.registerExtension(DreamCommandExtension.class);


        componentService.registerResolver(ConfigurationResolver.class);
        componentService.registerComponent(MessageConfig.class);

        componentService.registerComponent(BukkitNoticeResolver.class);
        componentService.registerComponent(InvalidInputHandlerImpl.class);
        componentService.registerComponent(InvalidPermissionHandlerImpl.class);
        componentService.registerComponent(InvalidSenderHandlerImpl.class);
        componentService.registerComponent(InvalidUsageHandlerImpl.class);

        componentService.registerComponent(PluginConfig.class, pluginConfig -> {

            this.registerInjectable(pluginConfig.storageConfig);

            componentService.registerResolver(DocumentPersistenceResolver.class);
            componentService.registerComponent(DocumentPersistence.class);
            componentService.registerResolver(DocumentRepositoryResolver.class);


            componentService.setDebug(pluginConfig.debug);
        });

        componentService.registerComponent(ItemsConfig.class);
        componentService.registerComponent(ProfileRepository.class);


        componentService.registerComponent(TrabkaKibicaItem.class);
        componentService.registerComponent(LapkaKibicaItem.class);
        componentService.registerComponent(KotwiczkaItem.class);
        componentService.registerComponent(KetchupowaKuszaItem.class);
        componentService.registerComponent(PlecakKibicaItem.class);
        componentService.registerComponent(SzalikKibicaItem.class);
        componentService.registerComponent(NieskonczoneItem.class);
        componentService.registerComponent(ToporKibicaItem.class);
        componentService.registerComponent(PilkaKibicaItem.class);
        componentService.registerComponent(GranatKibicaItem.class);
        componentService.registerComponent(KijKielbasaItem.class);
        componentService.registerComponent(SetKibicaItem.class);


        componentService.registerComponent(RapyItemsMenu.class);


        componentService.registerComponent(TrabkaKibicaListener.class);
        componentService.registerComponent(LapkaKibicaListener.class);
        componentService.registerComponent(KotwiczkaListener.class);
        componentService.registerComponent(KetchupowaKuszaListener.class);
        componentService.registerComponent(PlecakKibicaListener.class);
        componentService.registerComponent(SzalikKibicaListener.class);
        componentService.registerComponent(NieskonczoneListener.class);
        componentService.registerComponent(ToporKibicaListener.class);
        componentService.registerComponent(PilkaKibicaListener.class);
        componentService.registerComponent(GranatKibicaListener.class);
        componentService.registerComponent(KijKielbasaListener.class);
        componentService.registerComponent(SetKibicaListener.class);
        componentService.registerComponent(ProfileListener.class);


        componentService.registerComponent(RapyItemsCommand.class);


    }

    @Override
    public void disable() {

    }

    @Override
    public @NonNull DreamVersion getDreamVersion() {
        return DreamVersion.create("Dream-RapyCustomItems", "1.0-InDEV", "author");
    }

    @Override
    public @NonNull OkaeriSerdesPack getConfigSerdesPack() {
        return registry -> {
            registry.register(new BukkitNoticeSerializer());
            registry.register(new MenuBuilderSerializer());
        };
    }

    @Override
    public @NonNull OkaeriSerdesPack getPersistenceSerdesPack() {
        return registry -> {
            registry.register(new SerdesBukkit());

            registry.registerExclusive(ItemStack.class, new ItemStackSerializer());
            registry.registerExclusive(ItemMeta.class, new ItemMetaSerializer());
        };
    }

}
