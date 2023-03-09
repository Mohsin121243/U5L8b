public class Tester {
    public static void main(String[] args) {


    System.out.println("---- TESTING PART A ----");
    Encryptor encryptor1 = new Encryptor(6, 7);
        encryptor1.fillBlock("I tripped an elderly person and I'm proud!");
        System.out.println(encryptor1.encryptBlock());

}}
