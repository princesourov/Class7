fun main(){
    val rent=RentAll()

    val Toyota= Car("Toyota","Corolla",3000,3)
    val Honda= Car("Honda","Civic",3500,3)
    val Yamaha= Bike("Yamaha","R15",1500,5)
    val Suzuki= Bike("Suzuki","Gixxer",1000,4)

    rent.addItem(Toyota)
    rent.addItem(Honda)
    rent.addItem(Yamaha)
    rent.addItem(Suzuki)

    rent.showRent()
    println("Total Rent = ${rent.calculateTotal()}")

}
open class Vehicle(
    open val make :String,
    open val model :String,
    open val rentalPricePerDay: Int,
    open val day: Int
){
    fun rent():Int {
        return day * rentalPricePerDay

    }
}
class Car(
    override val make: String,
    override val model: String,
    override val rentalPricePerDay: Int,
    override val day: Int
) : Vehicle(make, model, rentalPricePerDay,day) {

}
class Bike(
    override val make: String,
    override val model: String,
    override val rentalPricePerDay: Int,
    override val day: Int
) : Vehicle(make, model, rentalPricePerDay,day) {

}
class RentAll {
    private val items = mutableListOf<Vehicle>()

    fun addItem(item: Vehicle) {
        items.add(item)
    }
    fun calculateTotal(): Int {
        var total = 0
        for (item in items) {
            total += item.rent()
        }
        return total
    }
    fun showRent() {
        for (item in items) {
            println("Company: ${item.make}, Model: ${item.model}, Day: ${item.day}, Rent: ${item.rentalPricePerDay} Total: ${item.rent()}")
        }
    }
}
