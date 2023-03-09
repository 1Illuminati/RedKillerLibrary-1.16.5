package org.redkiller.util.file.nbt.tag;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagEnd implements NBTBase {
    public static final NBTTagType<NBTTagEnd> a = new NBTTagType<>() {
        public NBTTagEnd b(DataInput var0, int var1, NBTReadLimiter var2) {
            var2.a(64L);
            return NBTTagEnd.b;
        }

        public String a() {
            return "END";
        }

        public String b() {
            return "TAG_End";
        }

        public boolean c() {
            return true;
        }
    };
    public static final NBTTagEnd b = new NBTTagEnd();

    private NBTTagEnd() {
    }

    public void write(DataOutput var0) throws IOException {
    }

    public byte getTypeId() {
        return 0;
    }

    public NBTTagType<NBTTagEnd> getTagType() {
        return a;
    }

    public String toString() {
        return "END";
    }

    public NBTTagEnd clone() {
        return this;
    }

    public IChatBaseComponent a(String var0, int var1) {
        return ChatComponentText.d;
    }
}
