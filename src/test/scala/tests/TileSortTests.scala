package tests

import scala.util.Sorting
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import mahjong._

class TileSortTests extends SpecificationWithJUnit  {
	"The Tile collection" should {
	  "be sorted" in {
		   val seq = Seq(HonorTile("green"),SuitTile(1, "bamboo"), HonorTile("red"))
		   var s = seq.sorted(new TileOdering()) 
		   s must contain(SuitTile(1, "bamboo"), HonorTile("green"), HonorTile("red")).inOrder    
	  }
	}
}