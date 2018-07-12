package top.vkeep.chapter4.threadlocal;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-12
 **/
public class SequenceA implements Sequence {

    private static int number = 0;

    @Override
    public int getNumber() {
        number = number + 1;
        return number;
    }

    public static void main(String[] args) {
        SequenceA sequenceA = new SequenceA();

        ClientThread thread1 = new ClientThread(sequenceA);
        ClientThread thread2 = new ClientThread(sequenceA);
        ClientThread thread3 = new ClientThread(sequenceA);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
