import example.complex.Complex;
import example.complex.Complex.*;
public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Complex example");

        DummyMessage oneDummy = newDummyMessage(55,"one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();
        builder.setOneDummy(oneDummy);
        builder.addMultipleDummy(
                newDummyMessage(66,"Second message")
        );
        builder.addMultipleDummy(
                newDummyMessage(67,"Third message")
        );

        ComplexMessage message = builder.build();
        System.out.println(message.toString());

    }

    public static DummyMessage newDummyMessage(Integer id, String name){
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        DummyMessage message = dummyMessageBuilder.setName(name).setId(id).build();
        return message;
    }
}
