package javajungsuk;

import javax.swing.*;

public class threadIOblocking {
    public static void main(String[] args) throws Exception {
        ThreadEx5_1 tr = new ThreadEx5_1();
        tr.start();

        String s = JOptionPane.showInputDialog("입력하세요");
        System.out.println("입력값은 " + s + " 입니다.");
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

