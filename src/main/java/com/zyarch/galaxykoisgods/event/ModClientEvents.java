package com.zyarch.galaxykoisgods.event;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.data.DataHandler;
import com.zyarch.galaxykoisgods.data.FavorSavedData;
import com.zyarch.galaxykoisgods.data.PlayerData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onJoinWorld(PlayerEvent.PlayerLoggedInEvent event) throws Exception {
        Player player = event.getEntity();
        Level level = player.level();
        PlayerData pd = new PlayerData();

        System.out.println("Player joined: " + player.getDisplayName().getString());

        //Server will save references to player data for later
        if(!level.isClientSide) {
            DataHandler.playerDataList.put(player.getUUID(), pd);
            DataHandler.favorDataList.put(player.getUUID(), FavorSavedData.load(event.getEntity().getServer(), player.getUUID().toString()));
        }
    }

    @SubscribeEvent
    public static void onJoinWorld(TickEvent.PlayerTickEvent event) {
        final Player player = event.player;
        //final BlockState state = player.getBlockStateOn();

        if(/*player.inventory.armorItemInSlot(3).getItem().equals(ModItems.AQUA_TRANS_BELT) && */player.isInWater() && player.isSwimming())
        {
            //ModifiableAttributeInstance attribute = player.getAttribute(ForgeMod.SWIM_SPEED.get());//func_110148_a((Attribute)ForgeMod.SWIM_SPEED.get());
            player.setSpeed(16.25f);
        }
    }

//    private static void applyModifier(ModifiableAttributeInstance attribute, UUID modifierId, String modifierName, double modifierAmount, int modifierOperation) {
//        /*AttributeModifier.Operation operation = AttributeModifier.Operation.func_220372_a((int)modifierOperation);
//        AttributeModifier oldModifier = attribute.func_111127_a(modifierId);
//        if (oldModifier == null) {
//            attribute.func_233767_b_(new AttributeModifier(modifierId, modifierName, modifierAmount, operation));
//        } else if (oldModifier.func_111164_d() != modifierAmount || oldModifier.func_220375_c() != operation) {
//            attribute.func_111124_b(oldModifier);
//            attribute.func_233767_b_(new AttributeModifier(modifierId, modifierName, modifierAmount, operation));
//        }*/
//    }
}
