public class MySemaphore {
    private int lock;

    // [Constructor]
    public MySemaphore() {
        // [initialize in 1 cuz is the only resource of the Semaphore]
        this.lock = 1;
    }
    // [Constructor]

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }
}
