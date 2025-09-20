fun main() {
    val cart = ShoppingCart()

    val laptop = PhysicalProduct("Laptop", 40000, 2)
    val phone = PhysicalProduct("Phone", 20000, 3)
    val ebook = DigitalProduct("E-Book", 500, 5)

    cart.addItem(laptop)
    cart.addItem(phone)
    cart.addItem(ebook)

    cart.showCart()
    println("Total Cost = ${cart.calculateTotal()}")
}

open class CartItem(
    open var productName: String,
    open var price: Int,
    open var quantity: Int
) {
    open fun TotalPrice(): Int {
        return price * quantity
    }
}

class PhysicalProduct(
    override var productName: String,
    override var price: Int,
    override var quantity: Int
) : CartItem(productName, price, quantity){

}
class DigitalProduct(
    override var productName: String,
    override var price: Int,
    override var quantity: Int
) : CartItem(productName, price, quantity){

}
class ShoppingCart {
    private val items = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {
        items.add(item)
    }
    fun calculateTotal(): Int {
        var total = 0
        for (item in items) {
            total += item.TotalPrice()
        }
        return total
    }
    fun showCart() {
        for (item in items) {
            println("Product: ${item.productName}, Quantity: ${item.quantity}, Price: ${item.price}, Total: ${item.TotalPrice()}")
        }
    }
}
