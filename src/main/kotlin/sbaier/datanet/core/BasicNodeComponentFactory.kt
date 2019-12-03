package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class BasicNodeComponentFactory (private val _iDGenerator: UUIDGenerator,
                                 private val _nameComponentFactory: NameComponentFactory) : NodeComponentFactory()
{
    override fun create(type: NodeComponentType): NodeComponent
    {
        val iD = _iDGenerator.create()
        when(type)
        {
            NodeComponentType.Name -> return _nameComponentFactory.create(iD)
            NodeComponentType.Unset -> throw IllegalArgumentException(
                    "Creating a component of default type $type is not possible}")
            else -> throw NotImplementedError("Failed to create Node Component of type '$type'. " +
                    "It has not been implemented yet.")
        }
    }
}