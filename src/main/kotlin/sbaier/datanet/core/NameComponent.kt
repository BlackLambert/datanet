package sbaier.datanet.core

import java.util.*

class NameComponent(iD: UUID,
                    type: NodeComponentType,
                    initialName: String,
                    val namePropertyName: String) : NodeComponent(iD, type)
{
    var nameValue: String = initialName
}