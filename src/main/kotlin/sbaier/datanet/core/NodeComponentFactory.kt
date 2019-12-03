package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class NodeComponentFactory(private val _iDGenerator: UUIDGenerator,
                                    private val _nameComponentFactory: NameComponentFactory)
{
    fun create(constructArgs: NodeComponentConstructArgs): NodeComponent
    {
        val iD = _iDGenerator.create()
        when(constructArgs.type)
        {
            NodeComponentType.Name -> return _nameComponentFactory.create(iD,
                    constructArgs as NameComponentConstructArgs)
            NodeComponentType.Unset -> throw IllegalArgumentException(
                    "Creating a component of default type ${constructArgs.type} is not possible}")
            else -> throw NotImplementedError("Failed to create Node Component of type '${constructArgs.type}'. " +
                    "It has not been implemented yet.")
        }
    }
}