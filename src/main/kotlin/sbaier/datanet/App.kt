/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sbaier.datanet

import sbaier.datanet.core.node.Node
import java.util.UUID

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
    val node: Node
        get()
        {
            return Node(UUID.randomUUID())
        }
}

fun main(args: Array<String>) {
    val app = App()
    println(app.greeting)
    println(app.node.iD)
}
