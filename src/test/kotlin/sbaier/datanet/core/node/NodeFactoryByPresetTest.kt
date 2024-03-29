package sbaier.datanet.core.node

import java.lang.IllegalArgumentException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NodeFactoryByPresetTest
{
    private val _namePropertyName = "PropName"
    private val _nameValue = "Label"
    private val _presetName = "Preset"
    private lateinit var _validPreset: NodePreset
    private lateinit var _missingArgsPreset: NodePreset
    private lateinit var _invalidArgsPreset: NodePreset
    private lateinit var _nodeFactory: NodeFactoryByPreset

    @BeforeTest
    fun setup()
    {
        _validPreset = createValidNodePreset()
        _missingArgsPreset = createMissingArgsNodePreset()
        _invalidArgsPreset = createInvalidArgsNodePreset()
        _nodeFactory = NodeFactoryByPresetAssembler().assemble()
    }

    private fun createValidNodePreset(): NodePreset
    {
        val validArgs: NodeComponentConstructArgs = LabelComponentConstructArgs(_namePropertyName, _nameValue)
        return NodePreset(_presetName, listOf(NodeComponentType.Label), hashMapOf(NodeComponentType.Label to validArgs))
    }

    private fun createMissingArgsNodePreset(): NodePreset
    {
        return NodePreset(_presetName, listOf(NodeComponentType.Label), hashMapOf())
    }

    private fun createInvalidArgsNodePreset(): NodePreset
    {
        val invalidArgs: NodeComponentConstructArgs = UnsetComponentConstructArgs()
        return NodePreset(_presetName, listOf(NodeComponentType.Label), hashMapOf(NodeComponentType.Label to invalidArgs))
    }

    @Test
    fun create_outputEqualsInput()
    {
        val node = _nodeFactory.create(_validPreset)
        val component: LabelComponent = node.get(NodeComponentType.Label).first() as LabelComponent
        assertEquals(component.type, NodeComponentType.Label)
        assertEquals(component.namePropertyName, _namePropertyName)
        assertEquals(component.nameValue, _nameValue)
    }

    @Test
    fun create_missingArgsThrowsException()
    {
        assertFailsWith<IllegalArgumentException> {  _nodeFactory.create(_missingArgsPreset) }
    }

    @Test
    fun create_wrongArgsThrowsException() {
        assertFailsWith<IllegalArgumentException> {  _nodeFactory.create(_invalidArgsPreset) }
    }
}