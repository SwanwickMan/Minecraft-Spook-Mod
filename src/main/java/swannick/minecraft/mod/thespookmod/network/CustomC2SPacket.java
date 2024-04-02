package swannick.minecraft.mod.thespookmod.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.server.ServerLifecycleHooks;
import swannick.minecraft.mod.thespookmod.TheSpookModPacketHandler;

import java.util.function.Supplier;

public class CustomC2SPacket {
    public CustomC2SPacket(){

    }

    public CustomC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {


            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                ///code here
                TheSpookModPacketHandler.sendToPlayer(new CustomS2CPacket(), player);
                System.out.println(player.getIpAddress());
            }


        });
        return true;
    }
}
