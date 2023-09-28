package gh2;


import deque.Deque;

//Note: This file will not compile until you complete the Deque implementations
public class HarpString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */

    private Deque<Double> buffer;
    public Deque<Double> getBuffer(){
        return buffer;
    }

    /* Create a guitar string of the given frequency.  */
    public HarpString(double frequency) {
        int capacity;
        capacity = (int) Math.round(SR/frequency);
        buffer= new Deque<>();
        buffer.addFirst(0.0);
        for (int i = 0; i < capacity-1; i++) {
            buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {

        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        new HarpString(SR/buffer.size());
        for(int i=0;i< buffer.size();i++){
            buffer.removeLast();
            buffer.addFirst(Math.random()-0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double frontnow = buffer.removeFirst();
        double average = buffer.get(0);
        buffer.addLast((frontnow+average)/2*DECAY);

    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}