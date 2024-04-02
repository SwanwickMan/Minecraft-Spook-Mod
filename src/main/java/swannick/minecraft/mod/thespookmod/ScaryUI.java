package swannick.minecraft.mod.thespookmod;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Date;

public class ScaryUI {
    private static final ResourceLocation SPOOKY = new ResourceLocation(TheSpookMod.MODID,
            "textures/ui/spooky.png");
    private static final ResourceLocation QUIRES = new ResourceLocation(TheSpookMod.MODID,
            "textures/ui/quierespart.png");
    public static long startTime = 0;
    public static final int screamLength = 4000;
    public static final int fagLength = 3000;

    public static final IGuiOverlay SPOOKY_UI = ((gui, poseStack, parialTick, width, height) -> {
        int x = width/2;
        int y = height/2;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,SPOOKY);

        Date d = new Date();
        long currTime = d.getTime();
        long countdown = currTime - startTime;


        if (countdown <= screamLength+fagLength && countdown > 0) {
            GuiComponent.blit(poseStack, 0, 0, 0, 0, 0, width, height, width, height);
            countdown--;
            if (countdown >= fagLength){
                RenderSystem.setShaderTexture(0,QUIRES);
                GuiComponent.blit(poseStack, 0, 0, 0, 0, 0, width, height, width, height);
            }
        }
    });

}
