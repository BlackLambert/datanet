package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class DummyNodeComponentFactory() : NodeComponentFactory()
{
    private val _nameComponentFactory: NameComponentFactory = DummyNameComponentFactory()
    private val _iDGenerator: UUIDGenerator = UUIDGenerator()

    override fun create(constructArgs: NodeComponentConstructArgs): NodeComponent
    {
        val iD = _iDGenerator.create()
        when(constructArgs.type)
        {
            NodeComponentType.Name -> return _nameComponentFactory.create(iD, constructArgs as NameComponentConstructArgs)
            NodeComponentType.Unset -> throw IllegalArgumentException(
                    "Creating a component of default type ${constructArgs.type} is not possible}")
            else -> throw NotImplementedError("The component type '${constructArgs.type}' has no been implemented")
        }
    }
}