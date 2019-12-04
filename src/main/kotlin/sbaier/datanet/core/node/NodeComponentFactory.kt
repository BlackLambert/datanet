package sbaier.datanet.core.node

import sbaier.identification.UUIDGenerator

class NodeComponentFactory(private val _iDGenerator: UUIDGenerator,
                           private val _labelComponentFactory: LabelComponentFactory)
{
    fun create(constructArgs: NodeComponentConstructArgs): NodeComponent
    {
        val iD = _iDGenerator.create()
        when (constructArgs.type)
        {
            NodeComponentType.Name -> return _labelComponentFactory.create(iD,
                    constructArgs as LabelComponentConstructArgs)
            NodeComponentType.Unset -> throw IllegalArgumentException(
                    "Creating a component of default type ${constructArgs.type} is not possible}")
            else -> throw NotImplementedError("Failed to create Node Component of type '${constructArgs.type}'. " +
                    "It has not been implemented yet.")
        }
    }
}