package pl.arkadiuszbicz

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object  BigIntigerScalaSpec extends Properties("BigIntegerScala") {

  property("startsWith") = forAll { (a: String, b: String) =>
    (a+b).startsWith(a)
  }

  property("concatenate") = forAll { (a: String, b: String) =>
    (a+b).length > a.length && (a+b).length > b.length
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a+b+c).substring(a.length, a.length+b.length) == b
  }


  def propConcatLists = forAll { (l1: List[Int], l2: List[Int]) =>
    l1.size + l2.size == (l1 ::: l2).size }


//check { (a: BigInt, b: BigInt) => (a.+(b).toString(10).mustEqual(BigIntigerScala.add(a.toString(10), b.toString(10))))} ^
}
