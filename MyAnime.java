package MainApp;

import java.util.ArrayList;
import java.util.Date;

public class MyAnime extends Anime
{
    private WatchingStatus status;
    private Mark mark;
    private MyDate finishDate;

    public MyAnime(String name, int season, boolean finishedAiring, int releaseYear, int episodeNumber, String genre)
    {
        super.name = name;
        super.season = season;
        super.finishedAiring = finishedAiring;
        super.releaseYear = releaseYear;
        super.episodeNumber = episodeNumber;
        super.genre = genre;
        this.status = WatchingStatus.TOWATCH;
        this.mark = Mark.NONE;
    }

    public MyAnime()
    {
        this.genre = null;
        this.status = WatchingStatus.NONE;
        this.mark = Mark.NONE;
        this.finishDate = null;
    }

    void normalDisplay()
    {
        System.out.println("Name: " + super.name);
        System.out.println("Seasons: " + super.season);
        System.out.println("Finished Airing: " + (finishedAiring == true ? "Yes" : "No"));
        System.out.println("Year of release: " + releaseYear);
        System.out.println("Genre: " + genre);
        System.out.println("Number of episodes: " + episodeNumber);
    }

    void finishedDisplay()
    {
        System.out.println("Name: " + super.name);
        System.out.println("Seasons: " + super.season);
        System.out.println("Finished Airing: " + (finishedAiring == true ? "Yes" : "No"));
        System.out.println("Year of release: " + releaseYear);
        System.out.println("Genre: " + genre);
        System.out.println("Number of episodes: " + episodeNumber);
        System.out.println("Status: " + this.status);
        System.out.println("Mark: " + this.mark);
        System.out.print("Finish Date: ");
        if(this.getFinishDate() != null){
            System.out.println(this.getFinishDate().toString());
        }else System.out.println("NULL");

    }

    void currDisplay()
    {
        System.out.println("Name: " + super.name);
        System.out.println("Seasons: " + super.season);
        System.out.println("Number of episodes: " + episodeNumber);
    }

    public WatchingStatus getStatus()
    {
        return this.status;
    }

    public Mark getMark()
    {
        return this.mark;
    }

    public MyDate getFinishDate()
    {
        return this.finishDate;
    }

    public void setStatus(WatchingStatus status)
    {
        this.status = status;
    }

    public void setMark(Mark mark)
    {
        this.mark = mark;
    }

    public void setFinishDate(MyDate finishDate)
    {
        this.finishDate = finishDate;
    }
}
