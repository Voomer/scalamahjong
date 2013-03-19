package mahjong

sealed abstract class Variant(val id: Int) {

  lazy val name = toString.toLowerCase

  def standard = this == Variant.Richii

}

object Variant {

  case object Richii extends Variant(id = 1) {

    
  }
  
  val all = List(Richii)
  val byId = all map { v => (v.id, v) } toMap
  val byName = all map { v => (v.name, v) } toMap
  val default = Richii
  def apply(id: Int): Option[Variant] = byId get id
  def apply(name: String): Option[Variant] = byName get name.toLowerCase
  def exists(id: Int): Boolean = byId contains id


}