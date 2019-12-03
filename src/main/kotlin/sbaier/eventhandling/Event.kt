package sbaier.eventhandling

open class Event<TArgs>
{
    private val _listeners: MutableList<(TArgs)->Unit> = mutableListOf()
    val listenerCount: Int get(){return _listeners.count()}

    operator fun plusAssign(listenerToAdd: (TArgs)->Unit)
    {
        if(_listeners.contains(listenerToAdd))
            throw IllegalArgumentException("Failed to add $listenerToAdd. " +
                    "The event listener has already been added.")
        _listeners.add(listenerToAdd);
    }

    operator fun minusAssign(listenerToRemove: (TArgs)->Unit)
    {
        if(!_listeners.contains(listenerToRemove))
            throw IllegalArgumentException("Failed to remove $listenerToRemove. " +
                    "The event listener has not been added before.")
        _listeners.remove(listenerToRemove);
    }

    operator fun invoke(args: TArgs)
    {
        for(listener in _listeners)
            listener(args)
    }

    fun isListening(listenerToCheck: (TArgs)->Unit): Boolean
    {
        return _listeners.contains(listenerToCheck)
    }
}

