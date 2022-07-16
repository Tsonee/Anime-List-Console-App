package MainApp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Boolean mainMenu = true;

    static Boolean toWatchMenu = false;

    static Boolean finishedWatchingMenu = false;

    static Boolean currentlyWatchingMenu = false;

    public static void main(String args[]) throws ParseException, IOException {
        Scanner scanner = new Scanner(System.in);

        AnimeManager animeManager = new AnimeManager();

        SLSystem slSystem = new SLSystem(animeManager);

        slSystem.load();

        while(mainMenu)
        {
            System.out.println("-------------------------------");
            System.out.println("Chose your option:");
            System.out.println("1 -> To Watch list menu");
            System.out.println("2 -> Finished Watching list menu");
            System.out.println("3 -> Currently watching anime menu");
            System.out.println("0 -> Exit");
            System.out.println("-------------------------------");

            System.out.print("Enter your choice: ");

            int choice1 = scanner.nextInt();

            switch(choice1)
            {
                case 0 : mainMenu = false;
                break;
                case 1:
                    toWatchMenu = true;
                    startToWatchMenu(scanner,animeManager);
                    break;
                case 2: // Finished watching
                    finishedWatchingMenu = true;
                    startFinishedWatchingMenu(scanner,animeManager);
                    break;
                case 3: // currenty watching menu
                    currentlyWatchingMenu = true;
                    startCurrentlyWatchingAnimeMenu(scanner,animeManager);
                    break;
                default :
                    System.out.println("*******************************");
                    System.out.println("Wrong choice!");
                    System.out.println("*******************************");
                    break;
            }
        }

        slSystem.save();
    }

    private static void startCurrentlyWatchingAnimeMenu(Scanner scanner,AnimeManager animeManager) throws ParseException {

        while(currentlyWatchingMenu)
        {
            System.out.println("-------------------------------");
            System.out.println("Chose your option:");
            System.out.println("1 -> print your Currently Watching anime");
            System.out.println("2 -> finish watching");
            System.out.println("3 -> drop");
            System.out.println("0 -> return to main menu");
            System.out.println("-------------------------------");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch(choice)
            {
                case 0: currentlyWatchingMenu = false;
                break;
                case 1:
                    animeManager.printCurrentlyWatchingAnime();
                    break;
                case 2:
                    finishWatching(animeManager);
                    break;
                case 3:
                    dropCurrentlyWatchingAnime(animeManager);
                    break;
                default:
                    System.out.println("*******************************");
                    System.out.println("Wrong choice!");
                    System.out.println("*******************************");
            }
        }
    }

    private static void dropCurrentlyWatchingAnime(AnimeManager animeManager)
    {
        if(animeManager.getCurrentlyWatchingAnime() == null)
        {
            System.out.println("-------------------------------");
            System.out.println("You are currently not watching any anime, you can't drop!");
            System.out.println("-------------------------------");
        }else
        {
            animeManager.drop();
        }
    }

    private static void startFinishedWatchingMenu(Scanner scanner, AnimeManager animeManager)
    {
        while(finishedWatchingMenu)
        {
            System.out.println("-------------------------------");
            System.out.println("Chose your option:");
            System.out.println("1 -> print your Finished Watching list");
            System.out.println("0 -> return to main menu");
            System.out.println("-------------------------------");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 0: finishedWatchingMenu = false;
                break;
                case 1:
                    animeManager.printFinishedWathingList();
                    break;
                default:
                    System.out.println("*******************************");
                    System.out.println("Wrong choice!");
                    System.out.println("*******************************");
            }
        }
    }

    static void startToWatchMenu(Scanner scanner, AnimeManager animeManager)
    {
        while(toWatchMenu)
        {
            System.out.println("-------------------------------");
            System.out.println("Chose your option:");
            System.out.println("1 -> print your To Watch list");
            System.out.println("2 -> add a new anime to your To Watch list");
            System.out.println("3 -> remove an anime from your To Watch list");
            System.out.println("4 -> set an anime to your currently watching anime");
            System.out.println("0 - > return to main menu");
            System.out.println("-------------------------------");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice)
            {
                case 0 : toWatchMenu = false;
                break;
                case 1 :
                    animeManager.printToWatchList();
                    break;
                case 2:
                    addToToWatchList(animeManager);
                    break;
                case 3:
                    removeFromToWatchList(animeManager);
                    break;
                case 4:
                    setToCurrentlyWatchingAnime(animeManager);
                    break;
                default :
                    System.out.println("*******************************");
                    System.out.println("Wrong choice!");
                    System.out.println("*******************************");
            }
        }
    }

    private static void finishWatching(AnimeManager animeManager) throws ParseException {
        if(animeManager.getCurrentlyWatchingAnime() != null) {
            Scanner sc = new Scanner(System.in);
            Mark mark = Mark.NONE;

            System.out.println("1 -> Super Great");
            System.out.println("2 -> Greate");
            System.out.println("3 -> Mid");
            System.out.println("4 -> Bad");

            System.out.print("Enter a mark: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    mark = Mark.SUPERGREATE;
                    break;
                case 2:
                    mark = Mark.GREATE;
                    break;
                case 3:
                    mark = Mark.MID;
                    break;
                case 4:
                    mark = Mark.BAD;
                    break;
            }

            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter a finish date(dd mm yyyy): ");
            MyDate temp = new MyDate(sc1.nextInt(),sc1.nextInt(),sc1.nextInt());


            animeManager.finishWatching(mark, temp);
        }else
        {
            System.out.println("_____________________________________________");
            System.out.println("You are currently not watching any anime, you can't finish watching!");
            System.out.println("_____________________________________________");
        }
    }

    private static void removeFromToWatchList(AnimeManager animeManager)
    {
        if(animeManager.getToWatchList().isEmpty())
        {
            System.out.println("_____________________________________________");
            System.out.println("You can't remove an anime from an empty list!");
            System.out.println("_____________________________________________");
        }
        else
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name of an anime your want to remove: ");
            String name = scanner.nextLine();

            animeManager.toWatchRemove(name);
        }
    }

    private static void setToCurrentlyWatchingAnime(AnimeManager animeManager)
    {

        if(animeManager.getToWatchList().isEmpty() == true)
        {
            System.out.println("_____________________________________________");
            System.out.println("Your To Watch list is empty, you can't set anything to currently watching!");
            System.out.println("_____________________________________________");
        }else if(animeManager.getCurrentlyWatchingAnime() != null)
        {
            System.out.println("_____________________________________________");
            System.out.println("You are already watching an anime. You can drop it if you want in the cwam.");
            System.out.println("_____________________________________________");
        }else
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name of an anime you want to watch now: ");
            String name = scanner.nextLine();

            animeManager.setToCurrentlyWatching(name);
        }
    }
    private static void addToToWatchList(AnimeManager animeManager)
    {
        Scanner sc = new Scanner(System.in);
        MyAnime temp = new MyAnime();


        System.out.print("Name: ");
        temp.name = sc.nextLine();

        System.out.print("Number of seasons: ");
        temp.season = sc.nextInt();

        System.out.print("Finished Airing(true/false): ");// dodati catch block
        temp.finishedAiring = sc.nextBoolean();

        System.out.print("Year of release: ");
        temp.releaseYear = sc.nextInt();

        System.out.print("Number of episodes: ");
        temp.episodeNumber = sc.nextInt();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Genre(Ex1 Ex2 Ex3 Ex4):");
        temp.genre = sc1.nextLine();

        animeManager.toWatchListAdd(temp);
    }


}