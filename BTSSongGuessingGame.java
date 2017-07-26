/**
 * A song guessing version of the classic number guessing game.
 *
 * This game only includes BTS Songs (not all of them) but most of the well known ones as of  July 25, 2017.
 *
 * You will first be prompted to guess what year the song was released in since debut
 * (2013, 2014, 2015, 2016, and 2017).
 *
 * Then you will be prompted to guess what album the song is in (excluding their Japanese releases).
 *
 * The albums include : 2 Cool 4 Skool, O!RUL8,2 ?, Skool Luv Affair, Dark & Wild,
 * The Most Beautiful Moment In Life Pt. 1,The Most Beautiful Moment In Life Pt. 2,
 * The Most Beautiful Moment In Life Young Forever, Wings, and Wings You Never Walk Alone
 *
 * Lastly, you will be prompted to guess the song from said album.
 * ARMYs Enjoy! :D
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class BTSSongGuessingGame {

    int[] songYear = new int[]{2013, 2014, 2015, 2016, 2017}; // array containing the years since debut (Happy 4th Anniversary Bangtan!)

    String[] albumArray = new String[]{"2 Cool 4 Skool", "O!RUL8,2 ?", "Skool Luv Affair", "Dark & Wild",
            "The Most Beautiful Moment In Life Pt. 1", "The Most Beautiful Moment In Life Pt. 2",
            "The Most Beautiful Moment In Life Young Forever", "Wings", "Wings You Never Walk Alone"}; // array of all the album titles

    // arrays of all the songs in each album (excluding some that I don't listen to as often, sorry hardcore fans)
    String[] tooCool = new String[]{"We Are Bulletproof Pt.2", "No More Dream", "Path", "I Like You", "2 Cool 4 Skool"};
    String[] orul = new String[]{"N.O.", "Cypher Pt.1", "Coffee", "Attack on Bangtan", "O!RUL8,2 ?"};
    String[] sla = new String[]{"Miss Right", "Boy In Luv", "Just One Day", "Cypher Pt.2", "Tomorrow", "Spine Breaker", "Skool Luv Affair"};
    String[] dw = new String[]{"Danger", "War of Hormone", "Let Me Know", "Rain", "Cypher Pt.3", "24/7=Heaven", "Blanket Kick", "Dark & Wild"};
    String[] hyyh1 = new String[]{"I Need U", "Hold Me Tight", "Dope", "Boyz With Fun", "Converse High", "Love Is Not Over", "The Most Beautiful Moment In Life Pt. 1"};
    String[] hyyh2 = new String[]{"Run", "Butterfly", "Whalien 52", "Baepsae", "House Of Cards", "Autumn Leaves", "Ma City", "The Most Beautiful Moment In Life Pt. 2"};
    String[] hyyhYF = new String[]{"Young Forever", "Save Me", "Fire", "Butterfly", "I Need U", "Run", "Baepsae", "House Of Cards", "Autumn Leaves", "Hold Me Tight", "Dope", "The Most Beautiful Moment in Life Young Forever"};
    String[] wings = new String[]{"Wings", "Blood Sweat And Tears", "Begin", "Lie", "Stigma", "First Love", "Reflection", "Awake", "MAMA", "Cypher Pt.4", "Lost", "21st Century Girls", "Two!Three!", "Am I Wrong", "Wings"};
    String[] ynwa = new String[]{"Wings", "Spring Day", "Not Today", "Blood Sweat And Tears", "Cypher Pt.4", "Lost", "21st Century Girls", "Two!Three!", "Wings You Never Walk Alone"};

    // split albums into arrays by year
    String[][] album2013 = new String[][]{tooCool, orul};
    String[][] album2014 = new String[][]{sla, dw};
    String[][] album2015 = new String[][]{hyyh1, hyyh2};
    String[][] album2016 = new String[][]{hyyhYF, wings};

    public int randomYear(int[] debutTilNow) { // generate a random year from the years since debut array

        int year = new Random().nextInt(debutTilNow.length);
        return debutTilNow[year];
    }

    public String[] randomAlbum(String[][] albumA) { // will be used by randA(int y) to generate random album

        int albumIndex = new Random().nextInt(albumA.length);
        return albumA[albumIndex];
    }

    public String[] randA(int y) { // generate random album

        String[] a;

        if (y == 2013) {
            a = randomAlbum(album2013);
        } else if (y == 2014) {
            a = randomAlbum(album2014);
        } else if (y == 2015) {
            a = randomAlbum(album2015);
        } else if (y == 2016) {
            a = randomAlbum(album2016);
        } else
            a = ynwa;

        return a;
    }

    public String randomSongFromAlbum(String[] album) { // generate random song

        int songIndex = new Random().nextInt(album.length - 1);
        return album[songIndex];
    }

    public void checkYearGuess(int x) { // check the user's year guess

        System.out.println("I'm thinking of a popular BTS song from an album that they've released since their debut in 2013.");
        System.out.println("First try and guess the year the song was released ________");

        int yg = getYearGuess();

        if (yg == x) {
            System.out.println("Yes! That's the year the song was released. Good Job!");
        } else {
            System.out.println("Actually the song I'm thinking of was released in " + x);
        }


    }

    public void checkAlbumGuess(String[] a) { // check the user's album guess
        System.out.println("Now try and guess the album the song is in ______");

        String ag = getAlbumGuess();

        if (ag.equalsIgnoreCase("2 Cool 4 Skool") && a == tooCool) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("O!RUL8,2 ?") && a == orul) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("Skool Luv Affair") && a == sla) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("Dark & Wild") && a == dw) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("The Most Beautiful Moment In Life Pt. 1") && a == hyyh1) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("The Most Beautiful Moment In Life Pt. 2") && a == hyyh2) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("The Most Beautiful Moment In Life Young Forever") && a == hyyhYF) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("Wings") && a == wings) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else if (ag.equalsIgnoreCase("Wings You Never Walk Alone") && a == ynwa) {
            System.out.println("Yup, the song I'm thinking of is in " + ag);
        } else {
            System.out.println("Good guess, " + ag + " was a really good album, but the song I'm thinking of is in the album " + a[a.length - 1]);
        }


    }

    public void checkSongGuess(String s) { // check the user's song guess

        System.out.println("Now try and guess the song I'm thinking of from that album ________");

        String sg = getAlbumGuess();

        if (s.equalsIgnoreCase(sg)) {
            System.out.println("Yes! That's the song I had in mind. It's one of my favorites :)");
        } else {
            System.out.println("Close! " + sg + " is a really great song, but I was actually thinking of " + s);
        }


    }

    public int getYearGuess() { // get the user's year guess

        BufferedReader yearGuess;

        try {
            yearGuess =
                    new BufferedReader(new InputStreamReader(System.in));

            return Integer.parseInt(yearGuess.readLine());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public String getAlbumGuess() { // get the user's album guess

        BufferedReader albumGuess;

        try {
            albumGuess =
                    new BufferedReader(new InputStreamReader(System.in));

            return albumGuess.readLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }

    }

    public String getSongGuess() { // get the user's song guess

        BufferedReader songGuess;

        try {
            songGuess =
                    new BufferedReader(new InputStreamReader(System.in));

            return songGuess.readLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }

    }


    public static void main(String[] args) {

        BTSSongGuessingGame play = new BTSSongGuessingGame();

        int song_year = play.randomYear(play.songYear); // year the song was released
        String[] song_array = play.randA(song_year); // album from that year
        String song_name = play.randomSongFromAlbum(song_array); // song from that album

        play.checkYearGuess(song_year);
        play.checkAlbumGuess(song_array);
        play.checkSongGuess(song_name);

    }

}
