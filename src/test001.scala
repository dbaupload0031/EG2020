/**
  * Created by samchang on 2016/7/16.
  */
object test001 {
  def main(args: Array[String]) = {
    val myVehicle = Vehicle.apply("car")
    myVehicle.drive
  }
}

class Car extends Vehicle {
  override def drive {
    printf("car bibi~")
  }
}

class Bus extends Vehicle {
  override def drive {
    printf("bus didi~")
  }
}

//Vehicle接口
trait Vehicle {
  def drive
}

//factory method
object Vehicle {
  def apply(kind: String) = kind match {
    case "car" => new Car()
    case "bus" => new Bus()

  }
}