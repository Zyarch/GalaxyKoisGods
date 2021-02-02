package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.entity.projectiles.StormBowBoltEntity;
import com.Zyarch.GalaxyKoisGods.entity.projectiles.TeleportingOrbEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModEntityTypes {


    public static final RegistryObject<EntityType<StormBowBoltEntity>> STORM_BOW_BOLT = register(
            "bolt",
            () -> EntityType.Builder.<StormBowBoltEntity>create(StormBowBoltEntity::new, EntityClassification.MISC)
            .size(0.5F, 0.5F).trackingRange(4).func_233608_b_(20)
            .build(new ResourceLocation(GalaxyKoisGods.MOD_ID, "bolt").toString())
    );

    public static final RegistryObject<EntityType<TeleportingOrbEntity>> TELEPORTING_ORB = register("teleporting_orb",
            () -> EntityType.Builder.<TeleportingOrbEntity>create(TeleportingOrbEntity::new, EntityClassification.MISC)
            .size(0.25F, 0.25F).trackingRange(4).func_233608_b_(10)
            .build(new ResourceLocation(GalaxyKoisGods.MOD_ID, "teleporting_orb").toString()));

    static void register() { }

    private static <T extends EntityType<?>> RegistryObject<T> register(String name, Supplier<T> entityType) {
        return Registration.ENTITY_TYPES.register(name, entityType);
    }
}
