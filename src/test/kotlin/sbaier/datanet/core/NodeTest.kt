package sbaier.datanet.core

import sbaier.eventhandling.CollectionChangeType
import sbaier.eventhandling.CollectionChangedEventArgs
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.test.*

class NodeTest
{
    private lateinit var _firstComponent: NodeComponent
    private lateinit var _componentOfSameType: NodeComponent
    private lateinit var _node: Node

    @BeforeTest
    fun setup()
    {
        _firstComponent = createNameComponent()
        _componentOfSameType = createNameComponent()
        _node = createNode()
    }

    @Test
    fun add_doubleAddThrowsException()
    {
        _node.add(_firstComponent)
        assertFailsWith<IllegalArgumentException> { _node.add(_firstComponent) }
    }

    @Test
    fun add_collectionChangedEventArgsCorrect() {
        var args: CollectionChangedEventArgs<Node, NodeComponent>? = null
        val listener: (args: CollectionChangedEventArgs<Node, NodeComponent>) -> Unit =
                {a: CollectionChangedEventArgs<Node, NodeComponent> -> args = a}
        _node.componentsChangedEvent += listener
        _node.add(_firstComponent)
        assertNotNull(args)
        assertEquals(args?.changeType, CollectionChangeType.Added)
        assertTrue(args?.changedCollection!!.contains(_firstComponent))
        assertTrue(args?.involvedElements!!.contains(_firstComponent))
        _node.componentsChangedEvent -= listener
    }

    @Test
    fun add_get_getPossibleAfterAdd()
    {
        _node.add(_firstComponent)
        assertSame( _node.get(_firstComponent.type).first(), _firstComponent)
    }

    @Test
    fun add_get_getReturnsTwoComponents()
    {
        _node.add(_firstComponent)
        _node.add(_componentOfSameType)
        assertTrue(_node.get(_firstComponent.type).count() == 2)
    }

    @Test
    fun get_returnsEmptyListIfTypeNotContained()
    {
        assertTrue(_node.get(_firstComponent.type).isEmpty())
    }

    @Test
    fun remove_removesCorrectElement()
    {
        _node.add(_firstComponent)
        _node.add(_componentOfSameType)
        _node.remove(_firstComponent)
        assertSame(_node.get(_componentOfSameType.type).first(), _componentOfSameType)
    }

    @Test
    fun remove_throwsErrorIfElementNotContained()
    {
        assertFailsWith<IllegalArgumentException> { _node.remove(_firstComponent) }
    }

    @Test
    fun remove_collectionChangedEventArgsCorrect()
    {
        _node.add(_firstComponent)
        var args: CollectionChangedEventArgs<Node, NodeComponent>? = null
        val listener: (args: CollectionChangedEventArgs<Node, NodeComponent>) -> Unit =
                {a: CollectionChangedEventArgs<Node, NodeComponent> -> args = a}
        _node.componentsChangedEvent += listener
        _node.remove(_firstComponent)
        assertNotNull(args)
        assertEquals(args?.changeType, CollectionChangeType.Removed)
        assertFalse(args?.changedCollection!!.contains(_firstComponent))
        assertTrue(args?.involvedElements!!.contains(_firstComponent))
        _node.componentsChangedEvent -= listener
    }

    @Test
    fun add_remove_get_returnsEmptyCollection()
    {
        _node.add(_firstComponent)
        _node.remove(_firstComponent)
        assertTrue(_node.get(_firstComponent.type).isEmpty())
    }

    private fun createNameComponent(): NameComponent
    {
        return NameComponent(UUID.randomUUID(),"Prop", "Name")
    }

    private fun createNode():Node
    {
        return Node(UUID.randomUUID())
    }
}