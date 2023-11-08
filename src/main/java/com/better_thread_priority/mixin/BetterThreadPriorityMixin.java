package com.better_thread_priority.mixin;

import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Objects;

@Mixin(MinecraftServer.class)
public class BetterThreadPriorityMixin
{
    @Unique
    private static final Logger LOGGER = LoggerFactory.getLogger("better_thread_priority");

    @Inject(at = @At("RETURN"), method = "loadWorld")
    private void init(CallbackInfo ci)
    {
        Map<Thread, StackTraceElement[]> allThreads = Thread.getAllStackTraces();

        for (Thread thread : allThreads.keySet()) {
            if(Objects.equals(thread.getName(), "Render thread"))
            {
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            else
            {
                thread.setPriority(Thread.MIN_PRIORITY);
            }
        }

        LOGGER.info("成功进入loadWorld函数");
    }
}