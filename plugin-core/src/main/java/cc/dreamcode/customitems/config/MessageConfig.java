package cc.dreamcode.customitems.config;

import cc.dreamcode.notice.bukkit.BukkitNotice;
import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.Headers;

@Configuration(child = "message.yml")
@Headers({
        @Header("##Dream-RapyCustomItems (Message-Config) ##"),
        @Header("Dostepne type: (DO_NOT_SEND, CHAT, ACTION_BAR, SUBTITLE, TITLE, TITLE_SUBTITLE)")
})
public class MessageConfig extends OkaeriConfig {

    @CustomKey("command-usage")
    public BukkitNotice usage = BukkitNotice.chat("&7Przyklady uzycia komendy: &c{label}");
    @CustomKey("command-usage-help")
    public BukkitNotice usagePath = BukkitNotice.chat("&f{usage} &8- &7{description}");

    @CustomKey("command-usage-not-found")
    public BukkitNotice usageNotFound = BukkitNotice.chat("&cNie znaleziono pasujacych do kryteriow komendy.");
    @CustomKey("command-path-not-found")
    public BukkitNotice pathNotFound = BukkitNotice.chat("&cTa komenda jest pusta lub nie posiadasz dostepu do niej.");
    @CustomKey("command-no-permission")
    public BukkitNotice noPermission = BukkitNotice.chat("&cNie posiadasz uprawnien.");
    @CustomKey("command-not-player")
    public BukkitNotice notPlayer = BukkitNotice.chat("&cTa komende mozna tylko wykonac z poziomu gracza.");
    @CustomKey("command-not-console")
    public BukkitNotice notConsole = BukkitNotice.chat("&cTa komende mozna tylko wykonac z poziomu konsoli.");
    @CustomKey("command-invalid-format")
    public BukkitNotice invalidFormat = BukkitNotice.chat("&cPodano nieprawidlowy format argumentu komendy. ({input})");

    @CustomKey("player-not-found")
    public BukkitNotice playerNotFound = BukkitNotice.chat("&cPodanego gracza nie znaleziono.");
    @CustomKey("world-not-found")
    public BukkitNotice worldNotFound = BukkitNotice.chat("&cPodanego swiata nie znaleziono.");

    @CustomKey("config-reloaded")
    public BukkitNotice reloaded = BukkitNotice.chat("&aPrzeladowano! &7({time})");
    @CustomKey("config-reload-error")
    public BukkitNotice reloadError = BukkitNotice.chat("&cZnaleziono problem w konfiguracji: &6{error}");




    @CustomKey("no-space")
    public BukkitNotice noSpace = BukkitNotice.chat("&c&lBrak miejsca! &7Zwolnij miejsce w ekwipunku.");

