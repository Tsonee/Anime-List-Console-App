package MainApp;

import java.util.ArrayList;

abstract public class Anime
{
    protected String name;
    protected int season;
    protected boolean finishedAiring;
    protected int releaseYear;
    protected String genre;
    protected int episodeNumber;

    public String getName()
    {
        return this.name;
    }

    public int getSeason()
    {
        return this.season;
    }

    public boolean getFinishedAiring()
    {
        return this.finishedAiring;
    }

    public int getReleaseYear()
    {
        return this.releaseYear;
    }

    public int getEpisodeNumber()
    {
        return this.episodeNumber;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public void setSeason(int season)
    {
        this.season = season;
    }

    public void setFinishedAiring(boolean finishedAiring)
    {
        this.finishedAiring = finishedAiring;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public void setEpisodeNumber(int episodeNumber)
    {
        this.episodeNumber = episodeNumber;
    }
}
