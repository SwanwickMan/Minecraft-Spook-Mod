package swannick.minecraft.mod.thespookmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import swannick.minecraft.mod.thespookmod.network.CustomC2SPacket;
import swannick.minecraft.mod.thespookmod.network.CustomS2CPacket;

public class TheSpookModPacketHandler {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id(){
        return packetId++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(TheSpookMod.MODID,"messages"))
                .networkProtocolVersion(()->"1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s-> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(CustomC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(CustomC2SPacket::new)
                .encoder(CustomC2SPacket::toBytes)
                .consumerMainThread(CustomC2SPacket::handle)
                .add();

        net.messageBuilder(CustomS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(CustomS2CPacket::new)
                .encoder(CustomS2CPacket::toBytes)
                .consumerMainThread(CustomS2CPacket::handle)
                .add();

    }

    public  static <MSG> void sendToServer(MSG message) {

        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),message);
    }

}
