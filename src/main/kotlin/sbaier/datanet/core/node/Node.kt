package sbaier.datanet.core.node

import sbaier.eventhandling.CollectionChangeType
import sbaier.eventhandling.CollectionChangedEvent
import sbaier.eventhandling.CollectionChangedEventArgs
import java.util.UUID

open class Node(val iD:UUID, val type: String = "Custom")
{
    private val _components: MutableSet<NodeComponent> = mutableSetOf()
    private  val _immutableComponents: Set<NodeComponent>
        get() {return _components}
    val componentsCount: Int
        get() {return _components.count()}
    val componentsChangedEvent: CollectionChangedEvent<Node, NodeComponent> = CollectionChangedEvent()

    fun add(component: NodeComponent)
    {
        if(_components.contains(component))
            throw IllegalArgumentException("Failed to add component '$component'. " +
                    "It has already been added to this node")
        _components.add(component)
        val args = CollectionChangedEventArgs(this, _immutableComponents, CollectionChangeType.Added,
                listOf(component))
        componentsChangedEvent(args)
    }

    fun get(type: NodeComponentType): Collection<NodeComponent>
    {
        val result: MutableList<NodeComponent> = mutableListOf()
        result.addAll( _components.filter() { it.type == type })
        return result
    }

    fun remove(component: NodeComponent)
    {
        if(!_components.contains(component))
            throw java.lang.IllegalArgumentException("Failed to remove component '$component'. " +
                    "It has not been added to this node.")
        _components.remove(component)
        val args = CollectionChangedEventArgs(this, _immutableComponents, CollectionChangeType.Removed,
                listOf(component))
        componentsChangedEvent(args)
    }
}