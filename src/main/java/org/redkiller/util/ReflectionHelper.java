package org.redkiller.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionHelper {
    private ReflectionHelper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void setFiled(Object object, Field field, Object value) {
        try {
            if (Modifier.isFinal(field.getModifiers())) {
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            }

            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
