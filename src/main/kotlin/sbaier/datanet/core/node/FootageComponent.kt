package sbaier.datanet.core.node

import sbaier.eventhandling.PropertyChangedEvent
import sbaier.eventhandling.PropertyChangedEventArgs
import java.util.*

class FootageComponent(iD: UUID, initialContentID: UUID? = null): NodeComponent(iD, NodeComponentType.Footage)
{
    private var _footageID = initialContentID
    val onFootageIDChanged = PropertyChangedEvent<FootageComponent, UUID?>()
    var footageID: UUID?
    get()
    {
        return _footageID
    }
    set(value)
    {
        val former = _footageID
        _footageID = value
        onFootageIDChanged.invoke(PropertyChangedEventArgs(this, former, _footageID))
    }


}