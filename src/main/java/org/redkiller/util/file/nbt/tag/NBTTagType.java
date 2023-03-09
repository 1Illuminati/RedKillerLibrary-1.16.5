package org.redkiller.util.file.nbt.tag;

import java.io.DataInput;
import java.io.IOException;

public interface NBTTagType<T extends NBTBase> {
    T b(DataInput var1, int var2, NBTReadLimiter var3) throws IOException;

    default boolean c() {
        return false;
    }

    String a();

    String b();

    static NBTTagType<NBTTagEnd> a(final int var0) {
        return new NBTTagType<>() {
            public NBTTagEnd b(DataInput var0x, int var1, NBTReadLimiter var2) throws IOException {
                throw new IllegalArgumentException("Invalid tag id: " + var0);
            }

            public String a() {
                return "INVALID[" + var0 + "]";
            }

            public String b() {
                return "UNKNOWN_" + var0;
            }
        };
    }
}
