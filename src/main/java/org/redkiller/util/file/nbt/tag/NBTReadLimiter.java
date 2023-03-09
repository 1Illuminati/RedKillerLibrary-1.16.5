package org.redkiller.util.file.nbt.tag;

public class NBTReadLimiter {
    public static final net.minecraft.server.v1_16_R3.NBTReadLimiter a = new net.minecraft.server.v1_16_R3.NBTReadLimiter(0L) {
        public void a(long var0) {
        }
    };
    private final long b;
    private long c;

    public NBTReadLimiter(long var0) {
        this.b = var0;
    }

    public void a(long var0) {
        this.c += var0 / 8L;
        if (this.c > this.b) {
            throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.c + "bytes where max allowed: " + this.b);
        }
    }
}
