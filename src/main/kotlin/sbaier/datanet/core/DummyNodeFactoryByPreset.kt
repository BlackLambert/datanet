package sbaier.datanet.core

class DummyNodeFactoryByPreset: NodeFactoryByPreset()
{
    private val nodeFactory: NodeFactory = DummyNodeFactory()
    private val nodeComponentFactory: NodeComponentFactory = DummyNodeComponentFactory()


    override fun create(preset: NodePreset): Node
    {
        val result = nodeFactory.create()
        for(type in preset.componentTypes)
        {
            val component = preset.componentConstructArgs[type]?.let { nodeComponentFactory.create(it) }
            component?.let { result.add(it) }
        }
        return result
    }

}