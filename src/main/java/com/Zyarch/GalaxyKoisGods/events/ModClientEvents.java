package com.Zyarch.GalaxyKoisGods.events;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.data.DataHandler;
import com.Zyarch.GalaxyKoisGods.data.PlayerData;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.DepthStriderEnchantment;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onJoinWorld(PlayerEvent.PlayerLoggedInEvent event) throws Exception {
        PlayerEntity player = event.getPlayer();
        World world = player.world;
        PlayerData pd = new PlayerData();

        System.out.println("Player joined: " + player.getDisplayName().getString());

        DataHandler.loadPlayerData(event.getPlayer(), LogicalSide.SERVER, pd);

        //Server will save references to player data for later
        if(!world.isRemote) {
            System.out.println("This is the server side");
            DataHandler.playerDataList.put(player.getUniqueID(), pd);
        }
        else
            System.out.println("This is the client side");
    }

    @SubscribeEvent
    public static void onJoinWorld(TickEvent.PlayerTickEvent event) throws Exception {
        final PlayerEntity player = event.player;
        final BlockState state = player.getBlockState();

        if(/*player.inventory.armorItemInSlot(3).getItem().equals(ModItems.AQUA_TRANS_BELT) && */player.isInWater() && player.isSwimming())
        {
            //ModifiableAttributeInstance attribute = player.getAttribute(ForgeMod.SWIM_SPEED.get());//func_110148_a((Attribute)ForgeMod.SWIM_SPEED.get());
            player.setMotionMultiplier(state, new Vector3d(16.25d, 4.25d, 16.25d));
        }
    }

    private static void applyModifier(ModifiableAttributeInstance attribute, UUID modifierId, String modifierName, double modifierAmount, int modifierOperation) {
        /*AttributeModifier.Operation operation = AttributeModifier.Operation.func_220372_a((int)modifierOperation);
        AttributeModifier oldModifier = attribute.func_111127_a(modifierId);
        if (oldModifier == null) {
            attribute.func_233767_b_(new AttributeModifier(modifierId, modifierName, modifierAmount, operation));
        } else if (oldModifier.func_111164_d() != modifierAmount || oldModifier.func_220375_c() != operation) {
            attribute.func_111124_b(oldModifier);
            attribute.func_233767_b_(new AttributeModifier(modifierId, modifierName, modifierAmount, operation));
        }*/
    }
}
