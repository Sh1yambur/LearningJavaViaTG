package lesson_20_exception.task_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        SimpleFile[] fileSystem = getMockFiles();
        String fileName = inputFileName();

        System.out.println(findFile(fileName, fileSystem));

//        try {
//            System.out.println(findFile(fileName, fileSystem));
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

    }

    private static SimpleFile[] getMockFiles() {
        return new SimpleFile[]{
                new SimpleFile("text one", Type.TEXT),
                new SimpleFile("IMAGE_ONE", Type.IMAGE),
                new SimpleFile("audio_1", Type.AUDIO),
                new SimpleFile("video 1", Type.VIDEO),
        };
    }

    private static SimpleFile findFile(String targetFileName, SimpleFile[] fileSystem) throws FileNotFoundException {
        for (SimpleFile file : fileSystem) {
            if (file.getName().equals(targetFileName)) {
                return file;
            }
        }

        throw new FileNotFoundException("Searched file not exist");
    }

    private static String inputFileName() {
        System.out.print("file name <== ");
        return SC.nextLine();
    }
}
