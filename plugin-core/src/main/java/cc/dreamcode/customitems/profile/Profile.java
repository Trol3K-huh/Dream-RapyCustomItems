package cc.dreamcode.customitems.profile;

import eu.okaeri.configs.annotation.CustomKey;
import eu.okaeri.persistence.document.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class Profile extends Document {

    @CustomKey("name")
    private String name;


    @CustomKey("elytra-blocked")
    private long elytraBlocked = 0;

    @CustomKey("jump-blocked")
    private long jumpBlocked = 0;

    @CustomKey("fire-resistance-blocked")
    private long fireResistanceBlocked = 0;

    public UUID getUniqueId() {
        return this.getPath().toUUID();
    }


    public boolean isElytraBlocked() {
        return System.currentTimeMillis() < elytraBlocked;
    }

    public boolean isJumpBlocked() {
        return System.currentTimeMillis() < jumpBlocked;
    }


}
