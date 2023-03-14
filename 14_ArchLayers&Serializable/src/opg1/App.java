package opg1;

import java.io.*;

public class App {
    public static void main(String[] args) {
        MyTime myTime = null;
        try (
                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Mads\\Desktop\\datamatiker\\2. semester\\PRO2\\PRO2\\14_ArchLayers&Serializable\\src\\opg1\\mytime.ser");
                ObjectInputStream in = new ObjectInputStream(fileInputStream)
        ) {
            Object o = in.readObject();
            if (o instanceof MyTime) {
                myTime = (MyTime) o;
                myTime.increase();
                myTime.increase();
                myTime.increase();
                System.out.println(myTime.getTime());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Mads\\Desktop\\datamatiker\\2. semester\\PRO2\\PRO2\\14_ArchLayers&Serializable\\src\\opg1\\mytime.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ) {
            out.writeObject(myTime);
            System.out.println("My time er gemt: " + myTime);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
