package sbaier.eventhandling

class CollectionChangedEventArgs<TClass, TArg> (val changedClass: TClass,
                                                val changedCollection: Collection<TArg>,
                                                val changeType: CollectionChangeType,
                                                val involvedElements: Collection<TArg>)
{
}