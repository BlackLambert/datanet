package sbaier.datanet.core

import java.util.*

class NameComponent(iD: UUID,
                    initialName: String,
                    val namePropertyName: String) : NodeComponent(iD, NodeComponentType.Name)
{
    var nameValue: String = initialName
}