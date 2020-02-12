package money;

class Money implements Expression {
    int amount;
    private String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    String currency() {
        return currency;
    }

    Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(String to) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }

        Money money = (Money) obj;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
