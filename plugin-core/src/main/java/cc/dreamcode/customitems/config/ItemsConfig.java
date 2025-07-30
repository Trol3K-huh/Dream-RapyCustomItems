package cc.dreamcode.customitems.config;

import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import eu.okaeri.configs.annotation.Header;

import java.util.Arrays;
import java.util.List;

@Configuration(
        child = "items.yml"
)
@Header("## Dream-RapyCustomItems  ##")
@Header("## Items Configuration ##")
public class ItemsConfig extends OkaeriConfig {

    @Comment
    @Comment("Konfiguracja Trabki Kibica:")
    @CustomKey("trabka-kibica")
    public TrabkaKibicaConfig trabkaKibica = new TrabkaKibicaConfig();

    @Comment
    @Comment("Konfiguracja Lapki Kibica:")
    @CustomKey("lapka-kibica")
    public LapkaKibicaConfig lapkaKibica = new LapkaKibicaConfig();

    @Comment
    @Comment("Konfiguracja Kotwiczki:")
    @CustomKey("kotwiczka")
    public KotwiczkaConfig kotwiczka = new KotwiczkaConfig();

    @Comment
    @Comment("Konfiguracja Ketczupowej Kuszy:")
    @CustomKey("ketchupowa-kusza")
    public KetchupowaKuszaConfig ketchupowaKusza = new KetchupowaKuszaConfig();

    @Comment
    @Comment("Konfiguracja Plecaka Kibica:")
    @CustomKey("plecak-kibica")
    public PlecakKibicaConfig plecakKibica = new PlecakKibicaConfig();

    @Comment
    @Comment("Konfiguracja Szalika Kibica:")
    @CustomKey("szalik-kibica")
    public SzalikKibicaConfig szalikKibica = new SzalikKibicaConfig();

    @Comment
    @Comment("Konfiguracja Nieskonczonej Fajerwerki:")
    @CustomKey("nieskonczona-fajerwerka")
    public NieskonczoneConfig nieskonczonaFajerwerka = new NieskonczoneConfig("&x&C&6&D&6&D&2ɴ&x&C&8&C&E&C&Cɪ&x&C&B&C&5&C&6ᴇ&x&C&D&B&D&B&Fѕ&x&D&0&B&4&B&9ᴢ&x&D&2&A&C&B&3ᴋ&x&D&4&A&3&A&Dᴏ&x&D&7&9&B&A&7ɴ&x&D&9&9&2&A&0ᴄ&x&D&C&8&A&9&Aᴢ&x&D&E&8&2&9&4ᴏ&x&E&0&7&9&8&Eɴ&x&E&3&7&1&8&8ᴀ &x&E&8&6&0&7&Bꜰ&x&E&A&5&7&7&5ᴀ&x&E&C&4&F&6&Fᴊ&x&E&F&4&6&6&9ᴇ&x&F&1&3&E&6&2ʀ&x&F&4&3&5&5&Cᴡ&x&F&6&2&D&5&6ᴇ&x&F&6&2&D&5&6ʀ&x&F&6&2&D&5&6ᴋ&x&F&6&2&D&5&6ᴀ", "FIREWORK_ROCKET", 1006);

    @Comment
    @Comment("Konfiguracja Nieskonczonego Koxa:")
    @CustomKey("nieskonczone-kox")
    public NieskonczoneConfig nieskonczoneKox = new NieskonczoneConfig("&x&C&6&D&6&D&2ɴ&x&C&9&C&A&C&9ɪ&x&C&D&B&E&C&0ᴇ&x&D&0&B&2&B&7ѕ&x&D&4&A&6&A&Fᴢ&x&D&7&9&A&A&6ᴋ&x&D&B&8&E&9&Dᴏ&x&D&E&8&2&9&4ɴ&x&E&1&7&5&8&Bᴄ&x&E&5&6&9&8&2ᴢ&x&E&8&5&D&7&9ᴏ&x&E&C&5&1&7&1ɴ&x&E&F&4&5&6&8ᴀ &x&F&6&2&D&5&6ᴋ&x&F&6&2&D&5&6ᴏ&x&F&6&2&D&5&6х", "GOLDEN_APPLE", 1007);

