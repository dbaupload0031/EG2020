/**
  * Created by samchang on 2016/7/20.
  */
object yieldSample extends  App{


  val list =List(1,2,3,4,5)
  //without yield return Nil
  val newlist0 = for(i<-list;if i >2)  i+100
  println("newlist0: " + newlist0)  //newlist0: ()
  //with yield
  val newlist1 = for(i<-list;if i >2) yield i +100
  println("newlist1: " +newlist1)  //newlist1: List(103, 104, 105)

}
