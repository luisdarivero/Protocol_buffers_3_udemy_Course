import example.simple.Simple.SimpleMessage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class SimpleMain {


    public static void main(String args[]){
        System.out.println("Hello world");
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        //simple fields
        builder.setId(42);
        builder.setIsSimple(true);
        builder.setName("My simple message name");

        //repeated fields
        builder.addSampleList(1);
        builder.addSampleList(2);
        builder.addSampleList(3);

        builder.addAllSampleList(Arrays.asList(4,5,6));

        builder.setSampleList(3,42);

        System.out.println(builder.toString());

        //Getting the message
        SimpleMessage message = builder.build();

        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Send as bite array (network)
        byte[] bytes = message.toByteArray();

        //Import the file created and
        try{
            System.out.println("Reading from file...");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile =  SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
