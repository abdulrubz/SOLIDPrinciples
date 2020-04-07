import java.util.ArrayList;
import java.util.List;

// INTERFACE SEGREGATION
interface Callable {
    public void call();
}

interface audioComp {
    public void playMusic();
}

interface visualComp {
    public void playVideo();
    public void viewImage();
}

class CallingMobile implements Callable{
    @Override
    public void call() {
        System.out.println("Mobile Calling");
    }
}

class MultimediaMobile implements visualComp, audioComp {
    @Override
    public void playVideo() {
        System.out.println("Playing video");
    }

    @Override
    public void viewImage() {
        System.out.println("Viewing gallery");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }
}

//LISKOWS PRINCIPLE
class BurnerPhone extends CallingMobile {

    public void destroyPhone() {

        System.out.println("Self destroying phone");
    }
}

//SINGLE RESPONSIBILITY + OPEN/CLOSED
abstract class playVideo {
    public abstract void play();
}

class playMP4 extends playVideo{
    public void play() {
        //Some logic
        System.out.println("Playing MP4");
    }
}

class playAVI extends playVideo{
    public void play() {
        //Some logic
        System.out.println("Playing  AVI");
    }
}

class playMKV extends playVideo{
    public void play() {
        //Some logic
        System.out.println("Playing MKV");
    }
}

//DEPENDENCY INVERSION SOLUTION
abstract class Connectivity {
    abstract void send();
}

class connectBluetooth extends Connectivity {
    public void send() {
        sendViaBluetooth();
    }
    private void sendViaBluetooth() {
        System.out.println("Sending via Bluetooth");
    }
}

class connectNFC extends Connectivity {
    public void send() {
        sendViaNFC();
    }
    public void sendViaNFC() {
        System.out.println("Sending via NFC");
    }
}

class ConnectivityCompp {
    private List<Connectivity> technologies;
    public ConnectivityCompp() {
        //Gets all the Connecting technologies
        Connectivity b = new connectBluetooth();
        Connectivity n = new connectNFC();
        List<Connectivity> list = new ArrayList<Connectivity>();
        list.add(b);
        list.add(n);
        technologies = list;
    }

    public void implement() {
        technologies.forEach(tech -> tech.send());
    }
}

class SolutionTester{
    public void testSolution() {
        CallingMobile c = new CallingMobile();
        c.call();
        playAVI avi = new playAVI();
        playMKV mkv = new playMKV();
        playMP4 mp4 = new playMP4();
        avi.play();
        mkv.play();
        mp4.play();
        ConnectivityCompp cc = new ConnectivityCompp();
        cc.implement();
    }
}

/* SOLUTION TEST OUTPUT
Mobile Calling
Playing  AVI
Playing MKV
Playing MP4
Sending via Bluetooth
Sending via NFC
 */