    @Comment
    @Comment("Konfiguracja Nieskonczonej Sily:")
    @CustomKey("nieskonczona-sila")
    public NieskonczoneConfig nieskonczonaSila = new NieskonczoneConfig("&x&C&6&D&6&D&2ɴ&x&C&9&C&A&C&9ɪ&x&C&D&B&E&C&0ᴇ&x&D&0&B&2&B&7ѕ&x&D&4&A&6&A&Fᴢ&x&D&7&9&A&A&6ᴋ&x&D&B&8&E&9&Dᴏ&x&D&E&8&2&9&4ɴ&x&E&1&7&5&8&Bᴄ&x&E&5&6&9&8&2ᴢ&x&E&8&5&D&7&9ᴏ&x&E&C&5&1&7&1ɴ&x&E&F&4&5&6&8ᴀ &x&F&6&2&D&5&6ѕ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ʟ&x&F&6&2&D&5&6ᴀ I", "POTION", 1008);

    @Comment
    @Comment("Konfiguracja Nieskonczonego Usuwacza Pajeczyn:")
    @CustomKey("nieskonczone-usuwacz")
    public NieskonczoneConfig nieskonczoneUsuwacz = new NieskonczoneConfig("&x&C&6&D&6&D&2ɴ&x&C&8&C&F&C&Dɪ&x&C&A&C&8&C&8ᴇ&x&C&C&C&2&C&3ѕ&x&C&E&B&B&B&Eᴢ&x&D&0&B&4&B&9ᴋ&x&D&2&A&D&B&4ᴏ&x&D&3&A&7&A&Fɴ&x&D&5&A&0&A&Aᴄ&x&D&7&9&9&A&5ᴢ&x&D&9&9&2&A&0ᴏ&x&D&B&8&C&9&Bɴ&x&D&D&8&5&9&6ʏ &x&E&1&7&7&8&Dᴜ&x&E&3&7&1&8&8ѕ&x&E&5&6&A&8&3ᴜ&x&E&7&6&3&7&Eᴡ&x&E&9&5&C&7&9ᴀ&x&E&A&5&6&7&4ᴄ&x&E&C&4&F&6&Fᴢ &x&F&0&4&1&6&5ᴘ&x&F&2&3&B&6&0ᴀ&x&F&4&3&4&5&Bᴊ&x&F&6&2&D&5&6ᴇ&x&F&6&2&D&5&6ᴄ&x&F&6&2&D&5&6ᴢ&x&F&6&2&D&5&6ʏ&x&F&6&2&D&5&6ɴ", "SHEARS", 1009);

    @Comment
    @Comment("Konfiguracja Topora Kibica:")
    @CustomKey("topor-kibica")
    public ToporKibicaConfig toporKibica = new ToporKibicaConfig();



    @Comment
    @Comment("Konfiguracja Pilki Kibica:")
    @CustomKey("pilka-kibica")
    public PilkaKibicaConfig pilkaKibica = new PilkaKibicaConfig();

    @Comment
    @Comment("Konfiguracja Granatu Kibica:")
    @CustomKey("granat-kibica")
    public GranatKibicaConfig granatKibica = new GranatKibicaConfig();

    @Comment
    @Comment("Konfiguracja Kija z Kielbasa:")
    @CustomKey("kij-kielbasa")
    public KijKielbasaConfig kijKielbasa = new KijKielbasaConfig();

    @Comment
    @Comment("Konfiguracja Setu Kibica 1.0:")
    @CustomKey("set-kibica-1")
    public SetKibicaConfig setKibica1 = new SetKibicaConfig("1.0", 64, 5);

