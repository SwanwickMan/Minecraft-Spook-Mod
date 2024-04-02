package swannick.minecraft.mod.thespookmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import swannick.minecraft.mod.thespookmod.TheSpookModPacketHandler;
import swannick.minecraft.mod.thespookmod.network.CustomC2SPacket;

public class TheSpookSpawnEgg extends Item {

    public TheSpookSpawnEgg(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //random debug
        System.out.println("Bill clinton has a very bent knob");

        if(!level.isClientSide){
            System.out.println("Hilary Clinton more like Killary Killton");

        }
        else {
            TheSpookModPacketHandler.sendToServer(new CustomC2SPacket());
        }


        // add item delay
        player.getCooldowns().addCooldown(this, 60);
        return super.use(level, player, hand);
    }
}
