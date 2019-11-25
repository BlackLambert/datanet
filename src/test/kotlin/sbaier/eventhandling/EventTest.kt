package sbaier.eventhandling

import java.lang.IllegalArgumentException
import kotlin.test.*

class EventTest
{
    lateinit var event: Event<String>
    lateinit var defaultListener: (String) -> Unit

    @BeforeTest
    fun setup()
    {
        event = Event()
        defaultListener = { name: String -> println("The name is $name")}
    }


    @Test
    fun isListening_returnsCorrectValue()
    {
        assertFalse(event.isListening(defaultListener))
        event += defaultListener
        assertTrue(event.isListening(defaultListener))
    }

    @Test
    fun plusAssign_listenerAddedToEvent()
    {
        event += defaultListener
        assertTrue(event.isListening(defaultListener))
    }

    @Test
    fun plusAssign_DoubleAddOfSameListenerThrowsException()
    {
        event += defaultListener
        assertFailsWith<IllegalArgumentException> { event += defaultListener }
    }

    @Test
    fun minusAssign_listenerRemovedFromEvent()
    {
        event += defaultListener
        assertTrue(event.isListening(defaultListener))
        event -= defaultListener
        assertFalse(event.isListening(defaultListener))
    }

    @Test
    fun minusAssign_RemovingNonAddedListenerThrowsException()
    {
        assertFailsWith<IllegalArgumentException> { event -= defaultListener }
    }

    @Test
    fun invoke_CallsAllListeners()
    {
        var counter = 0
        val argument = "Sam"
        val listeners: List<(String) -> Unit> = listOf (
                {_: String -> counter += 1 },
                {_: String -> counter += 1 },
                {_: String -> counter += 1 })
        for(listener in listeners)
            event += listener
        event(argument)
        assertEquals(counter, event.listenerCount)
    }

    @Test
    fun invoke_ArgumentsIdenticalForAllListeners()
    {
        val argument = "Sam"
        var isSameName = true
        val listeners: List<(String) -> Unit> = listOf (
                {name: String -> isSameName = isSameName && name == argument},
                {name: String -> isSameName = isSameName && name == argument},
                {name: String -> isSameName = isSameName && name == argument})
        for(listener in listeners)
            event += listener
        event(argument)
        assertTrue(isSameName)
    }
}