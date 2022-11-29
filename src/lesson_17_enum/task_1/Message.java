package lesson_17_enum.task_1;

public enum Message {
    HI("Hi", "Hello"),
    BYE("Bye", "Good bye"),
    HOW("How are you", "How are you doing"),
    UNK("", "Unknown message");

    private final String question;
    private final String answer;

    Message(String text, String answer) {
        this.question = text;
        this.answer = answer;
    }

    public static String findAnswer(String input) {
        for (Message msg : Message.values()) {
            if (input.equalsIgnoreCase(msg.question)) {
                return msg.answer;
            }
        }
        return UNK.answer;
    }
}