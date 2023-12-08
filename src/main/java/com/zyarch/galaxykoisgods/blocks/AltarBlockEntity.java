package com.zyarch.galaxykoisgods.blocks;

import com.zyarch.galaxykoisgods.data.DataHandler;
import com.zyarch.galaxykoisgods.data.PlayerData;
import com.zyarch.galaxykoisgods.gods.GalasGods;
import com.zyarch.galaxykoisgods.gods.God;
import com.zyarch.galaxykoisgods.screens.menus.AltarMenu;
import com.zyarch.galaxykoisgods.setup.GalasBlockEntityTypes;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import com.zyarch.galaxykoisgods.utility.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AltarBlockEntity extends BaseContainerBlockEntity implements TickableBlockEntity {
    private final int offerTime = 20;
    private NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    public Player offeringPlayer = null;
    private int offerProgress = 0;

    private final ContainerData dataAccess = new ContainerData() {
        public int get(int p_58431_) {
            switch (p_58431_) {
                case 0:
                    return AltarBlockEntity.this.offerProgress;
                case 1:
                    return AltarBlockEntity.this.offerTime;
                default:
                    return 0;
            }
        }

        public void set(int p_58433_, int p_58434_) {
            switch (p_58433_) {
                case 0:
                    AltarBlockEntity.this.offerProgress = p_58434_;
                    break;
                case 1:
                    //AltarBlockEntity.this.offerTime = p_58434_;
                    break;
            }
        }

        public int getCount() {
            return 2;
        }
    };

    public AltarBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(GalasBlockEntityTypes.ALTAR.get(), blockPos, blockState);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    @NotNull
    public ItemStack getItem(int index) {
        return index >= 0 && index < this.getContainerSize() ? this.items.get(index) : ItemStack.EMPTY;
    }

    @Override
    @NotNull
    public ItemStack removeItem(int index, int count) {
        return ContainerHelper.removeItem(this.items, index, count);
    }

    @Override
    @NotNull
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.items, index);
    }

    @Override
    public void setItem(int index, ItemStack itemStack) {
        CommonUtility.LOGGER.debug("setItem - [" + index + ", " + itemStack + "]");
        if (index >= 0 && index < this.getContainerSize()) {
            this.items.set(index, itemStack);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    @NotNull
    protected Component getDefaultName() {
        return Component.translatable("container.altar");
    }

    @Override
    @NotNull
    protected AbstractContainerMenu createMenu(int p_58627_, Inventory p_58628_) {
        return new AltarMenu(p_58627_, p_58628_, this, this.dataAccess);
    }

    public void tick() {
        if(!this.items.isEmpty() && !this.items.get(0).isEmpty() && this.offeringPlayer != null) {
            if(offerProgress == offerTime) {
                ItemStack item = this.items.get(0);
                God selectedGod = GalasGods.getGod(0);
                UUID playerUUID = this.offeringPlayer.getUUID();
                PlayerData playerData = DataHandler.playerDataList.get(playerUUID);

                playerData.addFavor(selectedGod.getName(), selectedGod.getValue(item));


                String message;

                if (selectedGod.isInOfferList(item)) {
                    message = selectedGod.goodOffer(item);
                } else if (selectedGod.isInBadList(item)) {
                    message = selectedGod.badOffer(item);
                } else {
                    message = selectedGod.neutralOffer(item);
                }

                PlayerChatMessage chatMessage = PlayerChatMessage.unsigned(playerUUID, message);
                this.offeringPlayer.createCommandSourceStack().sendChatMessage(
                        new OutgoingChatMessage.Player(chatMessage), false, ChatType.bind(ChatType.CHAT, this.offeringPlayer));

                try {
                    DataHandler.store(playerUUID, new CompoundTag(), playerData);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                this.items.get(0).shrink(1);
                offerProgress = 0;
            } else {
                offerProgress++;
            }
        } else {
            offerProgress = 0;
        }
    }

    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.items);
    }

    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        ContainerHelper.saveAllItems(compoundTag, this.items);
    }
}

