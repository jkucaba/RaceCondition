class Race implements Runnable {
    private Integer value = 0;

    // Uzycie bloku synchronizującego powoduje,
    // że gdy dany wątek uzyska dostęp do zasobów, żaden inny nie będzie miał takiej możlwiości
    public synchronized void increment() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;

    }

    public synchronized void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
            this.increment();
            System.out.println("Value after increment "
                    + Thread.currentThread().getName() + " " + this.getValue());
            this.decrement();
            System.out.println("Value after decrement "
                    + Thread.currentThread().getName() + " " + this.getValue());
    }
}