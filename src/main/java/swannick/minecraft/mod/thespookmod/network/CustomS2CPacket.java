package swannick.minecraft.mod.thespookmod.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.network.NetworkEvent;
import swannick.minecraft.mod.thespookmod.ScaryUI;
import swannick.minecraft.mod.thespookmod.TheSpookMod;

import java.util.Date;
import java.util.function.Supplier;

public class CustomS2CPacket {
    public CustomS2CPacket(){

    }

    public CustomS2CPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        System.out.println("handle my balls");
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // play sound stuff

            Minecraft.getInstance().player.playSound(new SoundEvent(new ResourceLocation(TheSpookMod.MODID, "scary_sound")), 1000.0f, 1.0f);
            ScaryUI.startTime = (new Date()).getTime();


        });
        return true;
    }
}
