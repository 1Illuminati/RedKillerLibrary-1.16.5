package org.redkiller.util.file.nbt;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.util.BoundingBox;
import org.redkiller.util.map.dataMap.DataMap;

import java.util.*;

public class NBTHelper {
    private static final String COMPOUND_TYPE = "redKillerLibrary_CompoundType";

    private NBTHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static void saveDataMap(String path, DataMap dataMap) {
        NBTTagCompound nbtTagCompound = (NBTTagCompound) objToNBT(dataMap);
        NBTFile nbtFile = new NBTFile(path, nbtTagCompound);
        nbtFile.write();
    }

    public static DataMap loadDataMap(String path) {
        NBTFile nbtFile = new NBTFile(path);
        nbtFile.read();
        return DataMap.fromNBT(nbtFile.getCompound());
    }

    public static Object nbtToObj(NBTBase nbtBase) {
        if (nbtBase instanceof NBTTagInt nbtTagInt) {
            return nbtTagInt.asInt();
        } else if (nbtBase instanceof NBTTagDouble nbtTagDouble) {
            return nbtTagDouble.asDouble();
        } else if (nbtBase instanceof NBTTagByte nbtTagByte) {
            return nbtTagByte.asByte();
        } else if (nbtBase instanceof NBTTagLong nbtTagLong) {
            return nbtTagLong.asLong();
        } else if (nbtBase instanceof NBTTagFloat nbtTagFloat) {
            return nbtTagFloat.asFloat();
        } else if (nbtBase instanceof NBTTagString) {
            String result = nbtBase.asString();

            if (result.equals("tRuE"))
                return true;
            else if (result.equals("fAlSe"))
                return false;

            return nbtBase.asString();
        } else if (nbtBase instanceof NBTTagShort nbtTagShort) {
            return nbtTagShort.asShort();
        } else if (nbtBase instanceof NBTTagByteArray nbtTagByteArray) {
            return nbtTagByteArray.getBytes();
        } else if (nbtBase instanceof NBTTagIntArray nbtTagIntArray) {
            return nbtTagIntArray.getInts();
        } else if (nbtBase instanceof NBTTagLongArray nbtTagLongArray) {
            return nbtTagLongArray.getLongs();
        } else if (nbtBase instanceof NBTTagCompound nbtTagCompound) {
            String type = "";
            if (nbtTagCompound.hasKey(COMPOUND_TYPE)) {
                type = nbtTagCompound.getString(COMPOUND_TYPE);
                nbtTagCompound.remove(COMPOUND_TYPE);
            }

            switch (type) {
                case "itemStack" -> {
                    return CraftItemStack.asBukkitCopy(ItemStack.fromCompound(nbtTagCompound));
                }
                case "map" -> {
                    Iterator<String> iteratorMap = nbtTagCompound.getKeys().iterator();
                    HashMap<String, Object> map = new HashMap<>();
                    while (iteratorMap.hasNext()) {
                        String key = iteratorMap.next();
                        map.put(key, nbtToObj(nbtTagCompound.get(key)));
                    }
                    return map;
                }
                case "location" -> {
                    World world = Bukkit.getWorld(nbtTagCompound.getString("world"));
                    if (world == null)
                        world = Bukkit.getWorlds().get(0);
                    return new Location(world, nbtTagCompound.getDouble("x"), nbtTagCompound.getDouble("y"), nbtTagCompound.getDouble("z"),
                            nbtTagCompound.getFloat("yaw"), nbtTagCompound.getFloat("pitch"));
                }
                case "boundingBox" -> {
                    return new BoundingBox(nbtTagCompound.getDouble("minX"), nbtTagCompound.getDouble("minY"), nbtTagCompound.getDouble("minZ"),
                            nbtTagCompound.getDouble("maxX"), nbtTagCompound.getDouble("maxY"), nbtTagCompound.getDouble("maxZ"));
                }
                case "uuid" -> {
                    return UUID.fromString(nbtTagCompound.getString("uuid"));
                }
                default -> {
                    Iterator<String> iteratorDataMap = nbtTagCompound.getKeys().iterator();
                    DataMap dataMap = new DataMap();
                    while (iteratorDataMap.hasNext()) {
                        String key = iteratorDataMap.next();
                        dataMap.put(key, nbtToObj(nbtTagCompound.get(key)));
                    }
                    return dataMap;
                }
            }
        } else if (nbtBase instanceof NBTTagList nbtTagList) {
            List<Object> list = new ArrayList<>();
            for (NBTBase base : nbtTagList) {
                list.add(nbtToObj(base));
            }

            return list;
        }

        throw new UnsupportedClassVersionError();
    }

