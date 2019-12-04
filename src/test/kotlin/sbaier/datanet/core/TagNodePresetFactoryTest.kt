package sbaier.datanet.core

import kotlin.test.BeforeTest
import kotlin.test.Test

class TagNodePresetFactoryTest
{
    private lateinit var _factory: TagNodePresetFactory

    @BeforeTest
    fun setup()
    {
        _factory = TagNodePresetFactory()
    }

    @Test
    fun create_correctComponentTypes()
    {
        val preset = _factory.create()
        assert(preset.componentTypes.contains(NodeComponentType.Name))
    }

    @Test
    fun create_argsForAllTypes()
    {
        val preset = _factory.create()
        assert(preset.componentConstructArgs.containsKey(NodeComponentType.Name))
    }
}