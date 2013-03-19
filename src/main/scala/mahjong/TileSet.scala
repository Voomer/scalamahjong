package mahjong

sealed trait TileSet

sealed case class Four(tiles:List[Tile]) extends TileSet
sealed case class Three(tiles:List[Tile]) extends TileSet
sealed case class Straight(tiles:List[Tile]) extends TileSet
sealed case class Pair(tiles:List[Tile]) extends TileSet
sealed case class Incomplete() extends TileSet
