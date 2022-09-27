package dev.willebrands.intellij.sloppyfocus.filters

import java.awt.Component
import java.util.function.Predicate

typealias ComponentFilter = Predicate<Component>

fun ComponentFilter.andAnyOf(vararg filters: ComponentFilter): ComponentFilter {
    return and(filters.reduce { acc, predicate -> acc.or(predicate) })
}