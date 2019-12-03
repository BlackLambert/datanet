package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*

class DummyNodeComponentFactory(private val _iDGenerator: UUIDGenerator) : NodeComponentFactory()
{
    override fun create(type: NodeComponentType): NodeComponent {
        when(type)
        {
            NodeComponentType.Name -> return NameComponent(createID(), type, "DummyComponent")
            NodeComponentType.Unset -> throw IllegalArgumentException(
                    "Creating a component of default type $type is not possible}")
            else -> throw NotImplementedError("The component type '$type' has no been implemented")
        }
    }

    private fun createID(): UUID
    {
        return _iDGenerator.create()
    }
}