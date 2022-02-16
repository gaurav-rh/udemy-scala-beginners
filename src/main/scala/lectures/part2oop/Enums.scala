package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    //add feilds / methods
    def openDocument(): Unit =
      if(this == READ) println("opening document..")
      else println("reading not allowed")
  }
  val somePermission : Permissions = Permissions.READ
  enum PermissionsWithBits(bits:Int) {
    case READ extends PermissionsWithBits(4)  //100
    case WRITE extends PermissionsWithBits(2) //010
    case EXECUTE extends PermissionsWithBits(1) //001
    case NONE extends PermissionsWithBits(0) //000

  }
  object PermissionsWithBits {
    def fromBits(bits:Int): PermissionsWithBits = //whatever
    PermissionsWithBits.NONE
  }

  // Standard API of enum == buit-in in every enum
  val somePermissionOrdinal = somePermission.ordinal
  /**
   * another useful functionality of enum is ability to iterate or get a hold of all the possible
   * values of an enum
   * */
  val allPermission = PermissionsWithBits.values  // array of all possible values of enum

  val readPermission : Permissions = Permissions.valueOf("READ")  //Permissions.READ
  def main(args:Array[String]): Unit = {
    somePermission.openDocument()
    println(somePermissionOrdinal)
  }
  /**
   * enums can act like any class except you already have constants of that class already specified
   * also takes constructor arguments
   * */

}
