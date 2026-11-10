// Поганий приклад
static int f(int a) {
    return a * 2;
}

// Гарний приклад
static int multiplyByTwo(int number) {
    return number * 2;
}

// Поганий приклад
class order_service {
    int Max_cnt = 10;
    double calc(double a, double b) { return a * b; }
}

// Гарний приклад
class OrderService {
    private static final int MAX_ITEMS_COUNT = 10;

    double calculateTotalPrice(double unitPrice, double quantity) {
        return unitPrice * quantity;
    }
}
