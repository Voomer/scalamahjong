package mahjong

object Hand {
	def apply(mgn:String):Seq[Tile] = {
		mgn.split(' ') map { Tile(_) }
	 }
}
