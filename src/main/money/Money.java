package money;

class Money {
    private int amount;
    private String currency;

    private Money(int amount, String currency) {
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

    String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }

        Money money = (Money) obj;
        return amount == money.amount
                && getCurrency().equals(money.getCurrency());
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
