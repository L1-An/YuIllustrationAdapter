package com.github.l1an.yuillustrationadapter

import me.gabber235.typewriter.adapters.Adapter
import me.gabber235.typewriter.adapters.TypewriteAdapter
import me.gabber235.typewriter.logger
import org.bukkit.Bukkit

@Adapter("YuIllustration", "An adapter for YuIllustration.", "1.0.0")
object YuIllustrationAdapter : TypewriteAdapter() {
    override fun initialize() {
        val isHookedYuIllustration by lazy { Bukkit.getPluginManager().getPlugin("YuIllustration") != null }
        if (!isHookedYuIllustration) {
            logger.warning("YuIllustration plugin not found, the adapter has been disabled.")
            return
        }
    }
}