package MainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SLSystem
{
    private AnimeManager animeManager;

    private final String toWatchFileName = "ToWatchFile.txt";
    private final String FinishedWatchingFileName = "FinishedWatchingFile.txt";
    private final String currentlyWatchingFileName = "CurrentlyWatchingFile.txt";

    private File toWatchFile = new File(toWatchFileName);
    private File finishedWatchingFile = new File(FinishedWatchingFileName);
    private File currentlyWatchingFile = new File(currentlyWatchingFileName);

    public SLSystem(AnimeManager animeManager)
    {
        this.animeManager = animeManager;
    }

    public void save() throws IOException
    {
        saveToWatchList();
        saveFinishedWatchingList();
        saveCurrentlyWatchingAnime();
    }

    public void load() throws FileNotFoundException
    {
        if(toWatchFile.length() != 0)
        {
            loadToWatchList();
        }

        if(finishedWatchingFile.length() != 0)
        {
            loadFinishedWatchingList();
        }

        if(currentlyWatchingFile.length() != 0)
        {
            loadCurrentlyWatchingAnime();
        }
    }

    private void saveToWatchList() throws IOException
    {
        FileWriter writer = new FileWriter(toWatchFile);

        if(!this.animeManager.getToWatchList().isEmpty()) {
            writer.write(this.animeManager.getToWatchList().size() + "\n");
        }

        for (int i = 0; i < this.animeManager.getToWatchList().size(); i++)
        {
            saveMyAnime(writer,this.animeManager.getToWatchList().get(i));
        }

        writer.close();
    }

    private void saveFinishedWatchingList() throws IOException
    {
        FileWriter writer = new FileWriter(this.finishedWatchingFile);

        if(!this.animeManager.getFinishedWatchingList().isEmpty())
            writer.write(this.animeManager.getFinishedWatchingList().size() + "\n");

        for(int i = 0; i < this.animeManager.getFinishedWatchingList().size(); i++)
        {
            saveMyAnime(writer, this.animeManager.getFinishedWatchingList().get(i));
        }

        writer.close();
    }

    private void saveCurrentlyWatchingAnime() throws IOException
    {
        FileWriter writer = new FileWriter(currentlyWatchingFileName);
        if(this.animeManager.getCurrentlyWatchingAnime() != null)
            saveMyAnime(writer,this.animeManager.getCurrentlyWatchingAnime());

        writer.close();
    }

    private void saveMyAnime(FileWriter writer, MyAnime anime) throws IOException
    {
        writer.write(anime.name + "\n");
        writer.write(anime.season + "\n");
        writer.write(anime.finishedAiring + "\n");
        writer.write(anime.releaseYear + "\n");
        writer.write(anime.episodeNumber + "\n");
        writer.write(anime.genre + "\n");
        writer.write(anime.getStatus() + "\n");
        writer.write(anime.getMark() + "\n");
        saveDate(writer,anime);
    }

    private void loadToWatchList() throws FileNotFoundException
    {
        Scanner reader = new Scanner(toWatchFile);

        int size = reader.nextInt();
        reader.nextLine();

        for(int i = 0; i < size; i++)
        {
            this.animeManager.toWatchListAdd(loadMyAnime(reader));
        }

        reader.close();
    }

    private void loadFinishedWatchingList()throws FileNotFoundException
    {
        Scanner reader = new Scanner(finishedWatchingFile);

        int size = reader.nextInt();
        reader.nextLine();

        if(finishedWatchingFile.canRead())
        {
            for(int i = 0; i < size; i++)
            {
                this.animeManager.getFinishedWatchingList().add(loadMyAnime(reader));
            }
        }

        reader.close();
    }

    private MyAnime loadMyAnime(Scanner reader)
    {
        MyAnime anime = new MyAnime();

        anime.name = reader.nextLine();
        anime.season = reader.nextInt();
        anime.finishedAiring = reader.nextBoolean();
        anime.releaseYear = reader.nextInt();
        anime.episodeNumber = reader.nextInt();
        reader.nextLine();
        anime.genre = reader.nextLine();
        anime.setStatus(WatchingStatus.valueOf(reader.nextLine()));
        anime.setMark(Mark.valueOf(reader.nextLine()));
        if(reader.hasNextInt()){
            anime.setFinishDate(loadDate(reader));
            reader.nextLine();
        }


        return anime;
    }

    public void saveDate(FileWriter writer,MyAnime anime) throws IOException {
        if(anime.getFinishDate() != null)
        {
            writer.write(anime.getFinishDate().getDay() + " ");
            writer.write(anime.getFinishDate().getMonth() + " ");
            writer.write(anime.getFinishDate().getYear() + "\n");
        }

    }
    public MyDate loadDate(Scanner reader)
    {
        if(reader.hasNextInt()) {
            MyDate newDate = new MyDate();
            newDate.setDay(reader.nextInt());
            newDate.setMonth(reader.nextInt());
            newDate.setYear(reader.nextInt());
            return newDate;
        }
        return null;
    }

    private void loadCurrentlyWatchingAnime() throws FileNotFoundException {
        Scanner reader = new Scanner(currentlyWatchingFile);

        this.animeManager.setCurrentlyWatchingAnime(loadMyAnime(reader));

        reader.close();
    }

}