    public static NBTBase objToNBT(Object object) {
        if (object == null) {
            throw new NullPointerException("Object is null");
        } else if (object instanceof String value) {
            return NBTTagString.a(value);
        } else if (object instanceof Integer value) {
            return NBTTagInt.a(value);
        } else if (object instanceof Double value) {
            return NBTTagDouble.a(value);
        } else if (object instanceof Float value) {
            return NBTTagFloat.a(value);
        } else if (object instanceof Boolean value) {
            return NBTTagString.a(value ? "tRuE" : "fAlSe");
        } else if (object instanceof Short value) {
            return NBTTagShort.a(value);
        } else if (object instanceof Long value) {
            return NBTTagLong.a(value);
        } else if (object instanceof Byte value) {
            return NBTTagByte.a(value);
        } else if (object instanceof int[] value) {
            return new NBTTagIntArray(value);
        } else if (object instanceof byte[] value) {
            return new NBTTagByteArray(value);
        } else if (object instanceof long[] value) {
            return new NBTTagLongArray(value);
        } else if (object instanceof Map value) {
            NBTTagCompound nbtTagCompound = new NBTTagCompound();

            for (Object key : value.entrySet()) {
                if (key instanceof String strKey)
                    nbtTagCompound.set(strKey, objToNBT(value.get(strKey)));
                else
                    throw new IllegalStateException("Map key must be a String");
            }

            nbtTagCompound.setString(COMPOUND_TYPE, "map");
            return nbtTagCompound;
        } else if (object instanceof DataMap value) {
            NBTTagCompound nbtTagCompound = new NBTTagCompound();

            for (String key : value.getMap().keySet()) {
                nbtTagCompound.set(key, objToNBT(value.get(key)));
            }

            return nbtTagCompound;
        } else if (object instanceof List value) {
            NBTTagList tagList = new NBTTagList();

            for (Object obj : value) {
                tagList.add(objToNBT(obj));
            }

            return tagList;
        } else if (object instanceof org.bukkit.inventory.ItemStack value) {
            NBTTagCompound itemStackCompound = new NBTTagCompound();
            CraftItemStack.asNMSCopy(value).save(itemStackCompound);

            itemStackCompound.setString(COMPOUND_TYPE, "itemStack");
            return itemStackCompound;
        } else if (object instanceof Location value) {
            NBTTagCompound locationCompound = new NBTTagCompound();

            locationCompound.setDouble("x", value.getX());
            locationCompound.setDouble("y", value.getY());
            locationCompound.setDouble("z", value.getZ());
            locationCompound.setFloat("yaw", value.getYaw());
            locationCompound.setFloat("pitch", value.getPitch());
            locationCompound.setString("world", value.getWorld().getName());

            locationCompound.setString(COMPOUND_TYPE, "location");
            return locationCompound;
        } else if (object instanceof BoundingBox value) {
            NBTTagCompound boundingBoxCompound = new NBTTagCompound();

            boundingBoxCompound.setDouble("minX", value.getMinX());
            boundingBoxCompound.setDouble("minY", value.getMinY());
            boundingBoxCompound.setDouble("minZ", value.getMinZ());
            boundingBoxCompound.setDouble("maxX", value.getMaxX());
            boundingBoxCompound.setDouble("maxY", value.getMaxY());
            boundingBoxCompound.setDouble("maxZ", value.getMaxZ());

            boundingBoxCompound.setString(COMPOUND_TYPE, "boundingBox");
            return boundingBoxCompound;
        } else if (object instanceof UUID value) {
            NBTTagCompound uuidCompound = new NBTTagCompound();

            uuidCompound.setString("uuid", value.toString());

            uuidCompound.setString(COMPOUND_TYPE, "uuid");
            return uuidCompound;
        }

        throw new UnsupportedClassVersionError();
    }
}
