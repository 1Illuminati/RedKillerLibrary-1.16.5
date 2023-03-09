package org.redkiller.util.file.nbt;

import net.minecraft.server.v1_16_R3.Unit;

import java.util.Optional;

public interface IChatFormatted {
    Optional<Unit> b = Optional.of(Unit.INSTANCE);
    net.minecraft.server.v1_16_R3.IChatFormatted c = new net.minecraft.server.v1_16_R3.IChatFormatted() {
        public <T> Optional<T> a(a<T> var0) {
            return Optional.empty();
        }
    };

    <T> Optional<T> a(net.minecraft.server.v1_16_R3.IChatFormatted.a<T> var1);

    static net.minecraft.server.v1_16_R3.IChatFormatted b(final String var0) {
        return new net.minecraft.server.v1_16_R3.IChatFormatted() {
            public <T> Optional<T> a(a<T> var0x) {
                return var0x.accept(var0);
            }
        };
    }

    default String getString() {
        StringBuilder var0 = new StringBuilder();
        this.a((var1) -> {
            var0.append(var1);
            return Optional.empty();
        });
        return var0.toString();
    }

    public interface a<T> {
        Optional<T> accept(String var1);
    }
}
