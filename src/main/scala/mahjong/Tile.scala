package mahjong

sealed trait Tile {
  val mgn: String 
  val name: String
  lazy val shorthand : Char = name.charAt(0)
 
}

case class HonorTile(name:String) extends Tile {
  val mgn:String = shorthand toString
}

case class SuitTile(rank:Int, name:String) extends Tile {
  val mgn: String = rank.toString + shorthand
}

object Tile {
    def compareTile(a : Tile, b: Tile) : Int = 
	    (a, b) match {
	    case (a : SuitTile, b : HonorTile) => -1
	    case (a: HonorTile, b: SuitTile) => 1
	    case (a:SuitTile, b:SuitTile) if (a.name equals b.name) => a.rank compareTo b.rank
	    case _ => a.name compareTo b.name
    }
    
    def apply(mgn:String):Tile = {
		mgn.toSeq match  {
		    case Seq(a:Char, 'b') => SuitTile(a.toString.toInt, "bamboo")
		    case Seq(a:Char, 'd') => SuitTile(a.toString.toInt, "dot")
		    case Seq(a:Char, 'c') => SuitTile(a.toString.toInt, "character")
		    case Seq('w') => HonorTile("west")
		    case Seq('e') => HonorTile("east")
		    case Seq('s') => HonorTile("south")
		    case Seq('n') => HonorTile("north")
		    case Seq('b') => HonorTile("blank")
		    case Seq('g') => HonorTile("green")
		    case Seq('r') => HonorTile("red")
	  	}
    }
}

class TileOdering extends Ordering[Tile] {
	override def compare(a:Tile, b:Tile) = {
		Tile.compareTile(a, b)
	}
}



