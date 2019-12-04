package sbaier.datanet.core.node

import sbaier.datanet.core.node.NodeComponentConstructArgs
import sbaier.datanet.core.node.NodeComponentType

class NodePresetConstructArgs(val name: String,
                              val componentTypes: List<NodeComponentType>,
                              val componentArgs: HashMap<NodeComponentType, NodeComponentConstructArgs>)
{

}