package com.example.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class OldAndNewIOTest {

	String path = "./src/";
	String file = "cricket.txt";

	public static void main(String[] s) {
		new OldAndNewIOTest();
	}

	public OldAndNewIOTest() {

		/*new Thread(() -> {
			readUsingStream();
		}).start();
		 */
		
		new Thread(() -> {
			readUsingBuffer();
		}).start();
		
		
		new Thread(() -> {
			readSmallFileUsingNIO();
		}).start();

		//new Thread(() -> {
			//readFileUsingNIOByteChannel();
		//}).start();

		/*new Thread(() -> {
			readFileUsingNIOFileChannel();
		}).start();

		new Thread(() -> {
			readWriteFileUsingNIO();
		}).start();

		new Thread(() -> {
			simpleReadUsingNIO();
		}).start();

		new Thread(() -> {
			readUsingStreamJava8();
		}).start();
		
		new Thread(() -> {
			readUsingParallelStreamJava8();
		}).start();
		*/

	}

	public void readUsingStream() {

		try {
			Path filePath = FileSystems.getDefault().getPath(path, file);
			InputStream inputStream = Files.newInputStream(filePath);
			int chunk = inputStream.read();
			while ((chunk = inputStream.read()) != -1) {
				System.out.println((char) chunk);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readUsingBuffer() {

		try {
			Path filePath = FileSystems.getDefault().getPath(path, file);
			BufferedReader bufferedReader = Files.newBufferedReader(filePath);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readSmallFileUsingNIO() {

		try {
			Path filePath = FileSystems.getDefault().getPath(path, file);

			// read entire file in single go as byte array
			// use only for reading small files
			byte[] byteArray = Files.readAllBytes(filePath);

			System.out.println(new String(byteArray, "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileUsingNIOByteChannel() {

		try {
			Path filePath = FileSystems.getDefault().getPath(path, file);

			SeekableByteChannel byteChannel = Files.newByteChannel(filePath);
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

			Charset charset = Charset.forName("UTF-8");

			while (byteChannel.read(byteBuffer) > 0) {
				byteBuffer.rewind();
				System.out.print(charset.decode(byteBuffer));
				byteBuffer.flip();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileUsingNIOFileChannel() {

		try {
			Path filePath = FileSystems.getDefault().getPath(path, file);

			RandomAccessFile randomAccessFile = new RandomAccessFile(filePath.toFile(), "rw");
			FileChannel fileChannel = randomAccessFile.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			Charset charset = Charset.forName("UTF-8");

			while (fileChannel.read(byteBuffer) > 0) {
				byteBuffer.rewind();
				System.out.print(charset.decode(byteBuffer));
				byteBuffer.flip();
			}
			fileChannel.close();
			randomAccessFile.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readWriteFileUsingNIO() {

		try {
			Path fileReadPath = FileSystems.getDefault().getPath(path, file);

			byte[] byteArray = Files.readAllBytes(fileReadPath);

			Path fileWritePath = FileSystems.getDefault().getPath(path, "cricket-out.txt");

			Files.write(fileWritePath, byteArray);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void simpleReadUsingNIO() {

		try {
			RandomAccessFile filePath = new RandomAccessFile(path + file, "r");

			FileChannel fileChannel = filePath.getChannel();

			ByteBuffer byteBuffer = ByteBuffer.allocate(512);

			while (fileChannel.read(byteBuffer) > 0) {
				// flip the buffer to prepare for get operation
				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					System.out.print((char) byteBuffer.get());
				}
				// clear the buffer ready for next sequence of read
				byteBuffer.clear();
			}
			filePath.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readUsingStreamJava8() {

		try {

			Stream<String> lines = Files.lines(Paths.get(path, file));

			lines.forEach(System.out::println);

			// Close the stream and underlying file
			lines.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readUsingParallelStreamJava8() {

		try {

			Stream<String> lines = Files.lines(Paths.get(path, file));

			lines.parallel().forEach(System.out::println);

			// Close the stream and underlying file
			lines.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}