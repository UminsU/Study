package w3.w3_5_stringadv;

public class StringBuilderSample {
    public static void main(String[] args) {
        int length;
        
        // Creating a StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello");
        System.out.println("StringBuilder content: " + stringBuilder);

        // Append: Appending text at the end
        stringBuilder.append(" World");
        System.out.println("StringBuilder content: " + stringBuilder);

        // Insert: Inserting text at a specific position
        stringBuilder.insert(5, " Beautiful");
        System.out.println("StringBuilder content: " + stringBuilder);
        length = stringBuilder.length();
        System.out.println("Length: " + length);

        // Delete: Deleting characters in a range
        stringBuilder.delete(4, 15);
        System.out.println("StringBuilder content: " + stringBuilder);

        // Replace: Replacing characters in a range
        stringBuilder.replace(5, 10, "Java!");
        System.out.println("StringBuilder content: " + stringBuilder);

        // Reverse: Reversing the content
        stringBuilder.reverse();
        System.out.println("StringBuilder content: " + stringBuilder);

        // Set length: Truncating or extending the sequence
        stringBuilder.setLength(7);
        System.out.println("StringBuilder content: " + stringBuilder);

        // Capacity: Obtaining the current capacity, 차지하고 있는 메모리 크기
        int capacity = stringBuilder.capacity();
        System.out.println("Capacity: " + capacity);

        // Length: Obtaining the current length
        length = stringBuilder.length();
        System.out.println("Length: " + length);
    }
}