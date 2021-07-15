import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


class FileDownload{

  public static void main(String args[]){
    if (args.length!=2){
      System.out.println(
        "Proper Usage: java FileDownload SourceFileURL OutputFileName");
      System.out.println(
    	"For example:java FileDownload http://myflex.org/yf/nyc.jpg nyc.jpg");
      System.exit(-1);
    }

    URLConnection fileStream=null;
 
  try(  OutputStream out = new FileOutputStream(args[1]);
		InputStream in = new URL(args[0]).openConnection().getInputStream();){

    // Read a remote file and save it in the local one
    byte[] buff = new byte[18000];
    int length;
    int z=0;
    System.out.println("Starting the download from " + args[0]);
    while ((length = in.read(buff)) > 0) {
        out.write(buff, 0, length);
        z++;
        System.out.println(z);
    }
    System.out.println("Finished downloading the file " + args[1]);
  } catch (Exception e){
     e.printStackTrace();
  } 
 }
}
