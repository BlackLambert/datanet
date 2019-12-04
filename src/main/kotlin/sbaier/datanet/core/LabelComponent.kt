package sbaier.datanet.core

import java.util.*

class LabelComponent(iD: UUID,
                     initialName: String,
                     val namePropertyName: String) : NodeComponent(iD, NodeComponentType.Name)
{
    var nameValue: String = initialName
}