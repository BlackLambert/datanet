package sbaier.datanet.core.node

import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LabelComponentFactoryTest
{
    private val _labelPropertyName = "Prop"
    private val _labelValue = "Label"
    private lateinit var _labelComponentFactory: LabelComponentFactory
    private lateinit var _constructArgs: LabelComponentConstructArgs

    @BeforeTest
    fun setup()
    {
        _labelComponentFactory = LabelComponentFactory()
        _constructArgs = LabelComponentConstructArgs(_labelPropertyName, _labelValue)
    }

    @Test
    fun create_OutputEqualsInput()
    {
        val iD = UUID.randomUUID()
        val component = _labelComponentFactory.create(iD, _constructArgs)
        assertEquals(component.type, NodeComponentType.Label)
        assertEquals(component.iD, iD)
        assertEquals(component.nameValue, _constructArgs.defaultName)
        assertEquals(component.namePropertyName, _constructArgs.namePropertyName)
    }
}