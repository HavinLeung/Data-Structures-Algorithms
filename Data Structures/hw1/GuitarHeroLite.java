/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHeroLite {

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        synthesizer.GuitarString[] strings = new synthesizer.GuitarString[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i++) {
            strings[i] = new synthesizer.GuitarString(440 * Math.pow(2, (double) (i - 24) / 12));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (!(index < 0 || index >= keyboard.length())) {
                    strings[index].pluck();
                }

            }

        /* compute the superposition of samples */
            double sample = 0;
            for (synthesizer.GuitarString gtrStr : strings) {
                sample += gtrStr.sample();
                gtrStr.tic();
            }

        /* play the sample on standard audio */
            StdAudio.play(sample);
        }
    }
}

