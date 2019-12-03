package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class DummyNodeComponentFactory() : NodeComponentFactory()
{
    private val _nameComponentFactory: NameComponentFactory = DummyNameComponentFactory()
    private val _iDGenerator: UUIDGenerator = UUIDGenerator()

    override fun create(type: NodeComponentType): NodeComponent
    {
        val iD = _iDGenerator.create()
        when(type)
        {
            NodeComponentType.Name -> return _nameComponentFactory.create(iD)
            NodeComponentType.Unset -> throw IllegalArgumentException(
                    "Creating a component of default type $type is not possible}")
            else -> throw NotImplementedError("The component type '$type' has no been implemented")
        }
    }
}