    @Comment
    @Comment("Konfiguracja Setu Kibica 2.0:")
    @CustomKey("set-kibica-2")
    public SetKibicaConfig setKibica2 = new SetKibicaConfig("2.0", 76, 5);



    public static class TrabkaKibicaConfig extends OkaeriConfig {
        
        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&9&E&4&D&Eᴛ&x&D&4&B&6&B&Cʀ&x&E&0&8&9&9&Aᴀ&x&E&B&5&B&7&8ʙ&x&F&6&2&D&5&6ᴋ&x&F&6&2&D&5&6ᴀ&x&F&6&2&D&5&6ᴋ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ʙ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ᴄ&x&F&6&2&D&5&6ᴀ";

        
        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ɢᴅʏ ᴜᴢʏᴊᴇѕᴢ ᴛʀᴀʙᴋɪ ᴡѕᴢʏѕᴄʏ ɢʀᴀᴄᴢᴇ ᴋᴛᴏʀᴢʏ ᴜѕᴢʏʟᴀ",
                "&x&C&0&E&5&D&D▌ &7ᴏᴛʀᴢʏᴍᴜᴊᴀ ᴇꜰᴇᴋᴛ &cѕɪʟʏ II &7ᴏʀᴀᴢ &bѕᴢʏʙᴋᴏѕᴄ 2 ɴᴀ &eѕᴇᴋᴜɴᴅ 5",
                "&x&C&0&E&5&D&D▌ &7ᴘʀᴢᴇᴅᴍɪᴏᴛᴜ ᴍᴏᴢᴇѕᴢ ᴜᴢʏᴡᴀᴄ ᴄᴏ &f120 ѕᴇᴋᴜɴᴅ"


        );
        
        @Comment("Material przedmiotu")
        public String material = "GOAT_HORN";

        @Comment("CustomModelData ")
        public int customModelData = 1000;

        @Comment("Cooldown w sekundach")
        public int cooldown = 30;
        
        @Comment("Zasieg efektow w kratkach")
        public double range = 5.0;
        
