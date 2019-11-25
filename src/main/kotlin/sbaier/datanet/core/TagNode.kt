package sbaier.datanet.core

import sbaier.eventhandling.PropertyChangedEvent
import sbaier.eventhandling.PropertyChangedEventArgs
import java.util.UUID

class TagNode(name:String, iD: UUID): Node(iD)
{
    private var _name: String = name
    var name: String
        get() = _name
        set(value)
        {
            val formerValue = _name
            _name = value
            onNameChanged(PropertyChangedEventArgs(this, formerValue, _name))
        }

    var onNameChanged: PropertyChangedEvent<TagNode, String> = PropertyChangedEvent()
}