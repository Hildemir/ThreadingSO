public class MySemaphore {
    private int lock;

    // [Constructor]
    public MySemaphore(int lock) {
        // [Initialize the number of Resources of the Semaphore]
        this.lock = lock;
    }
    // [Constructor]

     public void acquire() {
        // [Get lock if there is 1 resource]
        if(lock > 0){
            setLock(lock - 1);
        }
        // [If is Not Available wait]
        // [Get it when there is a resource available]
        else{
            try {
                synchronized (this){
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setLock(lock - 1);        }
    }

     public void release() {
        // [Release the Lock]
        setLock(lock + 1);

        // [If there are more resources than 0, Notify waiting threads]
        if(this.lock > 0) {
            synchronized (this) {
                notify();
            }
        }
    }

    public void setLock(int lock) {
        this.lock = lock;
    }
}
