package com.github.l1an.yuillustrationadapter.entries.event

import com.github.l1an.yuillustration.api.event.CategoryCompleteEvent
import me.gabber235.typewriter.adapters.Colors
import me.gabber235.typewriter.adapters.Entry
import me.gabber235.typewriter.adapters.modifiers.Help
import me.gabber235.typewriter.entry.EntryListener
import me.gabber235.typewriter.entry.Query
import me.gabber235.typewriter.utils.Icons
import me.gabber235.typewriter.entry.entries.EventEntry
import me.gabber235.typewriter.entry.triggerAllFor

@Entry("on_category_complete", "When a player completed a category", Colors.YELLOW, Icons.CIRCLE_CHECK)
class CategoryCompleteEventEntry(
    override val id: String = "",
    override val name: String = "",
    override val triggers: List<String> = emptyList(),
    @Help("When this category complete, it will be triggered.")
    val category: String = ""
) : EventEntry

@EntryListener(CategoryCompleteEventEntry::class)
fun onCategoryComplete(e: CategoryCompleteEvent,query: Query<CategoryCompleteEventEntry>) {
    val player = e.player
    query findWhere { it.category == e.category.key } triggerAllFor player
}