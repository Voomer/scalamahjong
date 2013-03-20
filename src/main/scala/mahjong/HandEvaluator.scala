package mahjong

object HandEvaluator {
  
	
	def ShantenMethod1(tiles:List[Tile]):Int= {
	  var bin = Array[Int](36)
	  tiles foreach (t => bin(TileConvert(t)) += 1)
	  return 1+ 1
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
	
	object TileConvert{
	  lazy val tileToInt = {
	    val tiles = Hand("1b 2b 3b 4b 5b 6b 7b 8b 9b 1c 2c 3c 4c 5c 6c 7c 8c 9c 1d 2d 3d 4d 5d 6d 7d 8d 9d w e s n r g b");
	    val nums = 0 to 35
	    tiles.zip(nums).toMap
	  }
	  
	  lazy val intToTile = tileToInt map {_.swap}
	  
	  def apply(tile:Tile):Int = {
		  tileToInt(tile)
	  }
	  
	  def apply(int:Int):Tile = {
		  intToTile(int)
	  } 
	}
}