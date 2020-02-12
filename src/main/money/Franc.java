package money;

class Franc {
    private int amount;

    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Franc)) {
            return false;
        }

        Franc franc = (Franc) obj;
        return amount == franc.amount;
    }
}
