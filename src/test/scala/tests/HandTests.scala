package tests

import scala.util.Sorting
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import mahjong.Hand
import mahjong._

class HandTests extends SpecificationWithJUnit  {
	"The mgn" should {
	  "create the tiles" in {
	    val tiles = Hand("1d 2b 3d w e n s b g r")
	    tiles must containAllOf(Seq(SuitTile(1, "dot"), SuitTile(2, "bamboo"), SuitTile(3, "dot"),
	        HonorTile("west"), HonorTile("east"), HonorTile("north"), HonorTile("south"), 
	        HonorTile("blank"), HonorTile("green"), HonorTile("red")))    
	  }
	}
}