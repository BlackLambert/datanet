package sbaier.datanet.core.node

import sbaier.datanet.core.node.DefaultNodeType
import sbaier.datanet.core.node.NodePresetFactoryByDefault
import sbaier.datanet.core.node.NodePresetFactoryByDefaultAssembler
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NodePresetFactoryByDefaultTest
{
    private lateinit var _nodePresetFactoryByDefault: NodePresetFactoryByDefault

    @BeforeTest
    fun setup()
    {
        _nodePresetFactoryByDefault = NodePresetFactoryByDefaultAssembler().assemble()
    }

    @Test
    fun create_CorrectPresetCreated()
    {
        val preset = _nodePresetFactoryByDefault.create(DefaultNodeType.Tag)
        assertEquals(preset.name, "Tag")
    }

    @Test
    fun create_UnsetThrowsException()
    {
        assertFailsWith<IllegalArgumentException>{_nodePresetFactoryByDefault.create(DefaultNodeType.Unset)}
    }
}