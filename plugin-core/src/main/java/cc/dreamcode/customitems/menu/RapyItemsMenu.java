package cc.dreamcode.customitems.menu;

import cc.dreamcode.customitems.item.*;
import cc.dreamcode.menu.bukkit.BukkitMenuBuilder;
import cc.dreamcode.menu.bukkit.base.BukkitMenu;
import cc.dreamcode.menu.bukkit.setup.BukkitMenuPlayerSetup;
import cc.dreamcode.notice.bukkit.BukkitNotice;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.config.PluginConfig;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class RapyItemsMenu implements BukkitMenuPlayerSetup {

    private final PluginConfig pluginConfig;
    private final MessageConfig messageConfig;
    private final TrabkaKibicaItem trabkaKibicaItem;
    private final LapkaKibicaItem lapkaKibicaItem;
    private final KotwiczkaItem kotwiczkaItem;
    private final KetchupowaKuszaItem ketchupowaKuszaItem;
    private final PlecakKibicaItem plecakKibicaItem;
    private final SzalikKibicaItem szalikKibicaItem;
    private final NieskonczoneItem nieskonczoneItem;
    private final ToporKibicaItem toporKibicaItem;
    private final PilkaKibicaItem pilkaKibicaItem;
    private final GranatKibicaItem granatKibicaItem;
    private final KijKielbasaItem kijKielbasaItem;
    private final SetKibicaItem setKibicaItem;
    private final ProfileRepository profileRepository;

    @Override
    public BukkitMenu build(@NonNull HumanEntity humanEntity) {
        Player player = (Player) humanEntity;

        final BukkitMenuBuilder menuBuilder = this.pluginConfig.rapyItemsMenu;
        final BukkitMenu bukkitMenu = menuBuilder.buildEmpty();


        setupAllItems(bukkitMenu);

        return bukkitMenu;
    }

    private void setupAllItems(BukkitMenu menu) {

        addDecorations(menu);


        int slot = 10;


        menu.setItem(slot++, trabkaKibicaItem.createItem(), event -> giveItem(event, trabkaKibicaItem.createItem(), messageConfig.trabkaAdded));
        menu.setItem(slot++, lapkaKibicaItem.createItem(), event -> giveItem(event, lapkaKibicaItem.createItem(), messageConfig.lapkaAdded));
        menu.setItem(slot++, kotwiczkaItem.createItem(), event -> giveItem(event, kotwiczkaItem.createItem(), messageConfig.kotwiczkaAdded));
        menu.setItem(slot++, ketchupowaKuszaItem.createItem(), event -> giveItem(event, ketchupowaKuszaItem.createItem(), messageConfig.kuszaAdded));
        menu.setItem(slot++, plecakKibicaItem.createItem(), event -> giveItem(event, plecakKibicaItem.createItem(), messageConfig.plecakAdded));
        menu.setItem(slot++, szalikKibicaItem.createItem(), event -> giveItem(event, szalikKibicaItem.createItem(), messageConfig.szalikAdded));
        menu.setItem(slot++, toporKibicaItem.createItem(), event -> giveItem(event, toporKibicaItem.createItem(), messageConfig.toporAdded));


        slot = 19;
        menu.setItem(slot++, pilkaKibicaItem.createItem(), event -> giveItem(event, pilkaKibicaItem.createItem(), messageConfig.pilkaAdded));
        menu.setItem(slot++, granatKibicaItem.createItem(), event -> giveItem(event, granatKibicaItem.createItem(), messageConfig.granatAdded));
        menu.setItem(slot++, kijKielbasaItem.createItem(), event -> giveItem(event, kijKielbasaItem.createItem(), messageConfig.kijAdded));


        slot = 28;
        menu.setItem(slot++, nieskonczoneItem.createFajerwerka(), event -> giveItem(event, nieskonczoneItem.createFajerwerka(), messageConfig.fajerwerkaAdded));
        menu.setItem(slot++, nieskonczoneItem.createKox(), event -> giveItem(event, nieskonczoneItem.createKox(), messageConfig.koxAdded));
        menu.setItem(slot++, nieskonczoneItem.createSila(), event -> giveItem(event, nieskonczoneItem.createSila(), messageConfig.silaAdded));
        menu.setItem(slot++, nieskonczoneItem.createUsuwacz(), event -> giveItem(event, nieskonczoneItem.createUsuwacz(), messageConfig.usuwaczAdded));


        slot = 37;
        menu.setItem(slot++, setKibicaItem.createHelmet1(), event -> giveSetItems(event, 1));
        menu.setItem(slot++, setKibicaItem.createHelmet2(), event -> giveSetItems(event, 2));
    }


    private void giveSetItems(InventoryClickEvent event, int setVersion) {
        Player player = (Player) event.getWhoClicked();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());

        Player profilePlayer = Bukkit.getPlayer(profile.getUniqueId());
        if (profilePlayer == null) return;

        if (profilePlayer.getInventory().firstEmpty() == -1) {
            messageConfig.noSpace.send(profilePlayer);
            return;
        }

        if (setVersion == 1) {
            profilePlayer.getInventory().addItem(setKibicaItem.createHelmet1());
            profilePlayer.getInventory().addItem(setKibicaItem.createChestplate1());
            profilePlayer.getInventory().addItem(setKibicaItem.createLeggings1());
            profilePlayer.getInventory().addItem(setKibicaItem.createBoots1());
            messageConfig.setAdded.with("version", "1.0").send(profilePlayer);
        } else if (setVersion == 2) {
            profilePlayer.getInventory().addItem(setKibicaItem.createHelmet2());
            profilePlayer.getInventory().addItem(setKibicaItem.createChestplate2());
            profilePlayer.getInventory().addItem(setKibicaItem.createLeggings2());
            profilePlayer.getInventory().addItem(setKibicaItem.createBoots2());
            messageConfig.setAdded.with("version", "2.0").send(profilePlayer);
        }

        profilePlayer.closeInventory();
    }





    private void giveItem(InventoryClickEvent event, ItemStack item, BukkitNotice message) {
        Player player = (Player) event.getWhoClicked();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());

        Player profilePlayer = Bukkit.getPlayer(profile.getUniqueId());
        if (profilePlayer == null) return;

        if (profilePlayer.getInventory().firstEmpty() == -1) {
            messageConfig.noSpace.send(profilePlayer);
            return;
        }

        profilePlayer.getInventory().addItem(item);
        message.send(profilePlayer);
        profilePlayer.closeInventory();
    }



    private void addDecorations(BukkitMenu menu) {

            ItemStack whiteGlass = new ItemBuilder(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial())
                .setName("")
                .toItemStack();

        ItemStack purpleGlass = new ItemBuilder(XMaterial.PURPLE_STAINED_GLASS_PANE.parseMaterial())
                .setName("")
                .toItemStack();




        menu.setItem(0, purpleGlass);
        menu.setItem(1, whiteGlass);
        menu.setItem(2, purpleGlass);
        menu.setItem(3, whiteGlass);
        menu.setItem(4, purpleGlass);
        menu.setItem(5, whiteGlass);
        menu.setItem(6, purpleGlass);
        menu.setItem(7, whiteGlass);
        menu.setItem(8, purpleGlass);
        menu.setItem(9, whiteGlass);
        menu.setItem(18, purpleGlass);
        menu.setItem(27, whiteGlass);
        menu.setItem(36, purpleGlass);
        menu.setItem(45, whiteGlass);
        menu.setItem(46, purpleGlass);
        menu.setItem(47, whiteGlass);
        menu.setItem(48, purpleGlass);
        menu.setItem(49, whiteGlass);
        menu.setItem(50, purpleGlass);
        menu.setItem(51, whiteGlass);
        menu.setItem(52, purpleGlass);
        menu.setItem(53, whiteGlass);
        menu.setItem(17, whiteGlass);
        menu.setItem(26, purpleGlass);
        menu.setItem(35, whiteGlass);
        menu.setItem(44, purpleGlass);


    }

    public void openMenu(Player player) {
        BukkitMenu menu = build(player);
        menu.open(player);
    }
}