    @CustomKey("trabka-added")
    public BukkitNotice trabkaAdded = BukkitNotice.chat("&e&lTrabka Kibica &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("trabka-used")
    public BukkitNotice trabkaUsed = BukkitNotice.chat("&e&lTrabka Kibica &7zostala uzyta! Gracze w poblizu otrzymali efekty!");

    @CustomKey("trabka-nearby")
    public BukkitNotice trabkaNearby = BukkitNotice.chat("&e&lTrabka Kibica &7zostala uzyta w poblizu! Otrzymujesz efekty!");

    @CustomKey("lapka-added")
    public BukkitNotice lapkaAdded = BukkitNotice.chat("&c&lLapka Kibica &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("lapka-used")
    public BukkitNotice lapkaUsed = BukkitNotice.chat("&c&lLapka Kibica &7zostala uzyta na graczu &e{target}&7!");

    @CustomKey("lapka-target")
    public BukkitNotice lapkaTarget = BukkitNotice.chat("&c&lLapka Kibica &7zostala uzyta na Tobie! Otrzymujesz efekty!");

    @CustomKey("kotwiczka-added")
    public BukkitNotice kotwiczkaAdded = BukkitNotice.chat("&b&lKotwiczka &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("kotwiczka-used")
    public BukkitNotice kotwiczkaUsed = BukkitNotice.chat("&b&lKotwiczka &7zostala uzyta! Przyciaganie...");

    @CustomKey("kusza-added")
    public BukkitNotice kuszaAdded = BukkitNotice.chat("&4&lKeczupowa Kusza &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("kusza-pull-success")
    public BukkitNotice kuszaPullSuccess = BukkitNotice.chat("&4&lKeczupowa Kusza &7- teleportuje &e{target}&7!");

    @CustomKey("kusza-pull-target")
    public BukkitNotice kuszaPullTarget = BukkitNotice.chat("&4&lKeczupowa Kusza &7- &e{attacker} &7cie teleportuje!");

    @CustomKey("kusza-pull-failed")
    public BukkitNotice kuszaPullFailed = BukkitNotice.chat("&4&lKeczupowa Kusza &7- tym razem sie nie udalo!");


    @CustomKey("plecak-added")
    public BukkitNotice plecakAdded = BukkitNotice.chat("&6&lPlecak Kibica &7zostal dodany do Twojego ekwipunku!");

    @CustomKey("plecak-collected")
    public BukkitNotice plecakCollected = BukkitNotice.chat("&6&lPlecak Kibica &7- przedmioty zostaly zebrane!");

    @CustomKey("szalik-added")
    public BukkitNotice szalikAdded = BukkitNotice.chat("&e&lSzalik Kibica &7zostal dodany do Twojego ekwipunku!");

    @CustomKey("fajerwerka-added")
    public BukkitNotice fajerwerkaAdded = BukkitNotice.chat("&d&lNieskonczona Fajerwerka &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("kox-added")
    public BukkitNotice koxAdded = BukkitNotice.chat("&a&lNieskonczone Kox &7zostalo dodane do Twojego ekwipunku!");

    @CustomKey("sila-added")
    public BukkitNotice silaAdded = BukkitNotice.chat("&4&lNieskonczona Sila I &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("usuwacz-added")
    public BukkitNotice usuwaczAdded = BukkitNotice.chat("&7&lNieskonczone Usuwacz Pajeczyn &7zostal dodany do Twojego ekwipunku!");

    @CustomKey("usuwacz-used")
    public BukkitNotice usuwaczUsed = BukkitNotice.chat("&7&lUsuwacz Pajeczyn &7- pajeczyny zostaly usuniete!");


    @CustomKey("topor-added")
    public BukkitNotice toporAdded = BukkitNotice.chat("&c&lTopor Kibica &7zostal dodany do Twojego ekwipunku!");

    @CustomKey("topor-used")
    public BukkitNotice toporUsed = BukkitNotice.chat("&c&lTopor Kibica &7- &e{target} &7zostal spowolniony!");

    @CustomKey("topor-target")
    public BukkitNotice toporTarget = BukkitNotice.chat("&c&lTopor Kibica &7- zostales spowolniony przez &e{attacker}&7!");

    @CustomKey("pilka-added")
    public BukkitNotice pilkaAdded = BukkitNotice.chat("&f&lPilka Kibica &7zostala dodana do Twojego ekwipunku!");

    @CustomKey("pilka-used")
    public BukkitNotice pilkaUsed = BukkitNotice.chat("&f&lPilka Kibica &7- &e{target} &7zostal trafiony!");

    @CustomKey("pilka-target")
    public BukkitNotice pilkaTarget = BukkitNotice.chat("&f&lPilka Kibica &7- zostales trafiony przez &e{attacker}&7!");

    @CustomKey("granat-added")
    public BukkitNotice granatAdded = BukkitNotice.chat("&a&lGranat Kibica &7zostal dodany do Twojego ekwipunku!");

    @CustomKey("granat-used")
    public BukkitNotice granatUsed = BukkitNotice.chat("&a&lGranat Kibica &7zostal rzucony! Wybuch za 3 sekundy!");

    @CustomKey("granat-exploded")
    public BukkitNotice granatExploded = BukkitNotice.chat("&a&lGranat Kibica &7eksplodowal! Gracze w poblizu otrzymali efekty!");

    @CustomKey("kij-added")
    public BukkitNotice kijAdded = BukkitNotice.chat("&6&lKij z Kielbasa &7zostal dodany do Twojego ekwipunku!");

    @CustomKey("kij-used")
    public BukkitNotice kijUsed = BukkitNotice.chat("&6&lKij z Kielbasa &7- potezny odrzut!");

    @CustomKey("set-added")
    public BukkitNotice setAdded = BukkitNotice.chat("&e&lSet Kibica {version} &7zostal dodany do Twojego ekwipunku!");


    @CustomKey("cooldown-active")
    public BukkitNotice cooldownActive = BukkitNotice.chat("&c&lCooldown! &7Musisz poczekac jeszcze &e{time} &7sekund.");


    @CustomKey("kox-used")
    public BukkitNotice koxUsed = BukkitNotice.chat("&a&lNieskonczone Kox &7- otrzymujesz efekty regeneracji i absorpcji!");

    @CustomKey("sila-used")
    public BukkitNotice silaUsed = BukkitNotice.chat("&4&lNieskonczona Sila I &7- otrzymujesz nieskonczona sile!");

    @CustomKey("fajerwerka-used")
    public BukkitNotice fajerwerkaUsed = BukkitNotice.chat("&d&lNieskonczona Fajerwerka &7zostala uzyta!");


    @CustomKey("unknown-item")
    public BukkitNotice unknownItem = BukkitNotice.chat("&c&lNieznany przedmiot! &7Dostepne: trabka, lapka, kotwiczka, kusza, plecak, szalik, fajerwerka, kox, sila, usuwacz, topor, pilka, granat, kij, set1, set2");

}
