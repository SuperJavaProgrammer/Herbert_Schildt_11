package chapter21.InputOutput;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file; //class File implements Serializable, Comparable<File>
        //File(String directoryPath); File(String directoryPath, String filename); File(File dirObj, String filename); File(URI uriObj);
        //boolean mkdir();
        //boolean mkdirs();
        //boolean delete();
        //boolean renameTo(File newName);
        //String[] list();
        //String[] list(FilenameFilter FFObj)
        //File[] listFiles();
        //File[] listFiles(FilenameFilter FFObj);
        //File[] listFiles(FileFilter FObj);
        //Path toPath();
        file = new File("src/chapter21/InputOutput/1"); //получить файл по пути
        System.out.println("Name=" + file.getName() + " Path=" + file.getPath() + " AbsolutePath=" + file.getAbsolutePath() + " Parent=" + file.getParent()); //Name=1 Path=src\chapter21\InputOutput\1 AbsolutePath=D:\Java\Schildt\Herbert_Schildt_11\src\chapter21\InputOutput\1 Parent=src\chapter21\InputOutput
        System.out.println("canWrite=" + file.canWrite() + " canRead=" + file.canRead() + " isDirectory=" + file.isDirectory() + " isFile=" + file.isFile()); //canWrite=true canRead=true isDirectory=false isFile=true
        System.out.println("isAbsolute=" + file.isAbsolute() + " lastModified=" + file.lastModified() + " size=" + file.length() + " exists=" + file.exists()); //isAbsolute=false lastModified=1635457427553 size=56 exists=true

        FilenameFilter filenameFilter; //interface FilenameFilter. boolean accept(File var1, String var2);
        file = new File("src/chapter21/InputOutput/Dir");
        for (String s : file.list((a, b) -> b.startsWith("2"))) //b.endsWith(".txt") //применить фильтр для извлечения нужных данных
            System.out.println("Found " + s); //Found 2.html Found 2.txt

        AutoCloseable autoCloseable; //interface AutoCloseable. void close() throws Exception; //AutoCloseable provides support for the try-with-resources
        Closeable closeable; //interface Closeable extends AutoCloseable. void close() throws IOException; //Objects can be closed
        Flushable flushable; //interface Flushable. void flush() throws IOException; //Objects can force buffered output to be written to the stream to which the object is attached

            //Byte Stream Classes
        InputStream is; //abstract class InputStream implements Closeable
        //void close();
        //void reset();
        //void mark(int readlimit);
        //boolean markSupported();
        //int read();
        //int read(byte[] b, int off, int len);
        //int readNBytes(byte[] b, int off, int len);
        //int available();
        //long skip(long n);
        //long transferTo(OutputStream out)
        //byte[] readAllBytes();
        //static InputStream nullInputStream();
        OutputStream os; //abstract class OutputStream implements Closeable, Flushable
        //void close();
        //void flush();
        //void write(int b);
        //void write(byte[] b);
        //void write(byte[] b, int off, int len);
        //static OutputStream nullOutputStream()

        FileInputStream fileInputStream; //class FileInputStream extends InputStream
        //FileInputStream(String filePath); FileInputStream(File fileObj)
        try (FileInputStream fis = new FileInputStream("src/chapter21/InputOutput/1")) { //использовать файл для чтения
            System.out.println("available=" + fis.available()); //56
            System.out.println("Read 5 chars");
            for (int i = 0; i < 5; i++)
                System.out.print((char) fis.read()); //1 2 3
            System.out.println("\navailable=" + fis.available()); //51
            byte[] b = new byte[10];
            fis.read(b);
            System.out.println(new String(b)); // 4 Hello 5
            System.out.println("available=" + fis.available()); //41
            fis.skip(15);
            fis.read(b);
            System.out.println(new String(b)); //11 true fa
            System.out.println("available=" + fis.available()); //16
        } catch (IOException e) {
            System.out.println("error");
        }

        FileOutputStream fileOutputStream; //class FileOutputStream extends OutputStream
        //FileOutputStream(String filePath); FileOutputStream(File fileObj); FileOutputStream(String filePath, boolean append); FileOutputStream(File fileObj, boolean append);
        String source = "To be or not to be. What is the question?";
        byte[] buf = source.getBytes();
        try (FileOutputStream fos1 = new FileOutputStream("src/chapter21/InputOutput/out1"); FileOutputStream fos2 = new FileOutputStream("src/chapter21/InputOutput/out2")) { //использовать 2 файла для записи
            fos1.write(buf); //записать полностью //To be or not to be. What is the question?
            fos2.write(buf, source.length() - source.length() / 2, source.length() / 2); //записать вторую половину текста //hat is the question?
        } catch (IOException e) {
            System.out.println("error");
        }

        ByteArrayInputStream bais; //class ByteArrayInputStream extends InputStream
        //ByteArrayInputStream(byte array []); ByteArrayInputStream(byte array [], int start, int numBytes)
        bais = new ByteArrayInputStream(buf);
        int ch;
        for (int i = 0; i < 2; i++) {
            while ((ch = bais.read()) != -1) //считывать из входного потока, пока есть данные
                System.out.print(i == 0 ? (char) ch : Character.toUpperCase((char) ch)); //To be or not to be. What is the question? TO BE OR NOT TO BE. WHAT IS THE QUESTION?
            System.out.println();
            bais.reset(); //сбросить, переход в начало
        }

        ByteArrayOutputStream baos; //class ByteArrayOutputStream extends OutputStream
        //ByteArrayOutputStream(); //buffer of 32 bytes is created. ByteArrayOutputStream(int numBytes);
        baos = new ByteArrayOutputStream();
        baos.write(buf); //записать в потом данных массив данных
        baos.write('A');
        System.out.println(baos); //To be or not to be. What is the question?A
        byte[] bufGet = baos.toByteArray(); //получить массив byte из выходного потока
        for (byte b : bufGet)
            System.out.print((char) b); //To be or not to be. What is the question?A
        try (var out = new FileOutputStream("src/chapter21/InputOutput/out3")) {
            baos.writeTo(out); //вывести в файл данные из выходного потока данных //To be or not to be. What is the question?A
        }

        FilterOutputStream filterOutputStream; //class FilterOutputStream extends OutputStream. FilterOutputStream(OutputStream os)
        BufferedInputStream bufferedInputStream; //class BufferedInputStream extends FilterInputStream
        //BufferedInputStream(InputStream inputStream); BufferedInputStream(InputStream inputStream, int bufSize)
        PushbackInputStream pushbackInputStream; //class PushbackInputStream extends FilterInputStream //used on an input stream to allow a byte to be read and then returned
        //PushbackInputStream(InputStream inputStream); PushbackInputStream(InputStream inputStream, int numBytes)
        //void unread(int b); void unread(byte buffer []); void unread(byte buffer, int offset, int numBytes)
        SequenceInputStream sequenceInputStream; //class SequenceInputStream extends InputStream //allows you to concatenate multiple InputStreams
        //SequenceInputStream(InputStream first, InputStream second); SequenceInputStream(Enumeration <? extends InputStream> streamEnum)

        FilterInputStream filterInputStream; //class FilterInputStream extends InputStream. FilterInputStream(InputStream is)
        BufferedOutputStream bufferedOutputStream; //class BufferedOutputStream extends FilterOutputStream
        //BufferedOutputStream(OutputStream outputStream); BufferedOutputStream(OutputStream outputStream, int bufSize)
        PrintStream printStream; //class PrintStream extends FilterOutputStream implements Appendable, Closeable //System.out is a PrintStream
        //PrintStream(OutputStream outputStream); PrintStream (OutputStream outputStream, boolean autoFlushingOn); PrintStream(OutputStream outputStream, boolean autoFlushingOn String charSet)
        //PrintStream(File outputFile); PrintStream(File outputFile, String charSet); PrintStream(String outputFileName); PrintStream(String outputFileName, String charSet);
        //PrintStream printf(String fmtString, Object … args);
        //PrintStream printf(Locale loc, String fmtString, Object … args)
        //PrintStream format(String fmtString, Object … args);
        //PrintStream format(Locale loc, String fmtString, Object … args) аналог printf

        DataOutputStream dataOutputStream; //class DataOutputStream extends FilterOutputStream implements DataOutput
        //DataOutputStream(OutputStream outputStream)
        //void writeInt(int value);
        //void writeBoolean(boolean value);
        //void writeDouble(double value);
        DataInputStream dataInputStream; //class DataInputStream extends FilterInputStream implements DataInput
        //DataInputStream(InputStream inputStream)
        //int readInt();
        //boolean readBoolean();
        //double readDouble();
        try (var dos = new DataOutputStream(new FileOutputStream("src/chapter21/InputOutput/out4"))) {
            dos.writeDouble(85.6); //записаь разнотипных данных
            dos.writeInt(845);
            dos.writeBoolean(true);
        } //@Uffffff  M
        try (var dis = new DataInputStream(new FileInputStream("src/chapter21/InputOutput/out4"))) {
            System.out.println("Values = " + dis.readDouble() + dis.readInt() + dis.readBoolean()); //считывание записанных данных //Values = 85.6845true
        }

        RandomAccessFile randomAccessFile; //class RandomAccessFile implements DataOutput, DataInput, Closeable
        //RandomAccessFile(File fileObj, String access); RandomAccessFile(String filename, String access)
        //void seek(long newPos);
        //void setLength(long len)

            //Character Stream Classes
        Reader reader; //abstract class Reader implements Readable, Closeable
        //void close();
        //void reset();
        //void mark(int numChars);
        //boolean markSupported();
        //int read();
        //int read(char[] cbuf);
        //int read(CharBuffer target);
        //int read(char[] cbuf, int off, int len);
        //long skip(long n);
        //long transferTo(Writer out)
        //static Reader nullReader();
        Writer writer; //abstract class Writer implements Appendable, Closeable, Flushable
        //Writer append(char c); Writer append(CharSequence csq); Writer append(CharSequence csq, int start, int end)
        //void close();
        //void flush();
        //void write(int c);
        //void write(char[] cbuf);
        //void write(char[] var1, int var2, int var3);
        //void write(String str);
        //void write(String str, int off, int len)
        //static Writer nullWriter();

        FileReader fileReader; //class FileReader extends InputStreamReader
        //FileReader(String filePath); FileReader(File fileObj)
        FileWriter fileWriter; //class FileWriter extends OutputStreamWriter
        //FileWriter(String filePath); FileWriter(String filePath, boolean append); FileWriter(File fileObj); FileWriter(File fileObj, boolean append)

        CharArrayReader charArrayReader; //class CharArrayReader extends Reader
        //CharArrayReader(char array []); CharArrayReader(char array [], int start, int numChars)
        CharArrayWriter charArrayWriter; //class CharArrayWriter extends Writer
        //CharArrayWriter(); CharArrayWriter(int numChars)

        BufferedReader bufferedReader; //class BufferedReader extends Reader
        //BufferedReader(Reader inputStream); BufferedReader(Reader inputStream, int bufSize)
        BufferedWriter bufferedWriter; //class BufferedWriter extends Writer
        //BufferedWriter(Writer outputStream); BufferedWriter(Writer outputStream, int bufSize)

        PushbackReader pushbackReader; //class PushbackReader extends FilterReader
        //PushbackReader(Reader inputStream); PushbackReader(Reader inputStream, int bufSize)
        //void unread(int ch);
        //void unread(char buffer []);
        //void unread(char buffer [], int offset, int numChars)

        PrintWriter printWriter; //class PrintWriter extends Writer
        //PrintWriter(OutputStream outputStream); PrintWriter(OutputStream outputStream, boolean autoFlushingOn); PrintWriter(Writer outputStream); PrintWriter(Writer outputStream, boolean autoFlushingOn)
        //PrintWriter(File outputFile); PrintWriter(File outputFile, String charSet); PrintWriter(String outputFileName); PrintWriter(String outputFileName, String charSet)
        //PrintWriter printf(String fmtString, Object … args);
        //PrintWriter printf(Locale loc, String fmtString, Object …args)
        //PrintWriter format(String fmtString, Object … args);
        //PrintWriter format(Locale loc, String fmtString, Object … args)

        Console console; //class Console implements Flushable
        //static Console console();
        console = System.console();
        if (console != null) {
            String consoleTest = console.readLine("Enter string: ");
            console.printf("Your string is %s", consoleTest);
        } else System.out.println("You don't have console");

        Serializable serializable; //interface Serializable
        Externalizable externalizable; //interface Externalizable extends Serializable //if programmer may need to have control over Serializable processes
        //void writeExternal(ObjectOutput var1);
        //void readExternal(ObjectInput var1);

        ObjectOutput objectOutput; //interface ObjectOutput extends DataOutput, AutoCloseable
        //void close();
        //void flush();
        //void write(int var1);
        //void write(byte[] var1);
        //void write(byte[] var1, int var2, int var3);
        //void writeObject(Object var1);
        ObjectOutputStream objectOutputStream; //class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants
        //ObjectOutputStream(OutputStream outStream)
        //void writeX(X obj);
        //void writeObject(Object obj);

        ObjectInput objectInput; //interface ObjectInput extends DataInput, AutoCloseable
        //void close();
        //int read();
        //int read(byte[] var1);
        //int read(byte[] var1, int var2, int var3);
        //int available();
        //long skip(long var1);
        //Object readObject();
        ObjectInputStream objectInputStream; //class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants
        //ObjectInputStream(InputStream inStream).
        //X readX();
        //Object readObject();

        try (var ous = new ObjectOutputStream(new FileOutputStream("src/chapter21/InputOutput/serial"))) {
            Serialization ser = new Serialization("TestInner", 10, 1.2, false, "LostInner", null);
            Serialization serialization = new Serialization("Test", 100, 5.4, true, "Lost", ser);
            System.out.println("Initial=" + serialization); //Initial=Serialization{s='Test', i=100, d=5.4, b=true, noSave=Lost, ser=Serialization{s='TestInner', i=10, d=1.2, b=false, noSave=LostInner, ser=null}}
            ous.writeObject(serialization); //записать объект в файл, сериализация //�� sr #chapter21.InputOutput.Serialization�2��o� Z bD dI iL st Ljava/lang/String;L sert %Lchapter21/InputOutput/Serialization;xp@������   dt Testsq ~   ?�333333t 	TestInnerp
        }
        try (var ois = new ObjectInputStream(new FileInputStream("src/chapter21/InputOutput/serial"))) {
            Serialization serialization = (Serialization) ois.readObject(); //вычитать объект из файла, десериализация
            System.out.println("After deserialization=" + serialization); //After deserialization=Serialization{s='Test', i=100, d=5.4, b=true, noSave=null, ser=Serialization{s='TestInner', i=10, d=1.2, b=false, noSave=null, ser=null}}
        }
    }
}