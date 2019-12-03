package sbaier.datanet.core

class NodePreset (val name: String,
                  val componentTypes: List<NodeComponentType>,
                  val componentConstructArgs: HashMap<NodeComponentType, NodeComponentConstructArgs>)
{
}