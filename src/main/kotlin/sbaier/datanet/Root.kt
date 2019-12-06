package sbaier.datanet

import java.nio.file.Path

interface Root
{
    val completePath: Path
    val subPath: Path
}