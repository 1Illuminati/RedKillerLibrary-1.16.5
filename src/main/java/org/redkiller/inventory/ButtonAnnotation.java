package org.redkiller.inventory;

import org.bukkit.event.inventory.ClickType;

public @interface ButtonAnnotation {
    ClickType clickType();

}