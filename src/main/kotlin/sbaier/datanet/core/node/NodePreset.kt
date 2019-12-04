package sbaier.datanet.core.node

import sbaier.datanet.core.node.NodeComponentConstructArgs
import sbaier.datanet.core.node.NodeComponentType

class NodePreset (val name: String,
                  val componentTypes: List<NodeComponentType>,
                  val componentConstructArgs: HashMap<NodeComponentType, NodeComponentConstructArgs>)
{
}