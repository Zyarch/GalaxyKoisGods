package com.zyarch.galaxykoisgods.event;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.entity.monster.Cultist;
import com.zyarch.galaxykoisgods.setup.GalasEntityTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
     @SubscribeEvent
    public static void entityAttributeCreationEventHandler(EntityAttributeCreationEvent event) {
        event.put(GalasEntityTypes.CULTIST.get(), Cultist.createAttributes().build());
    }

    @SubscribeEvent
    public static void entityAttributeCreationEventHandler(SpawnPlacementRegisterEvent event) {
        event.register(
                GalasEntityTypes.CULTIST.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                Cultist::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR);
    }
 }
