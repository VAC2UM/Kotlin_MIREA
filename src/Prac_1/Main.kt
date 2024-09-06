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
}

fun main() {
    val expenseManager = ExpenseManager()

    expenseManager.addExpense(Expense(100.0, "Food", "2023-10-01"))
    expenseManager.addExpense(Expense(50.0, "Transport", "2023-10-02"))
    expenseManager.addExpense(Expense(200.0, "Food", "2023-10-03"))
    expenseManager.addExpense(Expense(75.0, "Entertainment", "2023-10-04"))

    println("All Expenses:")
    expenseManager.displayAllExpenses()

    println("\nTotal Expenses by Category:")
    val totalsByCategory = expenseManager.calculateTotalByCategory()
    for ((category, total) in totalsByCategory) {
        println("$category: $total")
    }
}