        @Comment("Czas trwania efektow w sekundach")
        public int effectDuration = 5;
    }

    public static class LapkaKibicaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&6&D&6&D&2ʟ&x&C&A&C&7&C&7ᴀ&x&C&F&B&7&B&Bᴘ&x&D&3&A&8&B&0ᴋ&x&D&7&9&9&A&5ᴀ &x&E&0&7&A&8&Eᴋ&x&E&5&6&A&8&3ɪ&x&E&9&5&B&7&8ʙ&x&E&D&4&C&6&Dɪ&x&F&2&3&C&6&1ᴄ&x&F&6&2&D&5&6ᴀ";

        @Comment("Opis przedmiotu")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ɢᴅʏ ᴜᴅᴇʀᴢʏѕᴢ ʟᴀᴘᴋᴀ ɪɴɴᴇɢᴏ ɢʀᴀᴄᴢᴀ",
                "&x&C&0&E&5&D&D▌ &7ᴏᴛʀᴢʏᴍᴀ ᴇꜰᴇᴋᴛʏ &cѕɪʟᴀ II &7ᴏʀᴀᴢ &bѕᴢʏʙᴋᴏѕᴄ II ɴᴀ &e15 ѕᴇᴋᴜɴᴅ",
                "&x&C&0&E&5&D&D▌ &7ᴘʀᴢᴇᴅᴍɪᴏᴛᴜ ᴍᴏᴢᴇѕᴢ ᴜᴢʏᴡᴀᴄ ᴄᴏ &f120 ѕᴇᴋᴜɴᴅ"

        );

        @Comment("Material przedmiotu")
        public String material = "STICK";

        @Comment("CustomModelData ")
        public int customModelData = 1001;

        @Comment("Cooldown w sekundach")
        public int cooldown = 5;

        @Comment("Czas trwania efektow w sekundach")
        public int effectDuration = 5;
    }

    public static class KotwiczkaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&0&D&C&B&9&Cᴋ&x&0&D&C&B&9&Cᴏ&x&0&D&C&B&9&Cᴛ&x&0&D&C&B&9&Cᴡ&x&0&D&C&B&9&Cɪ&x&0&D&C&B&9&Cᴄ&x&0&D&C&B&9&Cᴢ&x&0&D&C&B&9&Cᴋ&x&0&D&C&B&9&Cᴀ";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&4&B&F&B&0ᴡ&x&C&4&B&F&B&0ʏ&x&C&4&B&F&B&0ᴄ&x&C&4&B&F&B&0ᴇ&x&C&4&B&F&B&0ʟ&x&C&4&B&F&B&0ᴜ&x&C&4&B&F&B&0ᴊ &x&C&4&B&F&B&0ᴀ &x&C&4&B&F&B&0ᴘ&x&C&4&B&F&B&0ᴏ&x&C&4&B&F&B&0ᴛ&x&C&4&B&F&B&0ᴇ&x&C&4&B&F&B&0ᴍ &x&C&4&B&F&B&0ʀ&x&C&4&B&F&B&0ᴢ&x&C&4&B&F&B&0ᴜ&x&C&4&B&F&B&0ᴄ &x&C&4&B&F&B&0ᴀ&x&C&4&B&F&B&0ʙ&x&C&4&B&F&B&0ʏ &x&C&4&B&F&B&0ᴡ&x&C&4&B&F&B&0ʏ&x&C&4&B&F&B&0ᴋ&x&C&4&B&F&B&0ᴏ&x&C&4&B&F&B&0ɴ&x&C&4&B&F&B&0ᴀ&x&C&4&B&F&B&0ᴄ &x&C&4&B&F&B&0ѕ&x&C&4&B&F&B&0ᴋ&x&C&4&B&F&B&0ᴏ&x&C&4&B&F&B&0ᴋ &x&C&4&B&F&B&0ᴡ &x&C&4&B&F&B&0ᴅ&x&C&4&B&F&B&0ᴀ&x&C&4&B&F&B&0ɴ&x&C&4&B&F&B&0ᴀ &x&C&4&B&F&B&0ѕ&x&C&4&B&F&B&0ᴛ&x&C&4&B&F&B&0ʀ&x&C&4&B&F&B&0ᴏ&x&C&4&B&F&B&0ɴ&x&C&4&B&F&B&0ᴇ"

        );

        @Comment("Material przedmiotu")
        public String material = "FISHING_ROD";

        @Comment("CustomModelData ")
        public int customModelData = 1002;

        @Comment("Cooldown w sekundach")
        public int cooldown = 10;

        @Comment("Maksymalny zasieg teleportacji")
        public double maxRange = 50.0;
    }

    public static class KetchupowaKuszaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&6&D&6&D&2ᴋ&x&C&A&C&8&C&8ᴇ&x&C&E&B&A&B&Dᴄ&x&D&2&A&C&B&3ᴢ&x&D&6&9&E&A&9ᴜ&x&D&A&9&0&9&Eᴘ&x&D&E&8&2&9&4ᴏ&x&E&2&7&3&8&Aᴡ&x&E&6&6&5&7&Fᴀ &x&E&E&4&9&6&Bᴋ&x&F&2&3&B&6&0ᴜ&x&F&6&2&D&5&6ѕ&x&F&6&2&D&5&6ᴢ&x&F&6&2&D&5&6ᴀ";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&6ɢᴅʏ ᴛʀᴀꜰɪѕᴢ ᴘʀᴢᴇᴄᴢɪᴡɴɪᴋᴀ ѕᴛʀᴢᴀʟᴀ",
                "&6ᴡʏѕᴛʀᴢᴇʟᴏɴᴀ ᴡ ᴛᴇᴊ ᴋᴏѕᴢʏ ᴍᴀѕᴢ ₃₃% ѕᴢᴀɴѕ ɴᴀ ᴛᴏ,",
                "&6ᴢᴇ ᴘʀᴢʏᴄɪᴀɢɴɪᴇѕᴢ ɢʀᴀᴄᴢᴀ ᴅᴏ ѕɪᴇʙɪᴇ.",
                "ᴘʀᴢᴇᴅᴍɪᴏᴛ ᴍᴏᴢᴇѕᴢ ᴜᴢʏᴡᴀᴄ ᴄᴏ ₁₂₀ѕᴇᴋᴜɴᴅ"

        );

        @Comment("Material przedmiotu")
        public String material = "CROSSBOW";

        @Comment("CustomModelData ")
        public int customModelData = 1003;

        @Comment("Cooldown w sekundach")
        public int cooldown = 15;

        @Comment("Szansa na teleportacje w procentach (0-100)")
        public int pullChance = 50;
    }

    public static class PlecakKibicaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&6&D&6&D&2ᴘ&x&C&B&C&5&C&6ʟ&x&D&0&B&4&B&9ᴇ&x&D&4&A&3&A&Dᴄ&x&D&9&9&2&A&0ᴀ&x&D&E&8&2&9&4ᴋ &x&E&8&6&0&7&Bᴋ&x&E&C&4&F&6&Fɪ&x&F&1&3&E&6&2ʙ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ᴄ&x&F&6&2&D&5&6ᴀ";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ᴘʀᴢᴇᴅᴍɪᴏᴛʏ ᴘᴏ ᴢᴀʙᴏᴊѕᴛᴡɪᴇ ɪɴɴᴇɢᴏ ɢʀᴀᴄᴢᴀ ᴛʀᴀꜰɪᴀ ᴡᴀᴍ ᴅᴏ &cᴘʟᴇᴄᴀᴋᴀ ᴋɪʙɪᴄᴀ"
        );

        @Comment("Material przedmiotu")
        public String material = "SHULKER_BOX";

        @Comment("CustomModelData ")
        public int customModelData = 1004;
    }

    public static class SzalikKibicaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&6&D&6&D&2ѕ&x&C&B&C&5&C&6ᴢ&x&D&0&B&4&B&9ᴀ&x&D&4&A&3&A&Dʟ&x&D&9&9&2&A&0ɪ&x&D&E&8&2&9&4ᴋ &x&E&8&6&0&7&Bᴋ&x&E&C&4&F&6&Fɪ&x&F&1&3&E&6&2ʙ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ᴄ&x&F&6&2&D&5&6ᴀ";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ᴛʀᴢʏᴍᴀᴊᴀᴄ ѕᴢᴀʟɪᴋ ᴋɪʙɪᴄᴀ ᴡ ᴅʀᴜɢɪᴇᴊ ʀᴇᴄᴇ",
                "&x&C&0&E&5&D&D▌ &7ᴢᴀʀᴀʙɪᴀѕᴢ ᴏ &e50% ᴡɪᴇᴄᴇᴊ ᴘʀᴢʏ ᴋᴏᴘᴀɴɪᴜ ɢᴇɴᴇʀᴀᴛᴏʀᴏᴡ"
        );

        @Comment("Material przedmiotu")
        public String material = "BANNER";

        @Comment("CustomModelData ")
        public int customModelData = 1005;

        @Comment("Bonus do dropu w procentach")
        public int dropBonus = 50;
    }

    public static class NieskonczoneConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name;

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                ""
        );

        @Comment("Material przedmiotu")
        public String material;

        @Comment("CustomModelData ")
        public int customModelData;

        public NieskonczoneConfig() {}

        public NieskonczoneConfig(String name, String material, int customModelData) {
            this.name = name;
            this.material = material;
            this.customModelData = customModelData;
        }
    }

    public static class ToporKibicaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&6&D&6&D&2ᴛ&x&C&B&C&3&C&4ᴏ&x&D&1&B&0&B&6ᴘ&x&D&6&9&E&A&9ó&x&D&B&8&B&9&Bʀ &x&E&6&6&5&7&Fᴋ&x&E&B&5&3&7&2ɪ&x&F&1&4&0&6&4ʙ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ᴄ&x&F&6&2&D&5&6ᴀ";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ɢᴅʏ ᴜᴅᴇʀᴢʏѕᴢ ᴘʀᴢᴇᴄɪᴡɴɪᴋᴀ ᴛᴏᴘᴏʀᴇᴍ ᴢᴀᴡѕᴢᴇ ᴢᴀʙɪᴇʀᴢᴇ ᴍᴜ &C4 ѕᴇʀᴄᴀ",
                "&x&C&0&E&5&D&D▌ &7ᴅᴏᴅᴀᴛᴋᴏᴡᴏ ᴘᴏ ᴜᴅᴇʀᴢᴇɴɪᴜ ᴘʀᴢᴇᴄɪᴡɴɪᴋ ɴɪᴇ ᴍᴏᴢᴇ ᴋᴏʀᴢʏѕᴛᴀᴄᴅᴏᴅᴀᴛᴋᴏᴡᴏ ᴘᴏ ᴜᴅᴇʀᴢᴇɴɪᴜ ᴘʀᴢᴇᴄɪᴡɴɪᴋ ɴɪᴇ ᴍᴏᴢᴇ ᴋᴏʀᴢʏѕᴛᴀᴄ",
                "&x&C&0&E&5&D&D▌ &7ᴢ &cᴇʟʏᴛʀʏ , ѕᴋᴀᴋᴀɴɪᴀ &fᴏʀᴀᴢ ʙᴇᴅᴢɪᴇ ᴘᴏѕɪᴀᴅᴀʟ ᴇꜰᴇᴋᴛ &5ѕᴘᴏᴡᴏʟɴɪᴇɴɪᴀ IV ᴘʀᴢᴇᴢ &e3 ѕᴇᴋᴜɴᴅʏ"


        );

        @Comment("Material przedmiotu")
        public String material = "DIAMOND_AXE";

        @Comment("CustomModelData ")
        public int customModelData = 1010;

        @Comment("Czas trwania efektow w sekundach")
        public int effectDuration = 5;

        @Comment("Cooldown w sekundach")
        public int cooldown = 20;
    }



    public static class PilkaKibicaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&f&lPilka Kibica";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ɢᴅʏ ᴛʀᴀꜰɪѕᴢ ᴘɪʟᴋą ᴘʀᴢᴇᴄɪᴡɴɪᴋᴀ",
                "&x&C&0&E&5&D&D▌ &7ɴɪᴇ ʙęᴅᴢɪᴇ ᴍóɢʟ &cskakać &7i&c używać elytry przez &e3 sekundy",
                "&x&C&0&E&5&D&D▌ &7ᴏᴛʀᴢʏᴍᴀ ᴏɴ ʀᴏᴡɴɪᴇᴢ ᴇꜰᴇᴋᴛ &5ѕᴘᴏᴡᴏʟɴɪᴇɴɪᴀ IV ɴᴀ &e3 ѕᴇᴋᴜɴᴅʏ",
                "&x&C&0&E&5&D&D▌ &7ᴘɪʟᴋᴀ ᴘᴏ ʀᴢᴜᴄᴇɴɪᴜ ᴢɴɪᴋᴀ"
        );

        @Comment("Material przedmiotu")
        public String material = "SNOWBALL";

        @Comment("CustomModelData ")
        public int customModelData = 1011;

        @Comment("Czas trwania efektow w sekundach")
        public int effectDuration = 3;

        @Comment("Cooldown w sekundach")
        public int cooldown = 15;
    }

    public static class GranatKibicaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&x&C&6&D&6&D&2ɢ&x&C&B&C&5&C&6ʀ&x&D&0&B&4&B&9ᴀ&x&D&4&A&3&A&Dɴ&x&D&9&9&2&A&0ᴀ&x&D&E&8&2&9&4ᴛ &x&E&8&6&0&7&Bᴋ&x&E&C&4&F&6&Fɪ&x&F&1&3&E&6&2ʙ&x&F&6&2&D&5&6ɪ&x&F&6&2&D&5&6ᴄ&x&F&6&2&D&5&6ᴀ";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "",
                "&x&C&0&E&5&D&D▌ &7ᴘᴏ ᴡʏʀᴢᴜᴄᴇɴɪᴜ ɢʀᴀɴᴀᴛᴜ ᴍɪᴇᴊѕᴄᴇ , ᴡ ᴋᴛóʀʏᴍ ᴏɴ ᴡʏʟąᴅᴏᴡᴀʟ",
                "&x&C&0&E&5&D&D▌ &7ѕᴛᴀᴊᴇ ѕɪᴇ &2ѕᴋᴀżᴏɴᴇ ᴋᴀżᴅʏ ᴋᴛᴏ ʙᴇᴅᴢɪᴇ ᴡ ɴɪᴍ ᴘʀᴢᴇʙʏᴡᴀʟ",
                "&x&C&0&E&5&D&D▌ &7ᴏᴛʀᴢʏᴍᴜᴊᴇ ᴇꜰᴇᴋᴛ &dᴏѕłᴀʙɪᴇɴɪᴀ(ɢʟᴏᴡɪɴɢ) &fɴᴀ &e5 ѕᴇᴋᴜɴᴅ"


        );

        @Comment("Material przedmiotu")
        public String material = "LINGERING_POTION";

        @Comment("CustomModelData ")
        public int customModelData = 1012;

        @Comment("Czas trwania efektu w sekundach ")
        public int effectDuration = 10;

        @Comment("Pole w ktorym efekt jest aktywny")
        public double radius = 3.0;

        @Comment("Cooldown w sekundach")
        public int cooldown = 25;
    }

    public static class KijKielbasaConfig extends OkaeriConfig {

        @Comment("Nazwa customowego przedmiotu:")
        public String name = "&6&lKij z Kielbasa";

        @Comment("Opis przedmiotu ")
        public List<String> lore = Arrays.asList(
                "&7Specjalny przedmiot dla kibicow!",
                "",
                "&6> &fUderzenie &7- odrzut IV",
                "&6> &fPotezny knockback",
                "",
                "&8Custom Item - RapyItems"
        );

        @Comment("Material przedmiotu")
        public String material = "STICK";

        @Comment("CustomModelData ")
        public int customModelData = 1013;

        @Comment("Sila odrzutu (1-10)")
        public int knockbackLevel = 4;
    }

    public static class SetKibicaConfig extends OkaeriConfig {

        @Comment("Wersja setu")
        public String version;

        @Comment("Nazwa customowego przedmiotu:")
        public String helmetName = "&6&lHełm Kibica {version}";

        @Comment("Nazwa customowego przedmiotu:")
        public String chestplateName = "&6&lNapierśnik Kibica {version}";

        @Comment("Nazwa customowego przedmiotu:")
        public String leggingsName = "&6&lNogawice Kibica {version}";

        @Comment("Nazwa customowego przedmiotu:")
        public String bootsName = "&6&lButy Kibica {version}";

        @Comment("Opis przedmiotu")
        public List<String> lore = Arrays.asList(
            "&7Część setu Kibica {version}",
            "&8Protection {enchant_level}",
            "&8Unbreaking {enchant_level}",
            "&e+{drop_bonus}% drop bonus",
            "&6Pełny set: +{full_set_bonus}% bonus"
        );

        @Comment("Poziom protection i unbreaking")
        public int enchantLevel;

        @Comment("Bonus do dropu pilki w procentach ")
        public int dropBonus;

        @Comment("Bonus za pelny set w procentach")
        public int fullSetBonus = 10;

        public SetKibicaConfig() {}

        public SetKibicaConfig(String version, int enchantLevel, int dropBonus) {
            this.version = version;
            this.enchantLevel = enchantLevel;
            this.dropBonus = dropBonus;
        }
    }


}
