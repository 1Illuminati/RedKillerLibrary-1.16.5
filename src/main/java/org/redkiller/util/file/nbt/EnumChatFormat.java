package org.redkiller.util.file.nbt;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

public enum EnumChatFormat {
    BLACK("BLACK", '0', 0, 0),
    DARK_BLUE("DARK_BLUE", '1', 1, 170),
    DARK_GREEN("DARK_GREEN", '2', 2, 43520),
    DARK_AQUA("DARK_AQUA", '3', 3, 43690),
    DARK_RED("DARK_RED", '4', 4, 11141120),
    DARK_PURPLE("DARK_PURPLE", '5', 5, 11141290),
    GOLD("GOLD", '6', 6, 16755200),
    GRAY("GRAY", '7', 7, 11184810),
    DARK_GRAY("DARK_GRAY", '8', 8, 5592405),
    BLUE("BLUE", '9', 9, 5592575),
    GREEN("GREEN", 'a', 10, 5635925),
    AQUA("AQUA", 'b', 11, 5636095),
    RED("RED", 'c', 12, 16733525),
    LIGHT_PURPLE("LIGHT_PURPLE", 'd', 13, 16733695),
    YELLOW("YELLOW", 'e', 14, 16777045),
    WHITE("WHITE", 'f', 15, 16777215),
    OBFUSCATED("OBFUSCATED", 'k', true),
    BOLD("BOLD", 'l', true),
    STRIKETHROUGH("STRIKETHROUGH", 'm', true),
    UNDERLINE("UNDERLINE", 'n', true),
    ITALIC("ITALIC", 'o', true),
    RESET("RESET", 'r', -1, (Integer)null);

    private static final Map<String, EnumChatFormat> w = Arrays.stream(values()).collect(Collectors.toMap(enumchatformat -> c(enumchatformat.y), enumchatformat -> enumchatformat));
    private static final Pattern x = Pattern.compile("(?i)§[0-9A-FK-OR]");
    private final String y;
    public final char character;
    private final boolean A;
    private final String B;
    private final int C;
    @Nullable
    private final Integer D;

    private static String c(String s) {
        return s.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");
    }

    private EnumChatFormat(String s, char c0, int i, Integer integer) {
        this(s, c0, false, i, integer);
    }

    private EnumChatFormat(String s, char c0, boolean flag) {
        this(s, c0, flag, -1, (Integer)null);
    }

    private EnumChatFormat(String s, char c0, boolean flag, int i, Integer integer) {
        this.y = s;
        this.character = c0;
        this.A = flag;
        this.C = i;
        this.D = integer;
        this.B = "§" + c0;
    }

    public int b() {
        return this.C;
    }

    public boolean isFormat() {
        return this.A;
    }

    public boolean d() {
        return !this.A && this != RESET;
    }

    @Nullable
    public Integer getHexValue() {
        return this.e();
    }

    @Nullable
    public Integer e() {
        return this.D;
    }

    public String f() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return this.B;
    }

    @Nullable
    public static String a(@Nullable String s) {
        return s == null ? null : x.matcher(s).replaceAll("");
    }

    @Nullable
    public static EnumChatFormat b(@Nullable String s) {
        return s == null ? null : (EnumChatFormat) w.get(c(s));
    }

    @Nullable
    public static EnumChatFormat getByHexValue(int i) {
        EnumChatFormat[] var1 = values();
        for (EnumChatFormat value : var1) {
            if (value.getHexValue() != null && value.getHexValue() == i) {
                return value;
            }
        }

        return null;
    }

    @Nullable
    public static EnumChatFormat a(int i) {
        if (i < 0) {
            return RESET;
        } else {
            EnumChatFormat[] aenumchatformat = values();

            for (EnumChatFormat enumchatformat : aenumchatformat) {
                if (enumchatformat.b() == i) {
                    return enumchatformat;
                }
            }

            return null;
        }
    }

    public static Collection<String> a(boolean flag, boolean flag1) {
        List<String> list = Lists.newArrayList();
        EnumChatFormat[] aenumchatformat = values();

        for (EnumChatFormat enumchatformat : aenumchatformat) {
            if ((!enumchatformat.d() || flag) && (!enumchatformat.isFormat() || flag1)) {
                list.add(enumchatformat.f());
            }
        }

        return list;
    }
}
