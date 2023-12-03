package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.entity.projectiles.StormBowBoltEntity;
import com.zyarch.galaxykoisgods.entity.projectiles.ThrownTeleportingOrb;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GalasEntityTypes {
    public static final RegistryObject<EntityType<StormBowBoltEntity>> STORM_BOW_BOLT = register(
            "bolt",
            () -> EntityType.Builder.<StormBowBoltEntity>of(StormBowBoltEntity::new, MobCategory.MISC)
                    .size(0.5F, 0.5F).trackingRange(4).func_233608_b_(20)
                    .build(new ResourceLocation(GalaxyKoisGods.MODID, "bolt").toString())
    );

    public static final RegistryObject<EntityType<ThrownTeleportingOrb>> TELEPORTING_ORB = register("teleporting_orb",
            () -> EntityType.Builder.<ThrownTeleportingOrb>of(ThrownTeleportingOrb::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(GalaxyKoisGods.MODID, "teleporting_orb").toString()));

    static void register() { }

    private static <T extends EntityType<?>> RegistryObject<T> register(String name, Supplier<T> entityTypeSupplier) {
        return Registration.ENTITY_TYPES.register(name, entityTypeSupplier);
    }
}