package org.redkiller.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomInventory implements Inventory {
    private final Inventory inventory;
    private final HashMap<Integer, Button> buttons = new HashMap<>();

    protected CustomInventory(InventoryType inventoryType) {
        this(null, inventoryType);
    }

    protected CustomInventory(int size) {
        this(null, size);
    }

    protected CustomInventory(InventoryType inventoryType, String title) {
        this(null, inventoryType, title);
    }

    protected CustomInventory(int size, String title) {
        this(null, size, title);
    }

    protected CustomInventory(InventoryHolder inventoryHolder, InventoryType inventoryType) {
        this(Bukkit.createInventory(inventoryHolder, inventoryType));
    }

    protected CustomInventory(InventoryHolder inventoryHolder, int size) {
        this(Bukkit.createInventory(inventoryHolder, size));
    }

    protected CustomInventory(InventoryHolder inventoryHolder, InventoryType inventoryType, String title) {
        this(Bukkit.createInventory(inventoryHolder, inventoryType, title));
    }

    protected CustomInventory(InventoryHolder inventoryHolder, int size, String title) {
        this(Bukkit.createInventory(inventoryHolder, size, title));
    }

    private CustomInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void closeEvent(InventoryCloseEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void clickEvent(InventoryClickEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void openEvent(InventoryOpenEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void putButton(int slot, Button button) {
        buttons.put(slot, button);
    }

    public Button getButton(int slot) {
        return buttons.get(slot);
    }

    public boolean hasButton(int slot) {
        return buttons.containsKey(slot);
    }

    public void buttonClickEvent(int slot, InventoryClickEvent event) {
        if (buttons.containsKey(slot)) {
            buttons.get(slot).onClick(event);
        }
    }

    public interface Button {
        public void onClick(InventoryClickEvent event);

    }

    /**
     * Inventory 인터페이스 구현
     */

    @Override
    public void forEach(Consumer<? super ItemStack> action) {
        this.inventory.forEach(action);
    }

    @Override
    public Spliterator<ItemStack> spliterator() {
        return inventory.spliterator();
    }

    @Override
    public String toString() {
        return this.inventory.toString();
    }


    @Override
    public int getSize() {
        return this.inventory.getSize();
    }

    @Override
    public int getMaxStackSize() {
        return this.inventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        this.inventory.setMaxStackSize(i);
    }

    @Override
    public @Nullable ItemStack getItem(int i) {
        return this.inventory.getItem(i);
    }

    @Override
    public void setItem(int i, @Nullable ItemStack itemStack) {
        this.inventory.setItem(i, itemStack);
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> addItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return this.inventory.addItem(itemStacks);
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> removeItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return this.inventory.removeItem(itemStacks);
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> removeItemAnySlot(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return this.inventory.removeItemAnySlot(itemStacks);
    }

    @Override
    public @org.checkerframework.checker.nullness.qual.Nullable ItemStack @NonNull [] getContents() {
        return this.inventory.getContents();
    }

    @Override
    public void setContents(@NotNull ItemStack[] itemStacks) throws IllegalArgumentException {
        this.inventory.setContents(itemStacks);
    }

    @Override
    public @NotNull ItemStack[] getStorageContents() {
        return this.inventory.getStorageContents();
    }

    @Override
    public void setStorageContents(@NotNull ItemStack[] itemStacks) throws IllegalArgumentException {
        this.inventory.setStorageContents(itemStacks);
    }

    @Override
    public boolean contains(@NotNull Material material) throws IllegalArgumentException {
        return this.inventory.contains(material);
    }

    @Override
    public boolean contains(@Nullable ItemStack itemStack) {
        return this.inventory.contains(itemStack);
    }

    @Override
    public boolean contains(@NotNull Material material, int i) throws IllegalArgumentException {
        return this.inventory.contains(material, i);
    }

    @Override
    public boolean contains(@Nullable ItemStack itemStack, int i) {
        return this.inventory.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(@Nullable ItemStack itemStack, int i) {
        return this.inventory.containsAtLeast(itemStack, i);
    }

    @Override
    public @NotNull HashMap<Integer, ? extends ItemStack> all(@NotNull Material material) throws IllegalArgumentException {
        return this.inventory.all(material);
    }

    @Override
    public @NotNull HashMap<Integer, ? extends ItemStack> all(@Nullable ItemStack itemStack) {
        return this.inventory.all(itemStack);
    }

    @Override
    public int first(@NotNull Material material) throws IllegalArgumentException {
        return this.inventory.first(material);
    }

    @Override
    public int first(@NotNull ItemStack itemStack) {
        return this.inventory.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return this.inventory.firstEmpty();
    }

    @Override
    public boolean isEmpty() {
        return this.inventory.isEmpty();
    }

    @Override
    public void remove(@NotNull Material material) throws IllegalArgumentException {
        this.inventory.remove(material);
    }

    @Override
    public void remove(@NotNull ItemStack itemStack) {
        this.inventory.remove(itemStack);
    }

    @Override
    public void clear(int i) {
        this.inventory.clear(i);
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    @Override
    public int close() {
        return this.inventory.close();
    }

    @Override
    public @NotNull List<HumanEntity> getViewers() {
        return this.inventory.getViewers();
    }

    @Override
    public @NotNull InventoryType getType() {
        return this.inventory.getType();
    }

    @Override
    public @Nullable InventoryHolder getHolder() {
        return this.inventory.getHolder();
    }

    @Override
    public @Nullable InventoryHolder getHolder(boolean b) {
        return this.inventory.getHolder(b);
    }

    @Override
    public @NotNull ListIterator<ItemStack> iterator() {
        return this.inventory.iterator();
    }

    @Override
    public @NotNull ListIterator<ItemStack> iterator(int i) {
        return this.inventory.iterator(i);
    }

    @Override
    public @Nullable Location getLocation() {
        return this.inventory.getLocation();
    }

    @Override
    public CustomInventory clone() {
        return new CustomInventory(this.inventory);
    }
}
