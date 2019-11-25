package sbaier.datanet.core

import sbaier.eventhandling.PropertyChangedEventArgs
import kotlin.test.*

class TagNodeTest
{
    private val _defaultName = "Peter"
    private val _formerName = "Heinz"
    private val _newName = "Klaus"
    private lateinit var tagNode: TagNode

    @BeforeTest
    fun setup()
    {
        val factory = DummyTagNodeFactory()
        tagNode = factory.create(_formerName)
    }


    @Test
    fun onNameChanged_ListenerCalled()
    {
        var name = _defaultName
        assertNotSame(name, tagNode.name)
        tagNode.onNameChanged += {args: PropertyChangedEventArgs<TagNode, String> -> name = args.newValue}
        tagNode.name = _newName
        assertNotSame(name, _defaultName)
    }

    @Test
    fun onNameChanged_FormerAndNewValueCorrect()
    {
        tagNode.name = _formerName
        var formerName = ""
        var newName = ""
        tagNode.onNameChanged += {args: PropertyChangedEventArgs<TagNode, String> -> kotlin.run {
            formerName = args.formerValue
            newName = args.newValue
        }}
        tagNode.name = _newName
        assertSame(newName, tagNode.name)
        assertSame(newName, _newName)
        assertSame(formerName, _formerName)
    }
}