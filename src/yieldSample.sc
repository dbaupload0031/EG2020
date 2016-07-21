val list0 =List(1,2,3,4,5)
val newlist = for(i<-list0;if i >2) yield i+100

val newlist1 = for(i<-list0;if i >2) yield  { s"Day $i:" }

val quote = "Faith,Hope,,Charity"
val k2= for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
} yield
  { println(t) }

val k3= for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
} yield t
