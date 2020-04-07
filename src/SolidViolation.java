//INTERFACE SEGREGATION
interface MobileCore {
    public void call();
    public void playVideo();
    public void playMusic();
    public void viewPhotos();
}

class Mobile implements MobileCore {
    @Override
    public void call() {
        System.out.println("Mobile Calling");
    }

    @Override
    public void playMusic() {
        PlayAudio pa = new PlayAudio();
        pa.playMP3();
        pa.playWAV();
    }

    @Override
    public void playVideo() {
        PlayVideo pv = new PlayVideo();
        pv.playAVI();
        pv.playMKV();
        pv.playMp4();
    }

    @Override
    public void viewPhotos() {
        System.out.println("Viewing image");
    }
}

//LISKOWS PRINCIPLE
class BurnerPhonee extends Mobile {
    public void call() {
        System.out.println("Calling from a burner phone");
    }

    public void destroyPhone() {
        System.out.println("Self destroying phone");
    }
}

//Single Responsibility + Open Closed Violation
class PlayVideo {
    public void playMp4() {
        System.out.println("Playing MP4");
    }

    public void playAVI() {
        //AVI logic
        System.out.println("Playing AVI");
    }

    public void playMKV() {
        //MKV logic
        System.out.println("Playing MKV");
    }
}

class PlayAudio {
    public void playMP3() {
        System.out.println("Playing MP3");
    }

    public void playWAV() {
        System.out.println("Playing WAV");
    }
}

//DEPENDENCY INVERSION
class ConnectBluetooth {
    public void sendViaBluetooth() {
        System.out.println("Sending via Bluetooth");
    }


}

class ConnectNFC {
    public void sendViaNFC() {
        System.out.println("Sending via NFC");
    }
}

class ConnectivitiyComp {
    ConnectBluetooth b = new ConnectBluetooth();
    ConnectNFC n = new ConnectNFC();
    public void implement() {
        b.sendViaBluetooth();
        n.sendViaNFC();

    }
}

class ViolationTester {
    public void testViolation() {
        Mobile m = new Mobile();
        m.call();
        m.playVideo();
        ConnectivitiyComp c = new ConnectivitiyComp();
        c.implement();
    }
}

/*VIOLATION TEST OUTPUT
----------------
Mobile Calling
Playing AVI
Playing MKV
Playing MP4
Sending via Bluetooth
Sending via NFC
 */