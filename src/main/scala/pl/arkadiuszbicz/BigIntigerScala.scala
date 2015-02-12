package pl.arkadiuszbicz

object BigIntigerScala {

  def main(args:Array[String]) : Unit = {
    val i =1
    println(myFoldLeft("1234", "")((acc:String, e:Char) => { e + acc }) )
    println("1234".foldLeft("")((acc:String, e:Char) => { e + acc }))
    println(List.fill(3)('0').mkString)
    println(add("9999","999") + " " + (9999 + 999))
    println(multiply("22", "2") + " " + (2 * 22))
  }

 def add( d1:String, d2:String) : String = {
  val(d1r, d2r) = if(d1.length > d2.length) (d1, d2) else (d2,d1)
  val d2rPadded = zeroFill(d1r.length-d2r.length) + d2r
    d1r.zip(d2rPadded).foldRight("0")((e, acc) => {
      val (e1,e2) = (e._1 - '0', e._2 - '0')
      val lst = acc.head - '0'
      "%02d".format(e1+e2+lst) + acc.tail
    })
  }


  def multiply(d1:String, d2:String) :String = {
    d1.map(_ - '0').foldRight("0")((e:Int, acc:String) => {
      val internRes = d2.map(_-'0').foldRight("0")((a:Int, inn:String) => {
        val res = (e*a) + zeroFill(inn.length-1)
        val finRes = add(res, inn)
        finRes
      })
      add(internRes + zeroFill(acc.length-1) , acc)
    })
  }

  def zeroFill(n:Int) : String = List.fill(n)('0').mkString

  def myFoldLeft(list:String, initParam: String)(f:(String, Char) => String) : String= {
     if(list.length == 0) return initParam
     val res =  f(initParam, list.head)
     myFoldLeft(list.tail, res)(f)
  }


}

