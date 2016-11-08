package utils;

import java.io.IOException;

public class DriverFactory {
	static Process process;
	static ProcessBuilder builder;

	/**
	 * This method Is responsible for starting appium server.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void appiumStart() throws IOException, InterruptedException {
		String[] command = { "cmd.exe", "/C", "Start", "appium" };

		ProcessBuilder pb = new ProcessBuilder(command);
		process = pb.start();
		Thread.sleep(20000);
		if (process != null) {
			System.out.println("Appium server Is started now.");
		}
	}

	public static void appiumStop() {
		builder = new ProcessBuilder("cmd.exe", "/c", "taskkill /f /im " + "node.exe");
		builder.redirectErrorStream(true);
		try {
			builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TASK KILLED :: ");
	}

}
