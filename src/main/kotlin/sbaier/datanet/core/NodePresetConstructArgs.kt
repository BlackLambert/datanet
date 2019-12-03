package sbaier.datanet.core

class NodePresetConstructArgs(val name: String,
                              val componentTypes: List<NodeComponentType>,
                              val componentArgs: HashMap<NodeComponentType, NodeComponentConstructArgs>)
{

}