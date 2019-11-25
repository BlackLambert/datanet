package sbaier.eventhandling

data class PropertyChangedEventArgs<TClass, TValue>(val changedObject: TClass, val formerValue: TValue,
                                                    val newValue: TValue)