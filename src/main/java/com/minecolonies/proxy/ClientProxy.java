package com.minecolonies.proxy;

import com.github.lunatrius.schematica.client.events.ChatEventHandler;
import com.github.lunatrius.schematica.client.events.KeyInputHandler;
import com.github.lunatrius.schematica.client.events.TickHandler;
import com.github.lunatrius.schematica.client.renderer.RendererSchematicGlobal;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    private RendererSchematicGlobal rendererSchematicGlobal;

    @Override
    public void registerKeybindings()
    {
        for(KeyBinding keyBinding : KeyInputHandler.KEY_BINDINGS)
        {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }

    @Override
    public void registerEvents()
    {
        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
        FMLCommonHandler.instance().bus().register(new TickHandler());

        this.rendererSchematicGlobal = new RendererSchematicGlobal();
        MinecraftForge.EVENT_BUS.register(this.rendererSchematicGlobal);
        MinecraftForge.EVENT_BUS.register(new ChatEventHandler());
    }

}
