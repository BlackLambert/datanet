package sbaier.datanet.core.node

import sbaier.eventhandling.PropertyChangedEventArgs
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class FootageComponentTest
{
    private lateinit var _component: FootageComponent
    private lateinit var _iDToSet: UUID
    private lateinit var _initialFootageID: UUID

    @BeforeTest
    fun setup()
    {
        _initialFootageID = UUID.randomUUID()
        _component = FootageComponent(UUID.randomUUID(), _initialFootageID)
        _iDToSet = UUID.randomUUID()
    }

    @Test
    fun contentID_get_ReturnsCorrectID()
    {
        assertEquals(_component.footageID, _initialFootageID)
    }

    @Test
    fun contentID_set_SetsTheCorrectID()
    {
        assertNotEquals(_initialFootageID, _iDToSet)
        _component.footageID = _iDToSet
        assertEquals(_component.footageID, _iDToSet)
    }

    @Test
    fun onContentIDChanged_Correct()
    {
        var args: PropertyChangedEventArgs<FootageComponent, UUID?> =
                PropertyChangedEventArgs(_component, UUID.randomUUID(), UUID.randomUUID())
        val listener = {a: PropertyChangedEventArgs<FootageComponent, UUID?> -> args = a}
        _component.onFootageIDChanged += listener
        _component.footageID = _iDToSet
        assertEquals(args.formerValue, _initialFootageID)
        assertEquals(args.changedObject, _component)
        assertEquals(args.newValue, _iDToSet)
        _component.onFootageIDChanged -= listener
    }
}