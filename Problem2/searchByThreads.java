import java.io.*;
import java.util.*;

class searchByThreads extends Thread {

	static String fileName;
	static String str = "";

	static String FilesPath = System.getProperty("user.dir") + "\\Files\\";
	

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// create files

		System.out.println("Enter files that you want to create e.g. 100");
		int n = sc.nextInt();

		create100Files creator = new create100Files();
		creator.createFiles(n);

		System.out.println("-------------------------------------------------------");

		System.out.println("\nEnter key that you want search [format:'file#content#' # represents number between (1 >= i <= No. of files)]");

		str = sc.next();

		System.out.println("\n-------------------------------------------------------\n");

		// Reading the files

		long start = System.currentTimeMillis();

		if(findContentOnFile_linear(n, str)){
			System.out.println("In linear Search -> Content is found on file " + fileName);
		}else{
			System.out.println("In linear Search -> Content Not Found");
		}

		long end = System.currentTimeMillis();

		System.out.println("Total time required to run : " + (end - start));

		System.out.println("\n-------------------------------------------------------\n");

		// Reading the file with use of multithreading

		System.out.println("Enter number of threads you want...");
		int threads_count = sc.nextInt();

		start = System.currentTimeMillis();

		findContentOnFile_parallel(n, str, threads_count);

		end = System.currentTimeMillis();

		System.out.println("\nTotal time required to run : " + (end - start));

		System.out.println("\n-------------------------------------------------------\n");
	}

	public static void findContentOnFile_parallel(int n, String str, int threads_count){

		if(threads_count <= 0) System.out.println("Unable to proceed with this much threads..");

		else if(threads_count <= n){

			for(int i = 1; i <= n; i++){
				searchByThreads obj = new searchByThreads();
				obj.setName(((n % i) + 1) + "");
				obj.start();	
				// if(!obj.isAlive()) break;
			}

		}else{
			// More than N threads
			for(int i = 1; i <= n; i++){
				searchByThreads obj = new searchByThreads();
				obj.setName((i) + "");
				obj.start();
				// if(!obj.isAlive()) break;
			}
		}
	}

	public void run() {

		try {
			File file = new File(FilesPath + "file" + Thread.currentThread().getName() + ".txt");
			Scanner scanFile = new Scanner(file);
			while(scanFile.hasNextLine()){
				String line = scanFile.nextLine();
				for(String word : line.split(" ")){
					if(word.equals(str)){
						System.out.println("In Parallel Search -> Content is found on file " + Thread.currentThread().getName());
						Thread.currentThread().stop();
					}
				}
			}
		}catch(Exception e){
			System.out.println("Cought Exception" + e);
		}
	}

	public static boolean findContentOnFile_linear(int n, String str) throws Exception {

		for(int i = 1; i <= n; i++){
			File file = new File(FilesPath + "file" + i + ".txt");
			Scanner scanFile = new Scanner(file);
			while(scanFile.hasNextLine()){
				String line = scanFile.nextLine();
				int word_counter = 0;
				for(String word : line.split(" ")){
					if(word.equals(str)){
						fileName = "file" + i + ".txt";
						return true;
					}
				}
			}
		}
		return false;
	}
}

