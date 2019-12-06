package sbaier.datanet.core.net

import sbaier.datanet.core.node.Node
import sbaier.identification.UUIDGenerator
import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import kotlin.test.Test
import kotlin.test.assertSame
import kotlin.test.BeforeTest
import kotlin.test.assertFailsWith

class DataNetFactoryTest
{
    private lateinit var _nodes: List<Node>
    private lateinit var _factory: DataNetFactory
    private lateinit var _correctNetPath: Path
    private lateinit var _invalidPath: Path
    private lateinit var _filePath: Path

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        _correctNetPath = Paths.get("").toAbsolutePath()
        _invalidPath = File("Bla/Bli\\B.lubb.png").toPath()
        _filePath = File("./DataNetFactoryTest.kt").toPath()
        _nodes = listOf(createNode(), createNode(), createNode())
        _factory = DataNetFactory(iDGenerator)
    }

    @Test
    fun create_NetContainsAddedNotes()
    {
        val net = _factory.create(_correctNetPath, _nodes)
        for(node in _nodes)
        {
            assertSame(net.get(node.iD), node)
        }
    }

    @Test
    fun create_WrongPathThrowsException()
    {
        assertFailsWith<IllegalArgumentException> { _factory.create(_invalidPath, _nodes) }
        assertFailsWith<IllegalArgumentException> { _factory.create(_filePath, _nodes) }
        assertFailsWith<IllegalArgumentException> { _factory.create(_invalidPath) }
        assertFailsWith<IllegalArgumentException> { _factory.create(_filePath) }
    }

    private fun createNode(): Node
    {
        return Node(UUID.randomUUID())
    }
}