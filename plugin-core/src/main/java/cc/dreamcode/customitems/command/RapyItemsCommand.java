package cc.dreamcode.customitems.command;

import cc.dreamcode.command.CommandBase;
import cc.dreamcode.command.annotation.Async;
import cc.dreamcode.command.annotation.Command;
import cc.dreamcode.command.annotation.Executor;
import cc.dreamcode.command.annotation.Permission;
import cc.dreamcode.command.annotation.Completion;
import cc.dreamcode.command.annotation.Arg;
import cc.dreamcode.command.bukkit.BukkitSender;
import cc.dreamcode.customitems.item.*;
import cc.dreamcode.notice.bukkit.BukkitNotice;
import cc.dreamcode.customitems.config.ItemsConfig;
import cc.dreamcode.customitems.config.MessageConfig;
import cc.dreamcode.customitems.config.PluginConfig;
import cc.dreamcode.customitems.menu.RapyItemsMenu;
import cc.dreamcode.customitems.profile.Profile;
import cc.dreamcode.customitems.profile.ProfileRepository;
import cc.dreamcode.utilities.TimeUtil;
import eu.okaeri.configs.exception.OkaeriException;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@Command(name = "rapyitems")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class RapyItemsCommand implements CommandBase {

    private final PluginConfig pluginConfig;
    private final MessageConfig messageConfig;
    private final ItemsConfig itemsConfig;
    private final RapyItemsMenu rapyItemsMenu;
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

    @Async
    @Permission("rapyitems.reload")
    @Executor(path = "reload", description = "Przeladowuje konfiguracje.")
    BukkitNotice reload() {
        final long time = System.currentTimeMillis();

        try {
            this.messageConfig.load();
            this.pluginConfig.load();
            this.itemsConfig.load();

            return this.messageConfig.reloaded
                    .with("time", TimeUtil.format(System.currentTimeMillis() - time));
        }
        catch (NullPointerException | OkaeriException e) {
            e.printStackTrace();

            return this.messageConfig.reloadError
                    .with("error", e.getMessage());
        }
    }

    @Permission("rapyitems.edit")
    @Executor(path = "edit", description = "Otwiera gui przedmitów.")
    void edit(BukkitSender sender) {
        if (!(sender.getHandler() instanceof Player)) {
            this.messageConfig.notPlayer.send(sender.getHandler());
            return;
        }

        Player player = (Player) sender.getHandler();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());
        this.rapyItemsMenu.openMenu(player);
    }

    @Permission("rapyitems.item")
    @Completion(arg = "item", value = {"trabka", "lapka", "kotwiczka", "kusza", "plecak", "szalik", "fajerwerka", "kox", "sila", "usuwacz", "topor", "pilka", "granat", "kij", "set1", "set2"})
    @Executor(path = "item", description = "Daje custom przedmiot.")
    void item(BukkitSender sender, @Arg String item) {
        if (!(sender.getHandler() instanceof Player)) {
            this.messageConfig.notPlayer.send(sender.getHandler());
            return;
        }

        Player player = (Player) sender.getHandler();
        Profile profile = profileRepository.findOrCreate(player.getUniqueId(), player.getName());

        if (player.getInventory().firstEmpty() == -1) {
            messageConfig.noSpace.send(player);
            return;
        }

        switch (item.toLowerCase()) {
            case "trabka":
                player.getInventory().addItem(trabkaKibicaItem.createItem());
                messageConfig.trabkaAdded.send(player);
                break;
            case "lapka":
                player.getInventory().addItem(lapkaKibicaItem.createItem());
                messageConfig.lapkaAdded.send(player);
                break;
            case "kotwiczka":
                player.getInventory().addItem(kotwiczkaItem.createItem());
                messageConfig.kotwiczkaAdded.send(player);
                break;
            case "kusza":
                player.getInventory().addItem(ketchupowaKuszaItem.createItem());
                messageConfig.kuszaAdded.send(player);
                break;
            case "plecak":
                player.getInventory().addItem(plecakKibicaItem.createItem());
                messageConfig.plecakAdded.send(player);
                break;
            case "szalik":
                player.getInventory().addItem(szalikKibicaItem.createItem());
                messageConfig.szalikAdded.send(player);
                break;
            case "fajerwerka":
                player.getInventory().addItem(nieskonczoneItem.createFajerwerka());
                messageConfig.fajerwerkaAdded.send(player);
                break;
            case "kox":
                player.getInventory().addItem(nieskonczoneItem.createKox());
                messageConfig.koxAdded.send(player);
                break;
            case "sila":
                player.getInventory().addItem(nieskonczoneItem.createSila());
                messageConfig.silaAdded.send(player);
                break;
            case "usuwacz":
                player.getInventory().addItem(nieskonczoneItem.createUsuwacz());
                messageConfig.usuwaczAdded.send(player);
                break;
            case "topor":
                player.getInventory().addItem(toporKibicaItem.createItem());
                messageConfig.toporAdded.send(player);
                break;

            case "pilka":
                player.getInventory().addItem(pilkaKibicaItem.createItem());
                messageConfig.pilkaAdded.send(player);
                break;
            case "granat":
                player.getInventory().addItem(granatKibicaItem.createItem());
                messageConfig.granatAdded.send(player);
                break;
            case "kij":
                player.getInventory().addItem(kijKielbasaItem.createItem());
                messageConfig.kijAdded.send(player);
                break;
            case "set1":
                player.getInventory().addItem(setKibicaItem.createHelmet1());
                player.getInventory().addItem(setKibicaItem.createChestplate1());
                player.getInventory().addItem(setKibicaItem.createLeggings1());
                player.getInventory().addItem(setKibicaItem.createBoots1());
                messageConfig.setAdded.with("version", "1.0").send(player);
                break;
            case "set2":
                player.getInventory().addItem(setKibicaItem.createHelmet2());
                player.getInventory().addItem(setKibicaItem.createChestplate2());
                player.getInventory().addItem(setKibicaItem.createLeggings2());
                player.getInventory().addItem(setKibicaItem.createBoots2());
                messageConfig.setAdded.with("version", "2.0").send(player);
                break;

            default:
                messageConfig.unknownItem.send(player);
                break;
        }
    }


}
