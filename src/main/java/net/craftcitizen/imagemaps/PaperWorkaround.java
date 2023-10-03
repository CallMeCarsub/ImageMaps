package net.craftcitizen.imagemaps;

import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_20_R2.CraftServer;
import org.bukkit.map.MapView;

import java.lang.reflect.Method;
import java.util.function.Function;

public class PaperWorkaround {
    public static MapView getMap(Integer mapId){
        MapView map = null;
        String id = "map_" + mapId;
        try {
            final DimensionDataStorage storage = ((CraftServer) (Bukkit.getServer())).getServer().overworld().getDataStorage();
            net.minecraft.world.level.saveddata.SavedData existing = storage.cache.get(id);
            if (existing == null && !storage.cache.containsKey(id)) {
                final net.minecraft.world.level.saveddata.SavedData.Factory<MapItemSavedData> factory = MapItemSavedData.factory();
                Method method = DimensionDataStorage.class.getDeclaredMethod("a", Function.class, DataFixTypes.class, String.class);
                method.setAccessible(true);
                final MapItemSavedData ourMap = (MapItemSavedData) method.invoke(storage, factory.deserializer(), factory.type(), id);
                if (ourMap != null) {
                    ourMap.id = id;
                }

                storage.cache.put(id, ourMap);
                existing = ourMap;
            }
            map = existing instanceof MapItemSavedData data ? data.mapView : null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
