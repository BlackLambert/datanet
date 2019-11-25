package sbaier.datanet.core

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotSame
import kotlin.test.assertSame

class BasicTagNodeFactoryTest
{
    private val _defaultTagName = "Default"
    private val _inputTagName = "Peter"
    private lateinit var factoryWithCustomDefaultName: TagNodeFactory
    private lateinit var defaultFactory: TagNodeFactory

    @BeforeTest
    fun setup()
    {
        factoryWithCustomDefaultName = BasicTagNodeFactory(_defaultTagName)
        defaultFactory = BasicTagNodeFactory()
    }

    @Test
    fun create_defaultNamesUnique()
    {
        val nodes: MutableList<TagNode> = mutableListOf()
        nodes.add(factoryWithCustomDefaultName.create())
        nodes.add(factoryWithCustomDefaultName.create())
        nodes.add(defaultFactory.create())
        nodes.add(defaultFactory.create())
        for(node in nodes)
        {
            for(compareNode in nodes)
            {
                if(node == compareNode)
                    continue
                assertNotSame(node.name, compareNode.name)
            }
        }
    }

    @Test
    fun create_nameEqualsInput()
    {
        val first = factoryWithCustomDefaultName.create(_inputTagName)
        assertSame(first.name, _inputTagName)
        val second = defaultFactory.create(_inputTagName)
        assertSame(second.name, _inputTagName)
    }


}