package sbaier.datanet.core.node

import java.util.*

class LabelComponent(iD: UUID,
                     initialName: String,
                     val namePropertyName: String) : NodeComponent(iD, NodeComponentType.Label)
{
    var nameValue: String = initialName
}