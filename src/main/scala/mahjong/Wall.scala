package mahjong

trait Wall {
  def shuffle()
  def deal()
}

class RichiiWall extends Wall {
  def shuffle = {}
  def deal = {}
}

object Wall {
  def apply(variant:Variant): Wall = variant match {
    case Variant.Richii =>  new RichiiWall()
  }
}