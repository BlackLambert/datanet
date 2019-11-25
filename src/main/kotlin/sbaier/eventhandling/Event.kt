package sbaier.eventhandling

open class Event<TArgs>
{
    private val listeners: MutableList<(TArgs)->Unit> = mutableListOf()
    val listenerCount: Int get(){return listeners.count()}

    operator fun plusAssign(listenerToAdd: (TArgs)->Unit)
    {
        if(listeners.contains(listenerToAdd))
            throw IllegalArgumentException("Failed to add $listenerToAdd. " +
                    "The event listener has already been added.")
        listeners.add(listenerToAdd);
    }

    operator fun minusAssign(listenerToRemove: (TArgs)->Unit)
    {
        if(!listeners.contains(listenerToRemove))
            throw IllegalArgumentException("Failed to remove $listenerToRemove. " +
                    "The event listener has not been added before.")
        listeners.remove(listenerToRemove);
    }

    operator fun invoke(args: TArgs)
    {
        for(listener in listeners)
            listener(args)
    }

    fun isListening(listenerToCheck: (TArgs)->Unit): Boolean
    {
        return listeners.contains(listenerToCheck)
    }
}
