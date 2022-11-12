package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import deque.Deque;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    GuitarString stringA = new GuitarString(CONCERT_A);
    GuitarString stringC = new GuitarString(CONCERT_C);

    private  static GuitarString[] CONCERTSTRING ;
    private static  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void STRINGinit(){
        CONCERTSTRING = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double frequency = 440*Math.pow(2,(i-24.0)/12.0);
            CONCERTSTRING[i] = new GuitarString(frequency);
        }
    }


    public static int findposition(char key){
        int i;
        for ( i = 0; i < keyboard.length(); i++) {
            if(key==keyboard.charAt(i)){
                return i;
            }
        }
        return -1;
    }

    public static double sampling(){
        double sample = 0;
        for (int i = 0; i < CONCERTSTRING.length; i++) {
            sample += CONCERTSTRING[i].sample();
        }
        return sample;
    }
    public static void tic(){
        for (int i = 0; i < CONCERTSTRING.length; i++) {
            CONCERTSTRING[i].tic();
        }
    }
    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        STRINGinit();
      //  GuitarString stringA = new GuitarString(CONCERT_A);
        // GuitarString stringC = new GuitarString(CONCERT_C);
        while (true) {

            /* check if the user has typed a key; if so, process it*/
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
              int position =findposition(key);

                  if(position>=0){
                CONCERTSTRING[position].pluck();
                      System.out.println(44100/CONCERTSTRING[position].getBuffer().size());
                }

             //     CONCERTSTRING[0].pluck();
           //     if (key == 'a') {
             //       CONCERTSTRING[0].pluck();
               // } else if (key == 'c') {
                 //   CONCERTSTRING[3].pluck();
                //}
            }

            /* compute the superposition of samples position =  findposition(key);*/
           double sample = sampling();

            /* play the sample on standard audio */

            StdAudio.play(sample);
            tic();

         // CONCERTSTRING[position].tic();
            //StdAudio.play(440);
            /* advance the simulation of each guitar string by one step */
          //  tic();
        }
    }
    }



