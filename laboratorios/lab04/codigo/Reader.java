import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
public class Reader
{
    //Arrays that save the Bees and the coordinates
    LinkedList<Double> lat = new LinkedList();
    LinkedList<Double> lon = new LinkedList();
    LinkedList<Double> alt = new LinkedList();
    LinkedList<Bee> bees=new LinkedList();
    public void leer (String dir) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            while ((line=br.readLine())!=null){
                splitString(line);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin();
    }    

    public void splitString(String s){
        String [] str=s.split(",");  
        try{
            lat.addFirst(Double.parseDouble(str[0]));
            lon.addFirst(Double.parseDouble(str[1]));
            alt.addFirst(Double.parseDouble(str[2]));
            Bee bee=new Bee(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.addFirst(bee);
        } catch (Exception e){
        }
    }

    public void getMaxMin(){
        double minlat=(double)Collections.min(lat);
        double maxlat=(double)Collections.max(lat);

        double minlon=(double)Collections.min(lon);
        double maxlon=(double)Collections.max(lon);

        double minalt=(double)Collections.min(alt);
        double maxalt=(double)Collections.max(alt);

        ArrayList<Double> mins=new ArrayList();
        mins.add(minlat);mins.add(minlon);mins.add(minalt);
        double midD=(minlat-maxlat)/2;
        double midW=(maxlon-minlon)/2;
        double midH=(maxalt-minalt)/2;
        double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));
        if (diagonal>100) {
            Octree octree=new Octree();
            octree.octree(bees,mins,midD,midW,midH);
        } else {
            choque();
        }
    }
    

    public void choque() {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (int i=0;i<bees.size();++i) {
            System.out.println(bees.poll().getLatitude()+","+bees.poll().getLongitude()+","+bees.poll().getAltitude());
        }
    }
}
