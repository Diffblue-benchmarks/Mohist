package red.mohist;

import net.minecraftforge.fml.relauncher.ServerLaunchWrapper;
import org.apache.logging.log4j.Logger;

public class Mohist implements Runnable{

	private static final String name = "Mohist";
	private static final String version = "0.0.8a";
	private static final String native_verson = "v1_12_R1";
	public static Logger LOGGER;
	private static final String bukkit_version = "1.12.2-R0.1-SNAPSHOT";
	private static String[] args;

	public static String getName(){
		return name;
	}

	public static String getVersion(){
		return version;
	}

    public static String getNativeVersion() {
        return native_verson;
    }

	public static String getBukkitVersion() {
		return bukkit_version;
	}

	public static void main(String[] args){
		Mohist.args = args;
		Thread t = new Thread(new Mohist(),"Mohist");
		t.start();
	}

	@Override
	public void run() {

		new ServerLaunchWrapper().run(args);
	}
}
