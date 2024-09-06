package Prac_1

data class Expense(val amount: Double, val category: String, val date: String) {
    fun displayExpense() {
        println("Amount: $amount, Category: $category, Date: $date")
    }
}

class ExpenseManager {
    private val expenses = mutableListOf<Expense>()

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun displayAllExpenses() {
        for (expense in expenses) {
            expense.displayExpense()
        }
    }

    fun calculateTotalByCategory(): Map<String, Double> {
        val categoryTotals = mutableMapOf<String, Double>()
        for (expense in expenses) {
            val currentTotal = categoryTotals.getOrDefault(expense.category, 0.0)
            categoryTotals[expense.category] = currentTotal + expense.amount
        }
        return categoryTotals
    }

    fun displayTotalByCategory(totalsByCategory: Map<String, Double>) {
        println("Total Expenses by Category:")
        for ((category, total) in totalsByCategory) {
            println("$category: $total")
        }
    }
}

fun main() {
    val expenseManager = ExpenseManager()

    expenseManager.addExpense(Expense(150.0, "Groceries", "2023-11-01"))
    expenseManager.addExpense(Expense(30.0, "Utilities", "2023-11-02"))
    expenseManager.addExpense(Expense(80.0, "Groceries", "2023-11-03"))
    expenseManager.addExpense(Expense(45.0, "Entertainment", "2023-11-04"))
    expenseManager.addExpense(Expense(20.0, "Utilities", "2023-11-05"))

    println("All Expenses:")
    expenseManager.displayAllExpenses()

    println()
    val totalsByCategory = expenseManager.calculateTotalByCategory()
    expenseManager.displayTotalByCategory(totalsByCategory)
}
