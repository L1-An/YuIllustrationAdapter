package com.github.l1an.yuillustrationadapter.entries.event

import com.github.l1an.yuillustration.api.event.EntryUnlockEvent
import me.gabber235.typewriter.adapters.Colors
import me.gabber235.typewriter.adapters.Entry
import me.gabber235.typewriter.adapters.modifiers.Help
import me.gabber235.typewriter.entry.EntryListener
import me.gabber235.typewriter.entry.Query
import me.gabber235.typewriter.entry.entries.EventEntry
import me.gabber235.typewriter.entry.triggerAllFor
import me.gabber235.typewriter.utils.Icons

@Entry("on_unlock_entry", "When a player unlocked a entry", Colors.YELLOW, Icons.LOCK_OPEN)
class EntryUnlockEventEntry(
    override val id: String = "",
    override val name: String = "",
    override val triggers: List<String> = emptyList(),
    @Help("The category name")
    val category: String = "",
    @Help("The entry name")
    val entry: String = ""
) : EventEntry

@EntryListener(EntryUnlockEventEntry::class)
fun onEntryUnlock(e : EntryUnlockEvent, query: Query<EntryUnlockEventEntry>) {
    val player = e.player
    query findWhere { it.category == e.entry.category && it.entry == e.entry.key } triggerAllFor player
}