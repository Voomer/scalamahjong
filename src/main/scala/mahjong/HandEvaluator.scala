package mahjong

object HandEvaluator {
  
	lazy val map = Map(1->"one",
	    3->"two",
	    4->"two")
  
	def ShantenMethod1(tiles:List[Tile]):Int= {
	  val remainingTiles = removePairSets(removeThreeSets(tiles))
	  remainingTiles.length
	}

	
	def isSame(tiles:List[Tile]):Boolean = tiles.forall(p => tiles(0) == p)
			  
	def isSequence(tiles:List[Tile]):Boolean = tiles match {
	   case List(a:SuitTile, b:SuitTile, c:SuitTile) if a.name == b.name == c.name =>
	     a.rank+2 == b.rank+1 == c.rank
	   case _ => false
	}
	
	
	def removeThreeSets(tiles:List[Tile]):List[Tile] = {
	  var count = 0
	  var mutList = tiles
	  while (count+2 <= mutList.length) {
	    if (isSame(mutList.slice(count, count+3))) {
	        mutList = mutList drop 3
	        count += 3
	    }
	    else if (isSequence(mutList.slice(count, count+3))) {
	    	mutList = mutList drop 3
	        count += 3
	    }
	    else
	      count += 1
	      mutList = mutList drop 1
	  }
	  mutList
	}
	
	def removePairSets(tiles:List[Tile]):List[Tile] = {
	  var count = 0
	  var mutList = tiles
	  while (count+1 <= mutList.length) {
	    if (isSame(mutList.slice(count, count+2))) {
	        mutList = mutList drop 2
	        count += 2
	    }
	  }
	  mutList
	}
}