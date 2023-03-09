package org.redkiller.util.file.nbt.tag;

import net.minecraft.server.v1_16_R3.EnumChatFormat;
import net.minecraft.server.v1_16_R3.IChatBaseComponent;

import java.io.DataOutput;
import java.io.IOException;

public interface NBTBase {
    EnumChatFormat d = EnumChatFormat.AQUA;
    EnumChatFormat e = EnumChatFormat.GREEN;
    EnumChatFormat f = EnumChatFormat.GOLD;
    EnumChatFormat g = EnumChatFormat.RED;

    void write(DataOutput var1) throws IOException;

    String toString();

    byte getTypeId();

    NBTTagType<?> getTagType();

    NBTBase clone();

    default String asString() {
        return this.toString();
    }

    default IChatBaseComponent getNbtPrettyComponent() {
        return this.l();
    }

    default IChatBaseComponent l() {
        return this.a("", 0);
    }

    IChatBaseComponent a(String var1, int var2);
}
