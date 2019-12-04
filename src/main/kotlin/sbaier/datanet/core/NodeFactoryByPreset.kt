package sbaier.datanet.core

class NodeFactoryByPreset(private val nodeFactory: NodeFactory,
                          private val nodeComponentFactory: NodeComponentFactory)
{
    fun create(preset: NodePreset): Node
    {
        val result = nodeFactory.create(preset.name)
        for (componentType in preset.componentTypes)
        {
            if (!preset.componentConstructArgs.containsKey(componentType))
                throw IllegalArgumentException("Failed to create NodeComponent of type $componentType. " +
                        "No Construction Arguments were provided.")
            val componentArgs = preset.componentConstructArgs[componentType]
            if (componentArgs?.type != componentType)
                throw java.lang.IllegalArgumentException("Failed to create NodeComponent of type $componentType. " +
                        "The type of the construction arguments mismatch the requested type")
            val nodeComponent = nodeComponentFactory.create(componentArgs)
            result.add(nodeComponent)
        }
        return result
    }
}