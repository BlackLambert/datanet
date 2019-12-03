package sbaier.datanet.core

import java.util.*

class NameComponent(iD: UUID, type: NodeComponentType, initialValue: String) : NodeComponent(iD, type)
{
    var value: String = initialValue
}