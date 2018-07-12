package top.vkeep.chapter4.threadlocal;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-12
 **/
public class SequenceB implements Sequence {

    private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        SequenceB sequence = new SequenceB();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
