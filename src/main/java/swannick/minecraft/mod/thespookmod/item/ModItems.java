package swannick.minecraft.mod.thespookmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import swannick.minecraft.mod.thespookmod.TheSpookMod;

public class ModItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, TheSpookMod.MODID);
    public static void register(IEventBus eventBus){
        Items.register(eventBus);
    }
    public static final RegistryObject<Item> SPOOKSPAWNEGG = Items.register("spook_spawn_egg",() -> new TheSpookSpawnEgg(new Item.Properties().tab(
            CreativeModeTab.TAB_MISC).stacksTo(1)));
}
