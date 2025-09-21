fun main(){
    val payroll = PayrollSystem()

    val emp1 = FullTimeEmployee("Sourav", "101", 5500, 15000)
    val emp2 = FullTimeEmployee("Olivia", "102", 5000, 14900)
    val emp3 = ContractEmployee("Iqbal", "201", 25, 410, 5500)
    val emp4 = ContractEmployee("Amelia", "202", 21, 400, 5000)

    payroll.addEmployee(emp1)
    payroll.addEmployee(emp2)
    payroll.addEmployee(emp3)
    payroll.addEmployee(emp4)

    println("Employee Informetion:\n")
    emp1.Salary("He","Mr")
    emp2.Salary("She","Most")
    emp3.Salary("He","Mr")
    emp4.Salary("She","Most")

    payroll.showPayroll()
}
open class Employee(
    open val Name:String,
    open val EmployeeID:String,
    open val Salary: Int
    ){
    open fun Salary(type:String, mrormiss:String){
        println("Mr. $Name's salary is: $Salary")
        println("$type is a FullTimeEmployee/ContractEmployee")
        println("Her Id is $EmployeeID")
    }
    open fun calculatePay(): Int {
        return Salary
    }
}
class FullTimeEmployee(
    override val Name:String,
    override val EmployeeID:String,
    private val bonus :Int,
    override val Salary: Int):Employee(Name,EmployeeID,Salary){
        override fun Salary(type: String, mrormiss: String) {
            println("$mrormiss $Name's salary is: $Salary")
            println("Bonus: $bonus")
            println("$type is a FullTimeEmployee")
            println("Her Id is $EmployeeID\n")
        }
    override fun calculatePay(): Int {
        return Salary + bonus }
    }
class ContractEmployee(
    override val Name:String,
    override val EmployeeID:String,
    private val daysWorked: Int,
    private val dailyRate: Int,
    override val Salary: Int):Employee(Name,EmployeeID,Salary){
    override fun Salary(type: String, mrormiss: String) {
        println("$mrormiss $Name's salary is: $Salary")
        println("$type worked $daysWorked days")
        println("Daily Rate: $dailyRate")
        println("$type is a ContractEmployee")
        println("Her Id is $EmployeeID\n")
    }
    override fun calculatePay(): Int {
        return daysWorked * dailyRate }
    }

class PayrollSystem {
    private val employees = mutableListOf<Employee>()

    fun addEmployee(item: Employee) {
        employees.add(item)
    }
    fun showPayroll() {
        for (item in employees) {
            println("Name: ${item.Name}, ID: ${item.EmployeeID}, Pay: ${item.calculatePay()}")
        }
    }
}

