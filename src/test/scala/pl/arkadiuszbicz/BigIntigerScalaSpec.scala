package pl.arkadiuszbicz


import org.specs2._
import org.scalacheck.Prop._

class BigIntigerScalaSpec extends Specification  {
  def propConcatLists = forAll { (l1: List[Int], l2: List[Int]) =>
    l1.size + l2.size == (l1 ::: l2).size }

  def is =

"add" !   propConcatLists

//check { (a: BigInt, b: BigInt) => (a.+(b).toString(10).mustEqual(BigIntigerScala.add(a.toString(10), b.toString(10))))} ^
}
